package org.javaoo.abstractClassesVsInterfaces;

public class MainClass {
    public static void main(String[] args) {
        AbstractClass abstractClass = new AbstractClass() {
            @Override
            void print() {
                System.out.println("Hello World");
            }
        };
        abstractClass.print();
        Print.copiar();

    }
}
