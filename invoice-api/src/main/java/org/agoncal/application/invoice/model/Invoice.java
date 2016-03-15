package org.agoncal.application.invoice.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.*;

/**
 * @author Antonio Goncalves
 *         http://www.antoniogoncalves.org
 *         --
 */

@Entity
@NamedQuery(name = Invoice.FIND_MONTHLY, query = "SELECT i FROM Invoice i ORDER BY i.invoiceDate ASC")
public class Invoice implements Serializable {

    // ======================================
    // =             Constants              =
    // ======================================

    public static final String FIND_MONTHLY = "Invoice.findMonthly";

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
    private Float totalBeforeDiscount;

    @Column(name = "discount_rate")
    private Float discountRate;
    private Float discount;
    private Float totalAfterDiscount;

    @Column(name = "vat_rate")
    private Float vatRate;
    private Float vat;
    private Float totalAfterVat;

    @Column(length = 50, name = "first_name", nullable = false)
    @NotNull
    @Size(min = 2, max = 50)
    private String firstName;

    @Column(length = 50, name = "last_name", nullable = false)
    @NotNull
    @Size(min = 2, max = 50)
    private String lastName;
    private String telephone;

    @Column
    @NotNull
    private String email;

    @Column(length = 50, nullable = false)
    @Size(min = 5, max = 50)
    @NotNull
    private String street1;
    private String street2;

    @Column(length = 50, nullable = false)
    @Size(min = 2, max = 50)
    @NotNull
    private String city;
    private String state;

    @Column(length = 10, name = "zip_code", nullable = false)
    @Size(min = 1, max = 10)
    @NotNull
    private String zipcode;
    private String country;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<InvoiceLine> invoiceLines = new HashSet<>();

    // ======================================
    // =            Constructors            =
    // ======================================

    public Invoice() {
    }

    public Invoice(String firstName, String lastName, String email, String street1, String city, String zipcode, String country) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.street1 = street1;
        this.city = city;
        this.country = country;
        this.zipcode = zipcode;
    }

    public Invoice(String firstName, String lastName, String email, String street1, String city, String zipcode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.street1 = street1;
        this.city = city;
        this.zipcode = zipcode;
    }

    public Invoice(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

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

    public int getMonth() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(invoiceDate);
        return cal.get(Calendar.MONTH);
    }

    public Float getTotalBeforeDiscount() {
        return totalBeforeDiscount;
    }

    public void setTotalBeforeDiscount(Float totalBeforeDiscount) {
        this.totalBeforeDiscount = totalBeforeDiscount;
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

    public Float getDiscount() {
        return discount;
    }

    public void setDiscount(Float discount) {
        this.discount = discount;
    }

    public Float getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(Float discountRate) {
        this.discountRate = discountRate;
    }

    public Float getTotalAfterDiscount() {
        return totalAfterDiscount;
    }

    public void setTotalAfterDiscount(Float totalAfterDiscount) {
        this.totalAfterDiscount = totalAfterDiscount;
    }

    public Float getTotalAfterVat() {
        return totalAfterVat;
    }

    public void setTotalAfterVat(Float totalAfterVat) {
        this.totalAfterVat = totalAfterVat;
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

    public void addInvoiceLine(InvoiceLine invoiceLine) {
        invoiceLines.add(invoiceLine);
    }

    // ======================================
    // =   Methods hash, equals, toString   =
    // ======================================

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return Objects.equals(invoiceDate, invoice.invoiceDate) &&
                Objects.equals(firstName, invoice.firstName) &&
                Objects.equals(lastName, invoice.lastName) &&
                Objects.equals(email, invoice.email) &&
                Objects.equals(invoiceLines, invoice.invoiceLines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(invoiceDate, firstName, lastName, email, invoiceLines);
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "city='" + city + '\'' +
                ", id=" + id +
                ", version=" + version +
                ", invoiceDate=" + invoiceDate +
                ", totalBeforeDiscount=" + totalBeforeDiscount +
                ", discountRate=" + discountRate +
                ", discount=" + discount +
                ", totalAfterDiscount=" + totalAfterDiscount +
                ", vatRate=" + vatRate +
                ", vat=" + vat +
                ", totalAfterVat=" + totalAfterVat +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", street1='" + street1 + '\'' +
                ", street2='" + street2 + '\'' +
                ", state='" + state + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", country='" + country + '\'' +
                ", invoiceLines=" + invoiceLines +
                '}';
    }
}