package Modelo;

public class Usuario {

    String nombre_usuario;
    String codigo_estado;
    String CI;
    String contrasena;
    
    public Usuario(String nombre_usuario, String codigo_estado, String CI) {
        this.nombre_usuario = nombre_usuario;
        this.codigo_estado = codigo_estado;
        this.CI = CI;
        this.contrasena = contrasena;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public String getCodigo_estado() {
        return codigo_estado;
    }

    public String getCI() {
        return CI;
    }
    
    public void setCodigo_estado(String codigo_estado) {
        this.codigo_estado = codigo_estado;
    }
    
    @Override
    public String toString(){
        return nombre_usuario;
    }
}
