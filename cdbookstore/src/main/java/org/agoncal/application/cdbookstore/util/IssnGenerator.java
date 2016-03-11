package org.agoncal.application.cdbookstore.util;

import javax.inject.Inject;
import java.util.logging.Logger;

/**
 * @author Antonio Goncalves
 *         http://www.antoniogoncalves.org
 *         --
 */

@EightDigits
public class IssnGenerator implements NumberGenerator {

    // ======================================
    // =          Injection Points          =
    // ======================================

    @Inject
    private Logger logger;

    @Inject
    @EightDigits
    private String prefix;

    @Inject
    @EightDigits
    private int postfix;

    // ======================================
    // =          Business methods          =
    // ======================================

    public String generateNumber() {
        return prefix + Math.random() / 1000 + postfix;
    }
}