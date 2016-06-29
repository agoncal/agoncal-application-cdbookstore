package org.agoncal.application.cdbookstore.util;

/**
 * @author Antonio Goncalves
 *         http://www.antoniogoncalves.org
 *         --
 */

@EightDigits
public class IssnGenerator implements NumberGenerator {

    // ======================================
    // =          Business methods          =
    // ======================================

    public String generateNumber() {
        return "8-" + Math.random() / 1000;
    }
}