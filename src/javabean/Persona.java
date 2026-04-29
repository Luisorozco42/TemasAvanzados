package javabean;

import java.io.Serializable;

//esto es un java bean
/*
Caracteristicas:

constructor vacio
encapsulamiento
y la implementacion del Serializable
tecniccamente es un estandar
 */
public class Persona implements Serializable {
    private String nombre;
    private String apellido;

    public Persona(){}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "Nombre: " + nombre +
                ", Apellido: " + apellido +
                "}";
    }
}
