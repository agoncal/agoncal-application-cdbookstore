package org.agoncal.application.cdbookstore.util;

/**
 * @author Antonio Goncalves
 *         http://www.antoniogoncalves.org
 *         --
 */

@ThirteenDigits
public class IsbnGenerator implements NumberGenerator {

    // ======================================
    // =          Business methods          =
    // ======================================

    public String generateNumber() {
        return "13-" + Math.random();
    }
}