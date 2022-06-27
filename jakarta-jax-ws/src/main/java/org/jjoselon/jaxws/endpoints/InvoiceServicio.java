package org.jjoselon.jaxws.endpoints;

import jakarta.jws.WebService;
import org.jjoselon.jaxws.models.Invoice;

import java.util.List;

@WebService
public interface InvoiceServicio {
    Invoice crear(Invoice invoice);

    List<Invoice> listar();

    int consultarPorId(int id);

    String[] buscarPorNombres(String[] nombres);
}
