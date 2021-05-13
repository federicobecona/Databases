package Modelo;

import java.sql.Timestamp;

public class BitacoraUsuario extends Bitacora{
    
    String nombre_usuario;

    public BitacoraUsuario(String id_evto, String usuario_modificador, Timestamp fecha, String nombre_usuario) {
        super(id_evto, usuario_modificador, fecha);
        this.nombre_usuario = nombre_usuario;
    }
    
    public String getNombre_usuario() {
        return nombre_usuario;
    }
}
