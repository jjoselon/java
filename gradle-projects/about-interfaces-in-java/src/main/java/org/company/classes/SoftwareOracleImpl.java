package org.company.classes;

import org.company.interfaces.IEmpresa;

public class SoftwareOracleImpl implements IEmpresa {
    @Override
    public void pagarNomina() {
        System.out.println("Nomina pagada de Oracle con exito!");
    }

    @Override
    public int obtenerSMLV() {
        return 0;
    }
}
