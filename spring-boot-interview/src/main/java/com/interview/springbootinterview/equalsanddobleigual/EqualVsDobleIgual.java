package com.interview.springbootinterview.equalsanddobleigual;

public class EqualVsDobleIgual {
    public static void main(String[] args) {
        Persona persona1 = new Persona("jose", 27);
        Persona persona2 = new Persona("jose", 27);

        if (persona1.equals(persona2)) { // false
            System.out.println("Persona 1.equals(persona2)");
        }
        if (persona1 == persona2) { // false
            System.out.println("Persona 1 == persona2");
        }

        Persona persona3 = persona2; // Apunta al mismo espacio en memoria

        if (persona3.equals(persona2)) { // true
            System.out.println("Persona 3.equals(persona2)");
        }
        if (persona3 == persona2) {
            System.out.println("Persona 3 == persona2");
        }

        String nombre1 = "José";
        String nombre2 = "José";

        if (nombre1.equals(nombre2)) {
            System.out.println("nombre1 equals nombre2");
        }

        if (nombre1 == nombre2) {
            System.out.println("nombre1 equals nombre2");
        }
    }
}
