package org.company.interfaces;

public interface IEmpresa {

    /**
     * Todos los valores constantes definidos dentro de una interfaz son implicitamente public, static y final.
     * Podemos omitir estos modificadores.
     * Intellij incluso marca con "redundante" el uso de estos keywords
     */
    public static final double VALOR_HORA_EXTRA = 5000;

    /**
     * Método abstracto de una interfaz, va seguido de un punto y coma, pero sin llaves
     * (Un método abstracto no contiene implementación)
     */
    void pagarNomina();
    int obtenerSMLV();
}
