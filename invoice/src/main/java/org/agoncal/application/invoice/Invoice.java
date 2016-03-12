package org.agoncal.application.invoice;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Antonio Goncalves
 *         http://www.antoniogoncalves.org
 *         --
 */

@Entity
public class Invoice implements Serializable {

    // ======================================
    // =             Attributes             =
    // ======================================

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    @Version
    @Column(name = "version")
    private int version;

    @Column(name = "invoice_date", updatable = false)
    @Temporal(TemporalType.DATE)
    @Past
    private Date invoiceDate;

    @Column
    private Float totalWithoutVat;

    @Column(name = "vat_rate")
    private Float vatRate;

    @Column
    private Float vat;

    @Column
    private Float totalWithVat;

    @Column
    private Float total;

    @Column(length = 50, name = "first_name", nullable = false)
    @NotNull
    @Size(min = 2, max = 50)
    private String firstName;

    @Column(length = 50, name = "last_name", nullable = false)
    @NotNull
    @Size(min = 2, max = 50)
    private String lastName;

    @Column
    private String telephone;

    @Column
    @NotNull
    private String email;

    @Column(length = 50, nullable = false)
    @Size(min = 5, max = 50)
    @NotNull
    private String street1;

    @Column
    private String street2;

    @Column(length = 50, nullable = false)
    @Size(min = 2, max = 50)
    @NotNull
    private String city;

    @Column
    private String state;

    @Column(length = 10, name = "zip_code", nullable = false)
    @Size(min = 1, max = 10)
    @NotNull
    private String zipcode;

    @NotNull
    private String country;

    @OneToMany
    private Set<InvoiceLine> invoiceLines = new HashSet<>();

    // ======================================
    // =        Getters and Setters         =
    // ======================================

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public Float getTotalWithoutVat() {
        return totalWithoutVat;
    }

    public void setTotalWithoutVat(Float totalWithoutVat) {
        this.totalWithoutVat = totalWithoutVat;
    }

    public Float getVatRate() {
        return vatRate;
    }

    public void setVatRate(Float vatRate) {
        this.vatRate = vatRate;
    }

    public Float getVat() {
        return vat;
    }

    public void setVat(Float vat) {
        this.vat = vat;
    }

    public Float getTotalWithVat() {
        return totalWithVat;
    }

    public void setTotalWithVat(Float totalWithVat) {
        this.totalWithVat = totalWithVat;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Set<InvoiceLine> getInvoiceLines() {
        return invoiceLines;
    }

    public void setInvoiceLines(Set<InvoiceLine> invoiceLines) {
        this.invoiceLines = invoiceLines;
    }


    // ======================================
    // =   Methods hash, equals, toString   =
    // ======================================

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Invoice)) {
            return false;
        }
        Invoice other = (Invoice) obj;
        if (id != null) {
            if (!id.equals(other.id)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public String toString() {
        String result = getClass().getSimpleName() + " ";
        if (id != null)
            result += "id: " + id;
        result += ", version: " + version;
        if (invoiceDate != null)
            result += ", orderDate: " + invoiceDate;
        if (totalWithoutVat != null)
            result += ", totalWithoutVat: " + totalWithoutVat;
        if (vatRate != null)
            result += ", vatRate: " + vatRate;
        if (vat != null)
            result += ", vat: " + vat;
        if (totalWithVat != null)
            result += ", totalWithVat: " + totalWithVat;
        if (total != null)
            result += ", total: " + total;
        if (invoiceLines != null)
            result += ", orderLines: " + invoiceLines;
        if (getStreet1() != null && !getStreet1().trim().isEmpty())
            result += ", street1: " + getStreet1();
        if (getStreet2() != null && !getStreet2().trim().isEmpty())
            result += ", street2: " + getStreet2();
        if (getCity() != null && !getCity().trim().isEmpty())
            result += ", city: " + getCity();
        if (getState() != null && !getState().trim().isEmpty())
            result += ", state: " + getState();
        if (getZipcode() != null && !getZipcode().trim().isEmpty())
            result += ", zipcode: " + getZipcode();
        return result;
    }
}