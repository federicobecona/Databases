package DAO;

import Conexion.PostgresSqlConexion;
import Modelo.Aplicacion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AplicacionDAO {
    
    public enum Claves{
        id_aplicacion,
        nombre_aplicacion;
    }
    
    PostgresSqlConexion conexion = PostgresSqlConexion.getPostgresConexion();
    
    public boolean insertarAplicacion(Aplicacion app){
        conexion.conectarse();
        try {
            PreparedStatement pstm = conexion.prepareStatement("INSERT INTO aplicacion(id_aplicacion,nombre_aplicacion) VALUES(?,?)");
            pstm.setString(1, app.getId_aplicacion());
            pstm.setString(2, app.getNombre_aplicacion());
            pstm.executeUpdate();
            pstm.close();
            
            pstm = conexion.prepareStatement("INSERT INTO rol(id_aplicacion,id_rol) VALUES(?,'adminApp')");
            pstm.setString(1, app.getId_aplicacion());
            pstm.executeUpdate();
            pstm.close();
            
            
            
            pstm = conexion.prepareStatement("INSERT INTO usuario_rol(id_aplicacion,nombre_usuario,id_rol,cod_estado) VALUES(?,'postgres','adminApp','APR')");
            pstm.setString(1, app.getId_aplicacion());
            pstm.executeUpdate();
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
    
    public ArrayList<Aplicacion> listarAplicaciones(){
        return buscarAplicaciones(Claves.id_aplicacion, "");
    }
        
    public ArrayList<Aplicacion> buscarAplicaciones(Claves clave, String valor){
        conexion.conectarse();
        ArrayList<Aplicacion> listaRes = new ArrayList<>();
        PreparedStatement pstm;
        String query = "";
        try {
            switch(clave){
                case id_aplicacion:
                    query = "select * from vista_admin_apps where lower(id_aplicacion) like lower(?)";
                    break;
                case nombre_aplicacion:
                    query = "select * from vista_admin_apps where lower(nombre_aplicacion) like lower(?)";
                    break;
            }            
            pstm = conexion.prepareStatement(query);
            pstm.setString(1, valor+"%");
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Aplicacion p = new Aplicacion(rs.getString("id_aplicacion"), rs.getString("nombre_aplicacion"));
                listaRes.add(p);
            }
            rs.close();
            pstm.close();
            conexion.desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(AplicacionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaRes;
    }
    
    public void borrarAplicacion(Aplicacion aplicacion){
    }
}
