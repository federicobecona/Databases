package Modelo;

public class UsuarioRol {
    
    String id_rol;
    String id_aplicacion;
    String nombre_usuario;
    String cod_estado;

    public UsuarioRol(String id_rol, String id_aplicacion, String nombre_usuario, String cod_estado) {
        this.id_rol = id_rol;
        this.id_aplicacion = id_aplicacion;
        this.nombre_usuario = nombre_usuario;
        this.cod_estado = cod_estado;
    }

    public void setCod_estado(String cod_estado) {
        this.cod_estado = cod_estado;
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

    public String getCod_estado() {
        return cod_estado;
    }
    
    @Override
    public String toString(){
        return id_aplicacion +" - "+ id_rol;
    }
}
