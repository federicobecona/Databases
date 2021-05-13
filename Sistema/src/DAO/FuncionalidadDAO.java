package DAO;

import Conexion.PostgresSqlConexion;
import Modelo.Funcionalidad;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FuncionalidadDAO {
    
    public enum Claves{
        nombre_funcionalidad,
        id_aplicacion;
    }
    
    PostgresSqlConexion conexion = PostgresSqlConexion.getPostgresConexion();
    
    public boolean insertarFuncionalidad(Funcionalidad funcionalidad){
        conexion.conectarse();
        try {
            PreparedStatement pstm = conexion.prepareStatement("INSERT INTO funcionalidad(nombre_funcionalidad,id_aplicacion,descripcion) VALUES(?,?,?)");
            pstm.setString(1, funcionalidad.getNombre_funcionalidad());
            pstm.setString(2, funcionalidad.getId_aplicacion());
            pstm.setString(3, funcionalidad.getDescripcion());
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
    
    public void borrarFuncionalidad(Funcionalidad funcionalidad){
    }
    
    public ArrayList<Funcionalidad> listarFuncionalidades() {
        return buscarFuncionalidades(Claves.nombre_funcionalidad, "");
    }
    
    public ArrayList<Funcionalidad> buscarFuncionalidades(Claves clave, String valor){
        conexion.conectarse();
        ArrayList<Funcionalidad> listaRes = new ArrayList<>();
        PreparedStatement pstm;
        String query = "";
        try {
            switch(clave){
                case id_aplicacion:
                    query = "select f.* from funcionalidad f JOIN vista_admin_apps vap ON f.id_aplicacion = vap.id_aplicacion where lower(f.id_aplicacion) like lower(?)";
                    break;
                case nombre_funcionalidad:
                    query = "select f.* from funcionalidad f JOIN vista_admin_apps vap ON f.id_aplicacion = vap.id_aplicacion where lower(nombre_funcionalidad) like lower(?)";
                    break;
            }
            pstm = conexion.prepareStatement(query);
            pstm.setString(1, valor+"%");
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Funcionalidad p = new Funcionalidad(rs.getString("nombre_funcionalidad"), rs.getString("id_aplicacion"), rs.getString("descripcion"));
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
}
