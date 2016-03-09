package org.agoncal.application.cdbookstore.rest;

import org.agoncal.application.cdbookstore.model.CD;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Antonio Goncalves
 *         http://www.antoniogoncalves.org
 *         --
 */
@XmlRootElement
@XmlSeeAlso(CD.class)
public class CDs extends ArrayList<CD> {

    // ======================================
    // =            Constructors            =
    // ======================================

    public CDs() {
        super();
    }

    public CDs(Collection<? extends CD> b) {
        super(b);
    }

    // ======================================
    // =          Getters & Setters         =
    // ======================================

    @XmlElement(name = "cd")
    public List<CD> getCDs() {
        return this;
    }
}