package org.agoncal.application.invoice.batch;

import org.agoncal.application.invoice.model.Invoice;

import javax.batch.api.chunk.AbstractItemReader;
import javax.batch.runtime.context.JobContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author Antonio Goncalves
 *         http://www.antoniogoncalves.org
 *         --
 */

@Named
public class InvoiceReader extends AbstractItemReader {

    // ======================================
    // =          Injection Points          =
    // ======================================

    @Inject
    private JobContext jobContext;

    @Inject
    private EntityManager em;

    @Inject
    private Logger logger;

    // ======================================
    // =          Business methods          =
    // ======================================

    @Override
    public Object readItem() throws Exception {

        TypedQuery<Invoice> query = em.createNamedQuery(Invoice.FIND_MONTHLY, Invoice.class);
        List<Invoice> invoices = query.getResultList();
        logger.info("Read " + invoices.size() + " invoices");
        return invoices;
    }
}
