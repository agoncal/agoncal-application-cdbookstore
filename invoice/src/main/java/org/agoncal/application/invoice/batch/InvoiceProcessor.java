package org.agoncal.application.invoice.batch;

import org.agoncal.application.invoice.model.Invoice;

import javax.batch.api.chunk.ItemProcessor;
import javax.batch.runtime.context.JobContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author Antonio Goncalves
 *         http://www.antoniogoncalves.org
 *         --
 */

@Named
public class InvoiceProcessor implements ItemProcessor {

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
    public Object processItem(Object item) throws Exception {
        List<Invoice> invoices = (List<Invoice>) item;
        List<InvoiceSummary> summaries = new ArrayList<>();

        for (int i = 0; i < invoices.size(); i++) {

            int currentMonth = invoices.get(i).getMonth();
            logger.info("currentMonth " + currentMonth);
            InvoiceSummary summary = new InvoiceSummary(currentMonth + 1);
            int nbOfInvoices = 0;
            float total = 0F;
            while (currentMonth == invoices.get(i).getMonth() && i < invoices.size() - 1) {
                nbOfInvoices++;
                total += invoices.get(i).getTotalAfterVat();
                logger.info("current invoice id " + invoices.get(i).getId());
                i++;
            }
            summary.setNumberOfInvoices(nbOfInvoices);
            summary.setTotal(total);
            summaries.add(summary);
        }

        logger.info("Processed " + summaries.size() + " summaries");
        return summaries;
    }
}
