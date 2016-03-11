package org.agoncal.application.cdbookstore.model;

import javax.persistence.AttributeConverter;

import static org.agoncal.application.cdbookstore.model.CreditCardType.*;

/**
 * @author Antonio Goncalves
 *         http://www.antoniogoncalves.org
 *         --
 */

public class CreditCardConverter implements AttributeConverter<CreditCardType, String> {

    // ======================================
    // =          Business methods          =
    // ======================================

    @Override
    public String convertToDatabaseColumn(CreditCardType creditCardType) {
        switch (creditCardType) {
            case AMERICAN_EXPRESS:
                return "AMEX";
            case MASTER_CARD:
                return "MSTC";
            case VISA:
                return "VISA";
            default:
                throw new IllegalArgumentException("Unknown" + creditCardType);
        }
    }

    @Override
    public CreditCardType convertToEntityAttribute(String dbData) {
        switch (dbData) {
            case "AMEX":
                return AMERICAN_EXPRESS;
            case "MSTC":
                return MASTER_CARD;
            case "VISA":
                return VISA;
            default:
                throw new IllegalArgumentException("Unknown" + dbData);
        }
    }
}