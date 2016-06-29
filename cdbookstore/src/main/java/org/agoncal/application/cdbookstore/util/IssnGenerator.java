package org.agoncal.application.cdbookstore.util;

import java.util.Random;

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
        return "8-" + new Random().nextInt() / 1000;
    }
}