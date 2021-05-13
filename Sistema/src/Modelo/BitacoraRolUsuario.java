package Modelo;

import java.sql.Timestamp;

public class BitacoraRolUsuario extends Bitacora{
    
    String nombre_usuario;
    String id_rol;
    String id_aplicacion;

    public BitacoraRolUsuario(String id_evto, String usuario_modificador, Timestamp fecha, String nombre_usuario, String id_rol, String id_aplicacion) {
        super(id_evto, usuario_modificador, fecha);
        this.nombre_usuario = nombre_usuario;
        this.id_rol = id_rol;
        this.id_aplicacion = id_aplicacion;
    }    
    
    public String getId_rol() {
        return id_rol;
    }

    public String getId_aplicacion() {
        return id_aplicacion;
    }
    
    public String getNombre_usuario() {
        return nombre_usuario;
    }
}
