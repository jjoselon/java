package org.jjoselon.jaxws.repositories;

import org.jjoselon.jaxws.models.Invoice;

import java.util.List;

public interface InvoiceRepository {
    List<Invoice> listar();
    Invoice guardar(Invoice invoice);
}
