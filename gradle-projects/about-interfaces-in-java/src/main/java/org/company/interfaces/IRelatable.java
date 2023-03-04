package org.company.interfaces;

public interface IRelatable {

//    Todas las declaraciones de métodos en una interfaz, incluidos los métodos predeterminados,
//    son implícitamente public, por lo que puede omitir el public modificador.

    // este (objeto que llama es más grande que)
    // y otros deben ser instancias de
    // la misma clase devuelve 1, 0, -1
    // si es mayor que,
    // igual o menor que otro
    int isLargerThan(IRelatable other);

    Object findLargest(Object object1, Object object2);

    default boolean didItWork() {
        return true;
    }

    /**
     * Un método static tiene un body. Lo que quiere decir que funcionara igual para todas las implementaciones
     * Es parecido pero no igual a un método static de una clase, no pertenece al objeto sino a la instancia
     *
     * Un método estático es un método que está asociado con la clase en la que está definido en lugar
     * de con cualquier objeto. Cada instancia de la clase comparte sus métodos estáticos
     *
     * @return
     */
    static boolean builded() {
        return true;
    }


}
