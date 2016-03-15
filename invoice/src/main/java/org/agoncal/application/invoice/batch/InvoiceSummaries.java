package org.agoncal.application.invoice.batch;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Antonio Goncalves
 *         http://www.antoniogoncalves.org
 *         --
 */

@XmlRootElement(name = "invoiceSummary")
@XmlType(propOrder = {"year", "invoiceSummaries"})
@XmlSeeAlso(InvoiceSummary.class)
public class InvoiceSummaries extends ArrayList<InvoiceSummary> {

    // ======================================
    // =             Attributes             =
    // ======================================

    private Integer year;

    // ======================================
    // =            Constructors            =
    // ======================================

    public InvoiceSummaries() {
        super();
    }

    public InvoiceSummaries(Collection<? extends InvoiceSummary> c) {
        super(c);
    }

    // ======================================
    // =          Getters & Setters         =
    // ======================================

    @XmlElement(name = "invoiceSummaries")
    public List<InvoiceSummary> getInvoiceSummaries() {
        return this;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}