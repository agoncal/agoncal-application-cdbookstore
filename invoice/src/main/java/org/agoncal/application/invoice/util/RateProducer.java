package org.agoncal.application.invoice.util;

import javax.enterprise.inject.Produces;

/**
 * @author Antonio Goncalves
 *         http://www.antoniogoncalves.org
 *         --
 */

public class RateProducer {

    // ======================================
    // =              Producers             =
    // ======================================

    @Produces
    @Vat
    private Float vatRate = 5.5F;

    @Produces
    @Discount
    private Float discountRate = 12.5F;
}