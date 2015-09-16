package org.agoncal.application.cdbookstore.view.shopping;

import java.util.List;

import javax.annotation.PostConstruct;
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
public class RatedItemsBean
{

   @Inject
   private FacesContext facesContext;

   @PersistenceContext(unitName = "applicationCDBookStorePU")
   private EntityManager em;

   List<Item> topRatedItems;

   @PostConstruct
   private void doFindTopRated()
   {
      TypedQuery<Item> query = em.createNamedQuery(Item.FIND_TOP_RATED, Item.class);
      topRatedItems = query.getResultList();

   }

   public List<Item> getTopRatedItems()
   {
      return topRatedItems;
   }

   public void setTopRatedItems(List<Item> topRatedItems)
   {
      this.topRatedItems = topRatedItems;
   }
}