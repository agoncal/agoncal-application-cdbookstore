package org.agoncal.application.invoice.util;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.logging.Logger;

public class ResourceProducer {

    // ======================================
    // =              Producers             =
    // ======================================

    @Produces
    @PersistenceContext(unitName = "applicationInvoicePU")
    private EntityManager em;

    @Produces
    public Logger produceLogger(InjectionPoint injectionPoint) {
        return Logger.getLogger(injectionPoint.getMember().getDeclaringClass().getName());
    }
}
