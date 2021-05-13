package DAO;

import Conexion.PostgresSqlConexion;
import Modelo.Persona;
import Modelo.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PersonaDAO {
    
    public enum Claves{
        CI,
        nombre,
        apellido,
        fecha_nacimiento,
        sexo,
        telefono;
    }
    
    PostgresSqlConexion conexion = PostgresSqlConexion.getPostgresConexion();

    public boolean insertarPersona(Persona persona){
        conexion.conectarse();
        try {
            PreparedStatement pstm = conexion.prepareStatement("INSERT INTO persona(CI,nombre,apellido,fecha_nacimiento,sexo,telefono) VALUES(?,?,?,?,?,?)");
            pstm.setString(1, persona.getCI());
            pstm.setString(2, persona.getNombre());
            pstm.setString(3, persona.getApellido());
            pstm.setDate(4, persona.getFecha_nacimiento());
            pstm.setString(5, persona.getSexo());
            pstm.setString(6, persona.getTelefono());
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

    public ArrayList<Persona> listarPersonas(){
        return buscarPersona(Claves.CI, "");
    }
    
    public ArrayList<Persona> buscarPersona(PersonaDAO.Claves clave, String valor){
        conexion.conectarse();
        ArrayList<Persona> listaRes = new ArrayList<>();
        PreparedStatement pstm;
        String query = "";
        try {
            switch(clave){
                case CI:
                    query = "select * from persona where lower(ci) like lower(?)";
                    break;
                case nombre:
                    query = "select * from persona where lower(nombre) like lower(?)";
                    break;
                case apellido:
                    query = "select * from persona where lower(apellido) like lower(?)";
                    break;
                case fecha_nacimiento:
                    query = "select * from persona where lower(fecha_nacimiento) like lower(?)";
                    break;
                case sexo:
                    query = "select * from persona where lower(sexo) like lower(?)";
                    break;
                case telefono:
                    query = "select * from persona where lower(telefono) like lower(?)";
                    break;
            }
            pstm = conexion.prepareStatement(query);
            pstm.setString(1, valor+"%");
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Persona p = new Persona(rs.getString("ci"), rs.getString("nombre"), rs.getString("apellido"), rs.getDate("fecha_nacimiento"), rs.getString("sexo"), rs.getString("telefono"));
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

    public void modificarPersona(Persona persona) throws SQLException {
        conexion.conectarse();
        try {
            PreparedStatement pstm = conexion.prepareStatement("UPDATE persona SET telefono=? where ci=?");
            pstm.setString(1, persona.getTelefono());
            pstm.setString(2, persona.getCI());
            pstm.executeUpdate();
            pstm.close();
            conexion.commit();
        } catch (SQLException ex) {
            Logger.getLogger(PostgresSqlConexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        conexion.desconectar();
    }

    public ArrayList<Usuario> buscarUsuario(Persona persona) throws SQLException{
        conexion.conectarse();
        ArrayList<Usuario> listaRes = new ArrayList<>();
        PreparedStatement pstm = conexion.prepareStatement("select * from usuario where CI = ?");
        pstm.setString(1, persona.getCI());
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            Usuario p = new Usuario(rs.getString("nombre_usuario"), rs.getString("codigo_estado"), rs.getString("ci"));
            listaRes.add(p);
        }
        rs.close();
        pstm.close();
        conexion.desconectar();
        return listaRes;
    }        
    
}
