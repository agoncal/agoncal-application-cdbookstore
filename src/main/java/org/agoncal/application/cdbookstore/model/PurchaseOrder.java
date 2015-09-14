package org.agoncal.application.cdbookstore.model;

import javax.persistence.Entity;
import java.io.Serializable;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Version;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.agoncal.application.cdbookstore.model.User;
import javax.persistence.ManyToOne;
import org.agoncal.application.cdbookstore.model.OrderLine;
import java.util.Set;
import java.util.HashSet;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.Enumerated;
import org.agoncal.application.cdbookstore.model.CreditCardType;
@Entity
@Table(name = "purchase_order")
public class PurchaseOrder implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	@Version
	@Column(name = "version")
	private int version;

	@Column(name = "order_date", updatable = false)
	@Temporal(TemporalType.DATE)
	@Past
	private Date orderDate;

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

	@ManyToOne
	private User customer;

	@OneToMany
	private Set<OrderLine> orderLines = new HashSet<OrderLine>();

	@Column(length = 50)
	@NotNull
	@Size(min = 5, max = 50)
	private String street1;

	@Column
	private String street2;

	@Column(length = 50)
	@NotNull
	@Size(min = 5, max = 50)
	private String city;

	@Column
	private String state;

	@Column(length = 10, name = "zip_code")
	@NotNull
	@Size(min = 1, max = 10)
	private String zipcode;

	@Column(name = "credit_card_number")
	@NotNull
	@Size(min = 1, max = 30)
	private String creditCardNumber;

	@Enumerated
	@Column(name = "credit_card_type")
	@NotNull
	private CreditCardType creditCardType;

	@Column(name = "credit_card_expiry_date")
	@NotNull
	@Size(min = 5, max = 5)
	private String creditCardExpDate;

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

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof PurchaseOrder)) {
			return false;
		}
		PurchaseOrder other = (PurchaseOrder) obj;
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

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
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

	public User getCustomer() {
		return this.customer;
	}

	public void setCustomer(final User customer) {
		this.customer = customer;
	}

	public Set<OrderLine> getOrderLines() {
		return this.orderLines;
	}

	public void setOrderLines(final Set<OrderLine> orderLines) {
		this.orderLines = orderLines;
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

	@Override
	public String toString() {
		String result = getClass().getSimpleName() + " ";
		if (id != null)
			result += "id: " + id;
		result += ", version: " + version;
		if (orderDate != null)
			result += ", orderDate: " + orderDate;
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
		if (customer != null)
			result += ", customer: " + customer;
		if (orderLines != null)
			result += ", orderLines: " + orderLines;
		if (street1 != null && !street1.trim().isEmpty())
			result += ", street1: " + street1;
		if (street2 != null && !street2.trim().isEmpty())
			result += ", street2: " + street2;
		if (city != null && !city.trim().isEmpty())
			result += ", city: " + city;
		if (state != null && !state.trim().isEmpty())
			result += ", state: " + state;
		if (zipcode != null && !zipcode.trim().isEmpty())
			result += ", zipcode: " + zipcode;
		if (creditCardNumber != null && !creditCardNumber.trim().isEmpty())
			result += ", creditCardNumber: " + creditCardNumber;
		if (creditCardType != null)
			result += ", creditCardType: " + creditCardType;
		if (creditCardExpDate != null && !creditCardExpDate.trim().isEmpty())
			result += ", creditCardExpDate: " + creditCardExpDate;
		return result;
	}
}