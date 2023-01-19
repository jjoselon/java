package org.company.negocios;

import org.company.interfaces.IRelatable;
import org.company.interfaces.IRelatableMejorada;

import java.awt.*;

public class RectanglePlus implements IRelatable {

    public int width = 0;
    public int height = 0;
    public Point origin;

    // four constructors
    public RectanglePlus() {
        origin = new Point(0, 0);
    }
    public RectanglePlus(Point p) {
        origin = p;
    }
    public RectanglePlus(int w, int h) {
        origin = new Point(0, 0);
        width = w;
        height = h;
    }
    public RectanglePlus(Point p, int w, int h) {
        origin = p;
        width = w;
        height = h;
    }

    // a method for moving the rectangle
    public void move(int x, int y) {
        origin.x = x;
        origin.y = y;
    }

    // a method for computing
    // the area of the rectangle
    public int getArea() {
        return width * height;
    }

    /**
     * Método requerido al implementar la interfaz 'IRelatable'
     * @param other Objecto que implemente la interfaz ?
     * @return
     */
    @Override
    public int isLargerThan(IRelatable other) {
        RectanglePlus otherRect
                = (RectanglePlus)other; // La conversión de tipos le dice al compilador qué es realmente el objeto
        // La invocación getArea directa en la otherinstancia ( other.getArea()) fallaría en la compilación
        // porque el compilador no entiende que other en realidad es una instancia de RectanglePlus.
        if (this.getArea() < otherRect.getArea())
            return -1;
        else if (this.getArea() > otherRect.getArea())
            return 1;
        else
            return 0;
    }

    /**
     * @see https://docs.oracle.com/javase/tutorial/java/IandI/interfaceAsType.html
     * @param object1
     * @param object2
     * @return
     */
    @Override
    public Object findLargest(Object object1, Object object2) {
        // Estos métodos funcionan para cualquier objeto "IRelatable", sin importar cuál sea su herencia de clase.
        // Necesita un tipo IRelatable. Cualquier Object que implemente la interfaz IRelatable
        IRelatable obj1 = (IRelatable)object1;
        IRelatable obj2 = (IRelatable)object2;
        if (obj1.isLargerThan(obj2) > 0)
            return object1;
        else
            return object2;
    }

    public void usingDefaultMethod() {
        System.out.println(didItWork());
    }
}
