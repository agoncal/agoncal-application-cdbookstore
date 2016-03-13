package org.agoncal.application.invoice.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateful;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.agoncal.application.invoice.model.Invoice;

/**
 * Backing bean for Invoice entities.
 * <p/>
 * This class provides CRUD functionality for all Invoice entities. It focuses
 * purely on Java EE 6 standards (e.g. <tt>&#64;ConversationScoped</tt> for
 * state management, <tt>PersistenceContext</tt> for persistence,
 * <tt>CriteriaBuilder</tt> for searches) rather than introducing a CRUD
 * framework or custom base class.
 */

@Named
@Stateful
@ConversationScoped
public class InvoiceBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * Support creating and retrieving Invoice entities
	 */

	private Long id;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private Invoice invoice;

	public Invoice getInvoice() {
		return this.invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	@Inject
	private Conversation conversation;

	@PersistenceContext(unitName = "applicationInvoicePU", type = PersistenceContextType.EXTENDED)
	private EntityManager entityManager;

	public String create() {

		this.conversation.begin();
		this.conversation.setTimeout(1800000L);
		return "create?faces-redirect=true";
	}

	public void retrieve() {

		if (FacesContext.getCurrentInstance().isPostback()) {
			return;
		}

		if (this.conversation.isTransient()) {
			this.conversation.begin();
			this.conversation.setTimeout(1800000L);
		}

		if (this.id == null) {
			this.invoice = this.example;
		} else {
			this.invoice = findById(getId());
		}
	}

	public Invoice findById(Long id) {

		return this.entityManager.find(Invoice.class, id);
	}

	/*
	 * Support updating and deleting Invoice entities
	 */

	public String update() {
		this.conversation.end();

		try {
			if (this.id == null) {
				this.entityManager.persist(this.invoice);
				return "search?faces-redirect=true";
			} else {
				this.entityManager.merge(this.invoice);
				return "view?faces-redirect=true&id=" + this.invoice.getId();
			}
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(e.getMessage()));
			return null;
		}
	}

	public String delete() {
		this.conversation.end();

		try {
			Invoice deletableEntity = findById(getId());

			this.entityManager.remove(deletableEntity);
			this.entityManager.flush();
			return "search?faces-redirect=true";
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(e.getMessage()));
			return null;
		}
	}

	/*
	 * Support searching Invoice entities with pagination
	 */

	private int page;
	private long count;
	private List<Invoice> pageItems;

	private Invoice example = new Invoice();

	public int getPage() {
		return this.page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return 10;
	}

	public Invoice getExample() {
		return this.example;
	}

	public void setExample(Invoice example) {
		this.example = example;
	}

	public String search() {
		this.page = 0;
		return null;
	}

	public void paginate() {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();

		// Populate this.count

		CriteriaQuery<Long> countCriteria = builder.createQuery(Long.class);
		Root<Invoice> root = countCriteria.from(Invoice.class);
		countCriteria = countCriteria.select(builder.count(root)).where(
				getSearchPredicates(root));
		this.count = this.entityManager.createQuery(countCriteria)
				.getSingleResult();

		// Populate this.pageItems

		CriteriaQuery<Invoice> criteria = builder.createQuery(Invoice.class);
		root = criteria.from(Invoice.class);
		TypedQuery<Invoice> query = this.entityManager.createQuery(criteria
				.select(root).where(getSearchPredicates(root)));
		query.setFirstResult(this.page * getPageSize()).setMaxResults(
				getPageSize());
		this.pageItems = query.getResultList();
	}

	private Predicate[] getSearchPredicates(Root<Invoice> root) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		List<Predicate> predicatesList = new ArrayList<Predicate>();

		String firstName = this.example.getFirstName();
		if (firstName != null && !"".equals(firstName)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("firstName")),
					'%' + firstName.toLowerCase() + '%'));
		}
		String lastName = this.example.getLastName();
		if (lastName != null && !"".equals(lastName)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("lastName")),
					'%' + lastName.toLowerCase() + '%'));
		}
		String telephone = this.example.getTelephone();
		if (telephone != null && !"".equals(telephone)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("telephone")),
					'%' + telephone.toLowerCase() + '%'));
		}
		String email = this.example.getEmail();
		if (email != null && !"".equals(email)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("email")),
					'%' + email.toLowerCase() + '%'));
		}
		String street1 = this.example.getStreet1();
		if (street1 != null && !"".equals(street1)) {
			predicatesList.add(builder.like(
					builder.lower(root.<String> get("street1")),
					'%' + street1.toLowerCase() + '%'));
		}

		return predicatesList.toArray(new Predicate[predicatesList.size()]);
	}

	public List<Invoice> getPageItems() {
		return this.pageItems;
	}

	public long getCount() {
		return this.count;
	}

	/*
	 * Support listing and POSTing back Invoice entities (e.g. from inside an
	 * HtmlSelectOneMenu)
	 */

	public List<Invoice> getAll() {

		CriteriaQuery<Invoice> criteria = this.entityManager
				.getCriteriaBuilder().createQuery(Invoice.class);
		return this.entityManager.createQuery(
				criteria.select(criteria.from(Invoice.class))).getResultList();
	}

	@Resource
	private SessionContext sessionContext;

	public Converter getConverter() {

		final InvoiceBean ejbProxy = this.sessionContext
				.getBusinessObject(InvoiceBean.class);

		return new Converter() {

			@Override
			public Object getAsObject(FacesContext context,
					UIComponent component, String value) {

				return ejbProxy.findById(Long.valueOf(value));
			}

			@Override
			public String getAsString(FacesContext context,
					UIComponent component, Object value) {

				if (value == null) {
					return "";
				}

				return String.valueOf(((Invoice) value).getId());
			}
		};
	}

	/*
	 * Support adding children to bidirectional, one-to-many tables
	 */

	private Invoice add = new Invoice();

	public Invoice getAdd() {
		return this.add;
	}

	public Invoice getAdded() {
		Invoice added = this.add;
		this.add = new Invoice();
		return added;
	}
}
