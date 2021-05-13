package Modelo;

import java.sql.Date;

public class Persona {

    String CI;
    String nombre;
    String apellido;
    Date fecha_nacimiento;
    String sexo;
    String telefono;

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    @Override
    public String toString(){
        return nombre+" "+apellido;
    }
    
    public Persona(String CI, String nombre, String apellido, Date fecha_nacimiento, String sexo, String telefono) {
        this.CI = CI;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha_nacimiento = fecha_nacimiento;
        this.sexo = sexo;
        this.telefono = telefono;
    }
    
    public String getCI() {
        return CI;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public String getTelefono() {
        return telefono;
    }
    
}
