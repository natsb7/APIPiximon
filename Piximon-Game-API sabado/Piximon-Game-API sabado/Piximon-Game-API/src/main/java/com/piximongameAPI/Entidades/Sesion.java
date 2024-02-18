package com.piximongameAPI.Entidades;

public class Sesion {
    private final String id;
    private final String email;
    private final String nombre;

    public Sesion() {
       this(null, null, null) ;
    }

    public Sesion(String id, String nombre, String email) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }


    @Override
    public String toString() {
        return "Sesion{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\''+
                '}';
    }
}

