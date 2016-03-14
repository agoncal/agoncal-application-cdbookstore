package org.agoncal.application.cdbookstore.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @author Antonio Goncalves
 *         http://www.antoniogoncalves.org
 *         --
 */

public class CreditCard implements Serializable {

    // ======================================
    // =             Attributes             =
    // ======================================

    @NotNull
    @Size(min = 1, max = 30)
    private String creditCardNumber;
    @NotNull
    private CreditCardType creditCardType;
    @NotNull
    @Size(min = 1, max = 5)
    private String creditCardExpDate;

    // ======================================
    // =        Getters and Setters         =
    // ======================================

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public CreditCardType getCreditCardType() {
        return creditCardType;
    }

    public void setCreditCardType(CreditCardType creditCardType) {
        this.creditCardType = creditCardType;
    }

    public String getCreditCardExpDate() {
        return creditCardExpDate;
    }

    public void setCreditCardExpDate(String creditCardExpDate) {
        this.creditCardExpDate = creditCardExpDate;
    }

    // ======================================
    // =   Methods hash, equals, toString   =
    // ======================================

    @Override
    public String toString() {
        String result = getClass().getSimpleName() + " ";
        if (creditCardNumber != null && !creditCardNumber.trim().isEmpty())
            result += "creditCardNumber: " + creditCardNumber;
        if (creditCardType != null)
            result += ", creditCardType: " + creditCardType;
        if (creditCardExpDate != null && !creditCardExpDate.trim().isEmpty())
            result += ", creditCardExpDate: " + creditCardExpDate;
        return result;
    }
}