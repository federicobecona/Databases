package Modelo;

public class Funcionalidad {
    
    String descripcion;
    String id_aplicacion;
    String nombre_funcionalidad;

    public Funcionalidad(String nombre_funcionalidad, String id_aplicacion, String descripcion) {
        this.nombre_funcionalidad = nombre_funcionalidad;
        this.id_aplicacion = id_aplicacion;
        this.descripcion = descripcion;
    }
    public String toString(){
        return nombre_funcionalidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getId_aplicacion() {
        return id_aplicacion;
    }

    public String getNombre_funcionalidad() {
        return nombre_funcionalidad;
    }
    
}
