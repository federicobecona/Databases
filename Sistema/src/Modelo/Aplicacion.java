package Modelo;

public class Aplicacion {
    
    String id_aplicacion;
    String nombre_aplicacion;

    public Aplicacion(String id_aplicacion, String nombre_aplicacion) {
        this.id_aplicacion = id_aplicacion;
        this.nombre_aplicacion = nombre_aplicacion;
    }

    public String getId_aplicacion() {
        return id_aplicacion;
    }
    
    @Override
    public String toString(){
        return nombre_aplicacion;
    }
    
    public String getNombre_aplicacion() {
        return nombre_aplicacion;
    }   
}
