package com.interview.springbootinterview.polimorfismo;

public class Polimorfismo {
    public static void main(String[] args) {
        Vehiculo vehiculo = new Carro();
        Carro carro = new Vehiculo(); // Veniculo no sabe quien es Carro !
    }
}
