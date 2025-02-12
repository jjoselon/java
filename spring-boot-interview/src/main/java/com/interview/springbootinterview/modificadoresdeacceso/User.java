package com.interview.springbootinterview.modificadoresdeacceso;

public class User extends Persona {
    private String nombre;
    private int edad;
    public User(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
}
