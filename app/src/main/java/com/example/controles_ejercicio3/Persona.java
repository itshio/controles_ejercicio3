package com.example.controles_ejercicio3;

/**
 * Created by DIDACT on 07/02/2018.
 */

public class Persona {

    String nombre;
    String apellido;
    String provincia;
    String estado_civil;
    int edad;

    public Persona(String nombre, String apellido, String provincia, String estado_civil, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.provincia = provincia;
        this.estado_civil = estado_civil;
        this.edad = edad;
    }

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

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getEstado_civil() {
        return estado_civil;
    }

    public void setEstado_civil(String estado_civil) {
        this.estado_civil = estado_civil;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
