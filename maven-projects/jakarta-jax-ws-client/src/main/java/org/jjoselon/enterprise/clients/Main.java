package org.jjoselon.enterprise.clients;

import org.jjoselon.jaxws.endpoints.Invoice;
import org.jjoselon.jaxws.endpoints.InvoiceServicio;
import org.jjoselon.jaxws.endpoints.InvoiceServicioImplService;

public class Main {
    public static void main(String[] args) {
        InvoiceServicio invoiceServicio = new InvoiceServicioImplService().getInvoiceServicioImplPort();

        Invoice invoice = new Invoice();
        invoice.setDescription("Factura de ejemplo");

        System.out.println(invoiceServicio.crear(invoice));
        //ervicio servicio = new ServicioImplService().getServicioImplPort();
        //System.out.println(servicio.);
    }
}
