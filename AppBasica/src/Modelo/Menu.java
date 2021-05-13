package Modelo;

public class Menu {

    String id_menu;
    String nombre;
    String id_aplicacion;

    public Menu(String id_menu, String nombre, String id_aplicacion) {
        this.id_menu = id_menu;
        this.nombre = nombre;
        this.id_aplicacion = id_aplicacion;
    }

    public String getId_menu() {
        return id_menu;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }

    public String getId_aplicacion() {
        return id_aplicacion;
    }
}
