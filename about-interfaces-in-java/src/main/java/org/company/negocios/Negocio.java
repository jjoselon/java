package org.company.negocios;

import org.company.classes.SoftwareOracleImpl;
import org.company.interfaces.IEmpresa;

public class Negocio {

    // Variable de referencia cuyo tipo es una interfaz, cualquier objeto que se le asigne debe ser una instancia de una
    // clase que implemente la interfaz -> SoftwareOracleImpl implementa la interfaz
    private IEmpresa iEmpresa = new SoftwareOracleImpl();

    public void negociando() {
        iEmpresa.pagarNomina();
    }

}
