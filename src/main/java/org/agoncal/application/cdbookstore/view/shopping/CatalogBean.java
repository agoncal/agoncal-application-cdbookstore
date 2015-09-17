package org.agoncal.application.cdbookstore.view.shopping;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.agoncal.application.cdbookstore.model.Item;

@Named
@RequestScoped
@Transactional
public class CatalogBean
{

   private String keyword;
   private List<Item> items;

   @Inject
   private FacesContext facesContext;

   @PersistenceContext(unitName = "applicationCDBookStorePU")
   private EntityManager em;

   public String doSearch()
   {
      TypedQuery<Item> typedQuery = em.createNamedQuery(Item.SEARCH, Item.class);
      typedQuery.setParameter("keyword", "%" + keyword.toUpperCase() + "%");
      items = typedQuery.getResultList();
      return null;
   }

   public String getKeyword()
   {
      return keyword;
   }

   public void setKeyword(String keyword)
   {
      this.keyword = keyword;
   }

   public List<Item> getItems()
   {
      return items;
   }

   public void setItems(List<Item> items)
   {
      this.items = items;
   }
}