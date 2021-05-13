package DAO;

import Conexion.PostgresSqlConexion;
import Modelo.BitacoraRolUsuario;
import Modelo.BitacoraUsuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BitacoraDAO {
    
    PostgresSqlConexion conexion= PostgresSqlConexion.getPostgresConexion();
        
    public enum ClavesUsuario{
        usuario_modificador,
        id_evento,
        fecha,
        nombre_usuario;
    }
    
    public enum ClavesRolUsuario{
        usuario_modificador,
        id_evento,
        fecha,
        nombre_usuario,
        id_rol,
        id_aplicacion;
    }
    
    public ArrayList<BitacoraUsuario> listarUsuarios(){
        return buscarUsuarios(ClavesUsuario.id_evento, "");
    }

    public ArrayList<BitacoraRolUsuario> listarRolesUsuarios() {
        return buscarUsuariosRoles(ClavesRolUsuario.id_evento, "");
    }
    
    public ArrayList<BitacoraUsuario> buscarUsuarios(BitacoraDAO.ClavesUsuario clave, String valor) {
        conexion.conectarse();
        ArrayList<BitacoraUsuario> listaRes = new ArrayList<>();
        PreparedStatement pstm = null;
        String query = "";
        try {
            switch (clave) {
                case usuario_modificador:
                    query = "select * from usuario_bitacora where lower(usuario_modificador) like lower(?) ";
                    pstm = conexion.prepareStatement(query);
                    pstm.setString(1, valor + "%");
                    break;
                case id_evento:
                    query = "select * from usuario_bitacora where lower(id_evento) like lower(?)";
                    pstm = conexion.prepareStatement(query);
                    pstm.setString(1, valor + "%");
                    break;
                case fecha:
                    query = "select * from usuario_bitacora where fecha like ?";
                    pstm = conexion.prepareStatement(query);
                    pstm.setTimestamp(1, java.sql.Timestamp.valueOf(valor));
                    break;
                case nombre_usuario:
                    query = "select * from usuario_bitacora where lower(nombre_usuario) like lower(?)";
                    pstm = conexion.prepareStatement(query);
                    pstm.setString(1, valor + "%");
                    break;
            }
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                BitacoraUsuario u = new BitacoraUsuario(rs.getString("id_evento"), rs.getString("usuario_modificador"), rs.getTimestamp("fecha"), rs.getString("nombre_usuario"));
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
    
     public ArrayList<BitacoraRolUsuario> buscarUsuariosRoles(BitacoraDAO.ClavesRolUsuario clave, String valor) {
        conexion.conectarse();
        ArrayList<BitacoraRolUsuario> listaRes = new ArrayList<>();
        PreparedStatement pstm = null;
        String query = "";
        try {
            switch (clave) {
                case usuario_modificador:
                    query = "select * from usuario_rol_bitacora where lower(usuario_modificador) like lower(?) ";
                    pstm = conexion.prepareStatement(query);
                    pstm.setString(1, valor + "%");
                    break;
                case id_evento:
                    query = "select * from usuario_rol_bitacora where lower(id_evento) like lower(?)";
                    pstm = conexion.prepareStatement(query);
                    pstm.setString(1, valor + "%");
                    break;
                case fecha:
                    query = "select * from usuario_rol_bitacora where fecha like ?";
                    pstm = conexion.prepareStatement(query);
                    pstm.setTimestamp(1, java.sql.Timestamp.valueOf(valor));
                    break;
                case nombre_usuario:
                    query = "select * from usuario_rol_bitacora where lower(nombre_usuario) like lower(?)";
                    pstm = conexion.prepareStatement(query);
                    pstm.setString(1, valor + "%");
                    break;
                case id_rol:
                    System.out.println("soooooooooooooooooooo");
                    query = "select * from usuario_rol_bitacora where lower(id_rol) like lower(?)";
                    pstm = conexion.prepareStatement(query);
                    pstm.setString(1, valor + "%");
                    break;
                case id_aplicacion:
                    query = "select * from usuario_rol_bitacora where lower(id_aplicacion) like lower(?)";
                    pstm = conexion.prepareStatement(query);
                    pstm.setString(1, valor + "%");
                    break;
            }
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                BitacoraRolUsuario u = new BitacoraRolUsuario(rs.getString("id_evento"), rs.getString("usuario_modificador"), rs.getTimestamp("fecha"), rs.getString("nombre_usuario"), rs.getString("id_rol"), rs.getString("id_aplicacion"));
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
