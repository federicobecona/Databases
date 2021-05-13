package Modelo;

public class Rol {
    
    String id_rol;
    String id_aplicacion;

    public Rol(String id_rol, String id_aplicacion) {
        this.id_rol = id_rol;
        this.id_aplicacion = id_aplicacion;
    }

    public String getId_rol() {
        return id_rol;
    }

    public String getId_aplicacion() {
        return id_aplicacion;
    }
    @Override
    public String toString(){
        return id_rol;
    }
    
}
