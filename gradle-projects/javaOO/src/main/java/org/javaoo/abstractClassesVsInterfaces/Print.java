package org.javaoo.abstractClassesVsInterfaces;

public interface Print {

    default void print() {
        System.out.println("Hola como tas");
    }

    static void copiar() {
        System.out.println("Copiando...");
    }
}
