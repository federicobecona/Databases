package DAO;

import Conexion.PostgresSqlConexion;
import Modelo.Rol;
import Modelo.Usuario;
import Modelo.UsuarioRol;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioDAO {

    PostgresSqlConexion conexion = PostgresSqlConexion.getPostgresConexion();

    public enum Claves {
        CI,
        nombre,
        codigo_estado;
    }

    public boolean insertarUsuario(Usuario usuario, String pass) {
        conexion.conectarse();
        try {
            
            PreparedStatement pstm = conexion.prepareStatement("INSERT INTO usuario(nombre_usuario,ci,cod_estado) VALUES(?,?,?)");
            pstm.setString(1, usuario.getNombre_usuario());
            pstm.setString(2, usuario.getCI());
            pstm.setString(3, usuario.getCodigo_estado());
            pstm.executeUpdate();
            pstm.close();
            
            pstm = conexion.prepareStatement("SET ROLE rol_admin_app"); //ARREGLAR
            pstm.execute();
            pstm.close();            
            
            pstm = conexion.prepareStatement("CREATE USER "+ usuario.getNombre_usuario() +" PASSWORD '"+PostgresSqlConexion.obfuscate(pass)+"'"); 
            pstm.execute();
            pstm.close();
            
            pstm = conexion.prepareStatement("GRANT \"rol_usuario\" TO "+usuario.getNombre_usuario()); //ARREGLAR
            pstm.execute();
            pstm.close();
            
            pstm = conexion.prepareStatement("INSERT INTO usuario_bitacora(usuario_modificador,id_evento,fecha,nombre_usuario) VALUES(?, ?, CURRENT_TIMESTAMP, ?)"); //ARREGLAR
            pstm.setString(1, conexion.getUsuario());
            pstm.setString(2, "INSERT");
            pstm.setString(3, usuario.getNombre_usuario());
            pstm.execute();
            pstm.close();            
            
            conexion.commit();
            conexion.desconectar();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PostgresSqlConexion.class.getName()).log(Level.SEVERE, null, ex);
            conexion.rollback();
            conexion.desconectar();
        }
        return false;
    }

    public ArrayList<Usuario> listarUsuarios() {
        return buscarUsuarios(Claves.CI, "");
    }

    public ArrayList<Usuario> buscarUsuarios(UsuarioDAO.Claves clave, String valor) {
        conexion.conectarse();
        ArrayList<Usuario> listaRes = new ArrayList<>();
        PreparedStatement pstm;
        String query = "";
        try {
            switch (clave) {
                case CI:
                    query = "select * from usuario where lower(ci) like lower(?)";
                    break;
                case nombre:
                    query = "select * from usuario where lower(nombre_usuario) like lower(?)";
                    break;
                case codigo_estado:
                    query = "select * from usuario where lower(cod_estado) like lower(?)";
                    break;
            }
            pstm = conexion.prepareStatement(query);
            pstm.setString(1, valor + "%");
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Usuario u = new Usuario(rs.getString("nombre_usuario"), rs.getString("cod_estado"), rs.getString("ci"));
                listaRes.add(u);
            }
            rs.close();
            pstm.close();
            conexion.desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(AplicacionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaRes;
    }

    public void actualizarEstadoUsuario(Usuario usuario) {
        conexion.conectarse();
        try {
            PreparedStatement pstm = conexion.prepareStatement("UPDATE usuario SET cod_estado=? where nombre_usuario=?");
            pstm.setString(1, usuario.getCodigo_estado());
            pstm.setString(2, usuario.getNombre_usuario());
            pstm.executeUpdate();
            pstm.close();
            
            pstm = conexion.prepareStatement("INSERT INTO usuario_bitacora(usuario_modificador,id_evento,fecha,nombre_usuario) VALUES(?, ?, CURRENT_TIMESTAMP, ?)"); //ARREGLAR
            pstm.setString(1, conexion.getUsuario());
            pstm.setString(2, "APPROVE");
            pstm.setString(3, usuario.getNombre_usuario());
            pstm.execute();
            pstm.close();
            
            conexion.commit();
        } catch (SQLException ex) {
            Logger.getLogger(PostgresSqlConexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        conexion.desconectar();
    }

    public boolean asignarUsuarioRol(Rol rol, Usuario usuario) {
        conexion.conectarse();
        try {
            PreparedStatement pstm = conexion.prepareStatement("INSERT INTO usuario_rol(id_rol, id_aplicacion, nombre_usuario, cod_estado) VALUES(?,?,?,?)");
            pstm.setString(1, rol.getId_rol());
            pstm.setString(2, rol.getId_aplicacion());
            pstm.setString(3, usuario.getNombre_usuario());
            pstm.setString(4, "PEND");
            pstm.executeUpdate();
            pstm.close();
            
            pstm = conexion.prepareStatement("INSERT INTO usuario_rol_bitacora(usuario_modificador,id_evento,id_rol,id_aplicacion,fecha,nombre_usuario) VALUES(CURRENT_USER, ?, ?, ?, CURRENT_TIMESTAMP, ?)");
            pstm.setString(1, "INSERT");
            pstm.setString(2, rol.getId_rol());
            pstm.setString(3, rol.getId_aplicacion());
            pstm.setString(4, usuario.getNombre_usuario());
            pstm.executeUpdate();
            pstm.close();            
            
            conexion.commit();
            conexion.desconectar();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PostgresSqlConexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }
    
    public ArrayList<UsuarioRol> buscarUsuariosRoles(Usuario usuario) {
        try {
            conexion.conectarse();
            ArrayList<UsuarioRol> listaRes = new ArrayList<>();
            PreparedStatement pstm = conexion.prepareStatement("select ur.* from usuario_rol ur join vista_admin_apps vap on ur.id_aplicacion=vap.id_aplicacion where ur.nombre_usuario = ?");
            pstm.setString(1, usuario.getNombre_usuario());
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                UsuarioRol p = new UsuarioRol(rs.getString("id_rol"), rs.getString("id_aplicacion"), rs.getString("nombre_usuario"), rs.getString("cod_estado"));
                listaRes.add(p);
            }
            rs.close();
            pstm.close();
            conexion.desconectar();
            return listaRes;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Usuario> listarUsuariosPendientes() {
        conexion.conectarse();
        ArrayList<Usuario> listaRes = new ArrayList<>();
        PreparedStatement pstm;
        String query = "";
        try {
            pstm = conexion.prepareStatement("SELECT * FROM vista_usuarios_pendientes");
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Usuario u = new Usuario(rs.getString("nombre_usuario"), rs.getString("cod_estado"), rs.getString("ci"));
                listaRes.add(u);
            }
            rs.close();
            pstm.close();
            conexion.desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(AplicacionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaRes;
    }
}
