package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PostgresSqlConexion {
    
    private static PostgresSqlConexion Instance=null;
    
    private final String BDnombre = "obligatorio";
    private String usuario=null;
    private String contrasena=null;
    private final String id_app="5";

    public String getId_app() {
        return id_app;
    }

    private PostgresSqlConexion() {}
    
    public void setUserAndPass(String usuario,String pass){
        this.usuario=usuario;
        this.contrasena = PostgresSqlConexion.obfuscate(pass);
    }
    
    public static PostgresSqlConexion getPostgresConexion(){
        if(Instance==null){
            Instance=new PostgresSqlConexion();
        }
        return Instance;
    }
    
    private final String host = "192.168.56.102";
    private final String puerto = "5432";
    
    private final String url = "jdbc:postgresql://"+host+":"+puerto+"/" + BDnombre;
    
    
    private Connection conexion;
    
    public boolean conectarse(){
        conexion = null;
        try {
           Class.forName("org.postgresql.Driver");
           this.conexion = DriverManager.getConnection(url,this.usuario,this.contrasena);
           this.conexion.setAutoCommit(false);
           return true;
        } catch (Exception e) {
           System.err.println(e.getClass().getName()+": "+e.getMessage());
           return false;
        }
    }
    
    public void commit() throws SQLException{
        this.conexion.commit();
    }
    
    public void desconectar() throws SQLException{
        this.conexion.close();
        System.out.println("Closed database successfully");
    }
    
    public Connection getConexion(){
        return conexion;
    }    
    
    public PreparedStatement prepareStatement(String s) throws SQLException{
        return conexion.prepareStatement(s);
    }
    
    public static String obfuscate(String pass){
        return pass + new StringBuilder(pass).reverse().toString();
    }
}
