package org.jjoselon.jaxws.repositories;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import org.jjoselon.jaxws.models.Invoice;

import java.util.List;

@RequestScoped
public class InvoiceRepositoryImpl implements InvoiceRepository {

    @Inject
    private EntityManager em;

    @Override
    public List<Invoice> listar() {
        return em.createQuery("from invoice", Invoice.class).getResultList();
    }

    @Override
    public Invoice guardar(Invoice invoice) {
        em.persist(invoice);
        return invoice;
    }
}
