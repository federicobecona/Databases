package DAO;

import Conexion.PostgresSqlConexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOLogin {
    
    PostgresSqlConexion conn=null;

    public enum Estados{
        Aprobado,
        En_espera,
        Suspendido,
        Eliminado,
        Incorrecto
    }
    
    public DAOLogin() {
        
    }
    public Estados usr_login(String usuario,String contrasena){
        conn=PostgresSqlConexion.getPostgresConexion();
        conn.setUserAndPass(usuario, contrasena);
        if(!conn.conectarse()){
            return Estados.Incorrecto;
        }
        return getEstado();
    }
    
    public Estados getEstado(){
        conn.conectarse();
        PreparedStatement pstm;
        try {
            pstm = conn.prepareStatement("SELECT * FROM vista_usuario");
            ResultSet rs = pstm.executeQuery();
            rs.next();
            String estadoStr = rs.getString("cod_estado");
            rs.close();
            pstm.close();
            conn.desconectar();
            switch (estadoStr){
                case "PEND":
                    return Estados.En_espera;
                case "APR":
                    return Estados.Aprobado;
                case "SUSP":
                    return Estados.Suspendido;
                case "DEL":
                    return Estados.Eliminado;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Estados.Incorrecto;
    }
}
