package org.agoncal.application.cdbookstore.view.shopping;

import org.agoncal.application.cdbookstore.model.Item;
import org.agoncal.application.cdbookstore.util.Auditable;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Named
@RequestScoped
@Transactional
public class CatalogBean {

    // ======================================
    // =          Injection Points          =
    // ======================================

    @Inject
    private FacesContext facesContext;

    @Inject
    private EntityManager em;

    // ======================================
    // =             Attributes             =
    // ======================================

    private String keyword;
    private List<Item> items;
    private Item item;
    private Long itemId;

    // ======================================
    // =          Business methods          =
    // ======================================

    @Auditable
    public String doSearch() {
        TypedQuery<Item> typedQuery = em.createNamedQuery(Item.SEARCH, Item.class);
        typedQuery.setParameter("keyword", "%" + keyword.toUpperCase() + "%");
        items = typedQuery.getResultList();
        return null;
    }

    public String doViewItemById() {
        item = em.find(Item.class, itemId);
        return null;
    }

    // ======================================
    // =        Getters and Setters         =
    // ======================================

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}