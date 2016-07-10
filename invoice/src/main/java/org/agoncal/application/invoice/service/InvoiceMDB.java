package org.agoncal.application.invoice.service;

import org.agoncal.application.invoice.model.Invoice;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Antonio Goncalves
 *         http://www.antoniogoncalves.org
 *         --
 */

@MessageDriven(mappedName = "invoiceQueue", activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
        @ActivationConfigProperty(propertyName = "destination", propertyValue = "jms/queue/invoiceQueue"),
        @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge"),
})
public class InvoiceMDB implements MessageListener {

    // ======================================
    // =          Injection Points          =
    // ======================================

    @Inject
    private InvoiceService invoiceService;

    @Inject
    private Logger logger;

    // ======================================
    // =          Business methods          =
    // ======================================

    @Override
    public void onMessage(Message message) {
        try {
            logger.info("Message received " + message);
            Invoice invoice = message.getBody(Invoice.class);
            invoiceService.persist(invoice);
            logger.info("Invoice persisted " + invoice);
        } catch (JMSException e) {
            logger.log(Level.SEVERE, "Cannot persist invoice", e);
        }
    }
}
