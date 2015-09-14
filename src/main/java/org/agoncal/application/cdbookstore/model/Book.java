package org.agoncal.application.cdbookstore.model;

import javax.persistence.Entity;
import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Min;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Enumerated;
import org.agoncal.application.cdbookstore.model.Language;
import org.agoncal.application.cdbookstore.model.Category;
import javax.persistence.ManyToOne;
import org.agoncal.application.cdbookstore.model.Author;
import java.util.Set;
import java.util.HashSet;
import javax.persistence.OneToMany;
import org.agoncal.application.cdbookstore.model.Publisher;
import javax.xml.bind.annotation.XmlRootElement;
@Entity
@XmlRootElement
public class Book implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	@Version
	@Column(name = "version")
	private int version;

	@Column(length = 30)
	@NotNull
	@Size(min = 1, max = 30)
	private String title;

	@Column(length = 3000)
	@Size(min = 1, max = 3000)
	private String description;

	@Column
	@Min(1)
	private Float unitCost;

	@Column(length = 15)
	@NotNull
	@Size(max = 15)
	private String isbn;

	@Column
	@Min(1)
	private Integer nbOfPage;

	@Column
	@Temporal(TemporalType.DATE)
	private Date publicationDate;

	@Enumerated
	private Language language;

	@ManyToOne
	private Category category;

	@OneToMany
	private Set<Author> authors = new HashSet<Author>();

	@ManyToOne
	private Publisher publisher;

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
		if (!(obj instanceof Book)) {
			return false;
		}
		Book other = (Book) obj;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Float getUnitCost() {
		return unitCost;
	}

	public void setUnitCost(Float unitCost) {
		this.unitCost = unitCost;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Integer getNbOfPage() {
		return nbOfPage;
	}

	public void setNbOfPage(Integer nbOfPage) {
		this.nbOfPage = nbOfPage;
	}

	public Date getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	@Override
	public String toString() {
		String result = getClass().getSimpleName() + " ";
		if (id != null)
			result += "id: " + id;
		result += ", version: " + version;
		if (title != null && !title.trim().isEmpty())
			result += ", title: " + title;
		if (description != null && !description.trim().isEmpty())
			result += ", description: " + description;
		if (unitCost != null)
			result += ", unitCost: " + unitCost;
		if (isbn != null && !isbn.trim().isEmpty())
			result += ", isbn: " + isbn;
		if (nbOfPage != null)
			result += ", nbOfPage: " + nbOfPage;
		if (publicationDate != null)
			result += ", publicationDate: " + publicationDate;
		if (language != null)
			result += ", language: " + language;
		return result;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(final Category category) {
		this.category = category;
	}

	public Set<Author> getAuthors() {
		return this.authors;
	}

	public void setAuthors(final Set<Author> authors) {
		this.authors = authors;
	}

	public Publisher getPublisher() {
		return this.publisher;
	}

	public void setPublisher(final Publisher publisher) {
		this.publisher = publisher;
	}
}