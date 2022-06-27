package org.jjoselon.jaxws;

import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.ws.rs.Produces;

@RequestScoped
public class ProducerEntityManager {

    @PersistenceContext(name = "jpaFilePersistence")
    private EntityManager em;

    @Produces
    @RequestScoped
    private EntityManager beanEntityManager() {
        return em;
    }
}
