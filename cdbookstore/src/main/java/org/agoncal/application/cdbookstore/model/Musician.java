package org.agoncal.application.cdbookstore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Antonio Goncalves
 *         http://www.antoniogoncalves.org
 *         --
 */

@Entity
public class Musician extends Artist {

    // ======================================
    // =             Attributes             =
    // ======================================

    @Column(name = "preferred_instrument")
    private String preferredInstrument;

    @ManyToMany
    private Set<CD> cds = new HashSet<>();

    // ======================================
    // =        Getters and Setters         =
    // ======================================

    public String getPreferredInstrument() {
        return preferredInstrument;
    }

    public void setPreferredInstrument(String preferredInstrument) {
        this.preferredInstrument = preferredInstrument;
    }

    public Set<CD> getCds() {
        return this.cds;
    }

    public void setCds(final Set<CD> cds) {
        this.cds = cds;
    }

    // ======================================
    // =   Methods hash, equals, toString   =
    // ======================================

    @Override
    public String toString() {
        String result = getClass().getSimpleName() + " ";
        if (id != null)
            result += "id: " + id;
        result += ", version: " + version;
        if (firstName != null && !firstName.trim().isEmpty())
            result += ", firstName: " + firstName;
        if (lastName != null && !lastName.trim().isEmpty())
            result += ", lastName: " + lastName;
        if (bio != null && !bio.trim().isEmpty())
            result += ", bio: " + bio;
        if (dateOfBirth != null)
            result += ", dateOfBirth: " + dateOfBirth;
        if (age != null)
            result += ", age: " + age;
        if (preferredInstrument != null
                && !preferredInstrument.trim().isEmpty())
            result += ", preferredInstrument: " + preferredInstrument;
        return result;
    }
}