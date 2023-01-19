package org.company.classes;

import org.company.interfaces.IEmpresa;

/**
 * Esta es una clase que implementa la interfaz por medio de la clausula 'implements'
 */
public class SoftwareMicroImpl implements IEmpresa {

    @Override
    public void pagarNomina() {
        System.out.println("Nomina pagada de Microsoft con exito!");
    }

    @Override
    public int obtenerSMLV() {
        return 0;
    }
}
