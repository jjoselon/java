package org.example;

import org.company.interfaces.IRelatable;
import org.company.negocios.Negocio;
import org.company.negocios.RectanglePlus;

public class Main {
    public static void main(String[] args) {
        System.out.println("Interfaces in Java!");
//        implementation1();
//        implementation2();
//        implementation3();
        implementation4();
    }
    static void implementation1() {
        Negocio negocio = new Negocio();
        negocio.negociando();
    }

    static void implementation2() {

        RectanglePlus otherRectangle = new RectanglePlus(250, 250);

        RectanglePlus rectangle = new RectanglePlus(300, 250);
        System.out.println("Result: " + rectangle.isLargerThan(otherRectangle));
    }

    static void implementation3() {
        RectanglePlus rectangle = new RectanglePlus();
        rectangle.findLargest(new RectanglePlus(), new RectanglePlus());
    }

    static void implementation4() {
        RectanglePlus rectangle = new RectanglePlus();
        rectangle.usingDefaultMethod();// Usando el método predeterminado a través de un método de la clase
        System.out.println(rectangle.didItWork()); // Usando el método predeterminado directamente desde la instance de la clase
        System.out.println(IRelatable.builded()); // Método static, llamado desde el tipo de referencia
    }
}

