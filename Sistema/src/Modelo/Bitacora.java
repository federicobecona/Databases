package Modelo;

import java.sql.Timestamp;

public abstract class Bitacora {
    String id_evto;
    String usuario_modificador;
    Timestamp fecha;

    public Bitacora(String id_evto, String usuario_modificador, Timestamp fecha) {
        this.id_evto = id_evto;
        this.usuario_modificador = usuario_modificador;
        this.fecha = fecha;
    }



    public String getId_evto() {
        return id_evto;
    }

    public String getUsuario_modificador() {
        return usuario_modificador;
    }

    public Timestamp getFecha() {
        return fecha;
    }
    
}
