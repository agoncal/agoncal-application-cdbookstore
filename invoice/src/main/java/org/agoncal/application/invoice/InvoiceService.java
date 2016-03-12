package org.agoncal.application.invoice;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class InvoiceService {

    // ======================================
    // =          Injection Points          =
    // ======================================

    @Inject
    private EntityManager em;

    // ======================================
    // =          Business methods          =
    // ======================================

    public Invoice persist(Invoice invoice) {
        em.persist(invoice);
        return invoice;
    }

    public Invoice findById(Long id) {
        return em.find(Invoice.class, id);
    }

    public void remove(Invoice invoice) {
        em.remove(em.merge(invoice));
    }

    public Invoice merge(Invoice invoice) {
        return em.merge(invoice);
    }

    public List<Invoice> listAll(Integer startPosition, Integer maxResult) {
        TypedQuery<Invoice> findAllQuery = getListAllQuery();
        if (startPosition != null) {
            findAllQuery.setFirstResult(startPosition);
        }
        if (maxResult != null) {
            findAllQuery.setMaxResults(maxResult);
        }
        final List<Invoice> results = findAllQuery.getResultList();
        return results;
    }

    public List<Invoice> listAll() {
        return getListAllQuery().getResultList();
    }

    public TypedQuery<Invoice> getListAllQuery() {
        CriteriaQuery<Invoice> criteria = em.getCriteriaBuilder().createQuery(Invoice.class);
        return em.createQuery(criteria.select(criteria.from(Invoice.class)));
    }
}
