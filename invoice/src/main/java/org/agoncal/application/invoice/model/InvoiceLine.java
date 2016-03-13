package org.agoncal.application.invoice.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author Antonio Goncalves
 *         http://www.antoniogoncalves.org
 *         --
 */

@Entity
@Table(name = "invoice_line")
public class InvoiceLine implements Serializable {

    // ======================================
    // =             Attributes             =
    // ======================================

    @Column(length = 200)
    @NotNull
    @Size(min = 1, max = 200)
    protected String title;
    @Column(name = "unit_cost")
    @NotNull
    @Min(1)
    protected Float unitCost;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    @Version
    @Column(name = "version")
    private int version;
    @Column(nullable = false)
    @NotNull
    @Min(1)
    private Integer quantity;

    // ======================================
    // =            Constructors            =
    // ======================================

    public InvoiceLine() {
    }

    public InvoiceLine(Integer quantity, String title, Float unitCost) {
        this.quantity = quantity;
        this.title = title;
        this.unitCost = unitCost;
    }

    // ======================================
    // =        Getters and Setters         =
    // ======================================

    public Long getId() {
        return this.id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public int getVersion() {
        return this.version;
    }

    public void setVersion(final int version) {
        this.version = version;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Float getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(Float unitCost) {
        this.unitCost = unitCost;
    }

    // ======================================
    // =   Methods hash, equals, toString   =
    // ======================================

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceLine that = (InvoiceLine) o;
        return Objects.equals(quantity, that.quantity) &&
                Objects.equals(title, that.title) &&
                Objects.equals(unitCost, that.unitCost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(quantity, title, unitCost);
    }

    @Override
    public String toString() {
        return "InvoiceLine{" +
                "id=" + id +
                ", version=" + version +
                ", quantity=" + quantity +
                ", title='" + title + '\'' +
                ", unitCost=" + unitCost +
                '}';
    }
}