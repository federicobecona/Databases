package DAO;

import Conexion.PostgresSqlConexion;
import Modelo.Funcionalidad;
import Modelo.Rol;
import Modelo.UsuarioRol;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RolDAO {

    PostgresSqlConexion conexion = PostgresSqlConexion.getPostgresConexion();

    public enum Claves {
        id_aplicacion,
        id_rol;
    }

    public ArrayList<Rol> listarRoles() {
        return buscarRol(Claves.id_rol, "");
    }

    public ArrayList<Rol> buscarRol(RolDAO.Claves clave, String valor) {
        conexion.conectarse();
        ArrayList<Rol> listaRes = new ArrayList<>();
        PreparedStatement pstm;
        String query = "";
        try {
            switch (clave) {
                case id_rol:
                    query = "select r.* from rol r JOIN vista_admin_apps vap ON r.id_aplicacion = vap.id_aplicacion where lower(id_rol) like lower(?)";
                    break;
                case id_aplicacion:
                    query = "select r.* from rol r JOIN vista_admin_apps vap ON r.id_aplicacion = vap.id_aplicacion where lower(r.id_aplicacion) like lower(?)";
                    break;
            }
            pstm = conexion.prepareStatement(query);
            pstm.setString(1, valor + "%");
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Rol u = new Rol(rs.getString("id_rol"), rs.getString("id_aplicacion"));
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

    public boolean insertarRol(Rol rol) {
        conexion.conectarse();
        try {
            PreparedStatement pstm = conexion.prepareStatement("INSERT INTO rol(id_rol,id_aplicacion) VALUES(?,?)");
            pstm.setString(1, rol.getId_rol());
            pstm.setString(2, rol.getId_aplicacion());
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

    public boolean agregarFuncionalidad(Rol rol, Funcionalidad funcionalidad) {
        conexion.conectarse();
        try {
            PreparedStatement pstm = conexion.prepareStatement("INSERT INTO rol_funcionalidad(id_rol, id_aplicacion, nombre_funcionalidad) VALUES(?,?,?)");
            pstm.setString(1, rol.getId_rol());
            pstm.setString(2, rol.getId_aplicacion());
            pstm.setString(3, funcionalidad.getNombre_funcionalidad());
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

    public void eliminarFuncionalidad(Rol rol, Funcionalidad funcionalidad) throws SQLException {
        conexion.conectarse();
        try {
            PreparedStatement pstm = conexion.prepareStatement("DELETE FROM rol_funcionalidad where id_rol = ? and id_aplicacion = ? and nombre_funcionalidad = ?");
            pstm.setString(1, rol.getId_rol());
            pstm.setString(2, rol.getId_aplicacion());
            pstm.setString(3, funcionalidad.getNombre_funcionalidad());
            pstm.executeUpdate();
            pstm.close();
            conexion.commit();
        } catch (SQLException ex) {
            Logger.getLogger(PostgresSqlConexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        conexion.desconectar();
    }

    public ArrayList<Funcionalidad> buscarFuncionalidades(Rol rol) {
        ArrayList<Funcionalidad> listaRes = new ArrayList<>();
        try {
            conexion.conectarse();

            PreparedStatement pstm = conexion.prepareStatement("select * from funcionalidad f join rol_funcionalidad rf "
                    + "on f.nombre_funcionalidad=rf.nombre_funcionalidad and f.id_aplicacion=rf.id_aplicacion"
                    + "  where rf.id_rol = ? and rf.id_aplicacion = ?");
            pstm.setString(1, rol.getId_rol());
            pstm.setString(2, rol.getId_aplicacion());
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Funcionalidad p = new Funcionalidad(rs.getString("nombre_funcionalidad"), rs.getString("id_aplicacion"), rs.getString("descripcion"));
                listaRes.add(p);
            }
            rs.close();
            pstm.close();
            conexion.desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(RolDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaRes;
    }

    public ArrayList<UsuarioRol> listarUsuariosRolesPendientes() {
        conexion.conectarse();
        ArrayList<UsuarioRol> listaRes = new ArrayList<>();
        PreparedStatement pstm;
        String query = "";
        try {
            pstm = conexion.prepareStatement("SELECT * FROM vista_usuarios_roles_pendientes");
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                UsuarioRol u = new UsuarioRol(rs.getString("id_rol"), rs.getString("id_aplicacion"), rs.getString("nombre_usuario"), rs.getString("cod_estado"));
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

    public void actualizarEstadoRol(UsuarioRol usuario_rol, String evento) {
        conexion.conectarse();
        try {
            PreparedStatement pstm = conexion.prepareStatement("UPDATE usuario_rol SET cod_estado=? where id_rol=? AND id_aplicacion=? AND nombre_usuario=?");
            pstm.setString(1, usuario_rol.getCod_estado());
            pstm.setString(2, usuario_rol.getId_rol());
            pstm.setString(3, usuario_rol.getId_aplicacion());
            pstm.setString(4, usuario_rol.getNombre_usuario());
            pstm.executeUpdate();
            pstm.close();
            
            pstm = conexion.prepareStatement("INSERT INTO usuario_rol_bitacora(id_evento,fecha,usuario_modificador,id_rol,id_aplicacion,nombre_usuario) VALUES(?, CURRENT_TIMESTAMP, CURRENT_USER, ?, ?, ?)"); //ARREGLAR
            pstm.setString(1, evento);
            pstm.setString(2, usuario_rol.getId_rol());
            pstm.setString(3, usuario_rol.getId_aplicacion());
            pstm.setString(4, usuario_rol.getNombre_usuario());
            pstm.execute();
            pstm.close();

            if (usuario_rol.getId_rol().equals("adminApp")) {

                pstm = conexion.prepareStatement("SET ROLE rol_admin_app"); 
                pstm.execute();
                pstm.close();
                pstm = conexion.prepareStatement("GRANT \"rol_admin_app\" TO " + usuario_rol.getNombre_usuario());
                pstm.execute();
                pstm.close();
            }

            conexion.commit();
        } catch (SQLException ex) {
            Logger.getLogger(PostgresSqlConexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        conexion.desconectar();
    }

}
