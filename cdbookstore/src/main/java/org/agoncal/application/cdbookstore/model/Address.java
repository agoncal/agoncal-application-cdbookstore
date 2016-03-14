package org.agoncal.application.cdbookstore.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @author Antonio Goncalves
 *         http://www.antoniogoncalves.org
 *         --
 */

public class Address implements Serializable {

    // ======================================
    // =             Attributes             =
    // ======================================

    @Size(min = 5, max = 50)
    @NotNull
    private String street1;
    private String street2;
    @Size(min = 2, max = 50)
    @NotNull
    private String city;
    private String state;
    @Size(min = 1, max = 10)
    @NotNull
    private String zipcode;

    // ======================================
    // =        Getters and Setters         =
    // ======================================

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    // ======================================
    // =   Methods hash, equals, toString   =
    // ======================================

    @Override
    public String toString() {
        String result = getClass().getSimpleName() + " ";
        if (street1 != null && !street1.trim().isEmpty())
            result += "street1: " + street1;
        if (street2 != null && !street2.trim().isEmpty())
            result += ", street2: " + street2;
        if (city != null && !city.trim().isEmpty())
            result += ", city: " + city;
        if (state != null && !state.trim().isEmpty())
            result += ", state: " + state;
        if (zipcode != null && !zipcode.trim().isEmpty())
            result += ", zipcode: " + zipcode;
        return result;
    }
}