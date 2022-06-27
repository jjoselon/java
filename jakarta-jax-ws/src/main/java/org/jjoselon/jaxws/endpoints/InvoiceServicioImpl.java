package org.jjoselon.jaxws.endpoints;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import org.jjoselon.jaxws.models.Invoice;
import org.jjoselon.jaxws.repositories.InvoiceRepository;

import java.util.List;

/**
 * @WebService() sin parámetros implementa todos los métodos de la clase junto con las que herede y sus interfaces
 * @WebService(endpointInterface = "org.jjoselon.jaxws.endpoints.InvoiceServicio")
 * Para no implementar todos los métodos de la clase. Si no solo de la interfaz dada
 */
@Stateless
@WebService(endpointInterface = "org.jjoselon.jaxws.endpoints.InvoiceServicio")
public class InvoiceServicioImpl implements InvoiceServicio {

    @Inject
    private InvoiceRepository invoiceRepository;

    /**
     * Para demostrar que es sin-estado "Stateless"
     */
    private int counter;

    /**
     * Con @WebMethod indicamos que son métodos del servicio web
     * @param Invoice invoice
     * @return String
     */
    @Override
    @WebMethod
    public Invoice crear(Invoice invoice) {
        System.out.println("Imprimiento dentro del servicio web con instancia: " + this);
        counter++;
        System.out.println("Valor del contador en método saludar es " + counter);
        return invoiceRepository.guardar(invoice);
    }

    @Override
    public List<Invoice> listar() {
        return invoiceRepository.listar();
    }

    @Override
    @WebMethod
    public int consultarPorId(int invoiceNumber) {
        System.out.println("Imprimiento dentro del servicio web con instancia: " + this);
        counter++;
        System.out.println("Valor del contador en método saludar es " + counter);
        return invoiceNumber;
    }

    @Override
    @WebMethod
    public String[] buscarPorNombres(String[] nombres) {
        System.out.println("Imprimiento dentro del servicio web con instancia: " + this);
        counter++;
        System.out.println("Valor del contador en método saludar es " + counter);
        return new String[2];
    }

}
