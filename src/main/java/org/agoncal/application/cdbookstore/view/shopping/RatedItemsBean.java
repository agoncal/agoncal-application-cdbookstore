package org.agoncal.application.cdbookstore.view.shopping;

import java.util.*;

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
   Set<Item> randomItems = new HashSet<>();

   @PostConstruct
   private void init()
   {
      doFindTopRated();
      doFindRandomThree();

   }

   private void doFindRandomThree()
   {
      int min = em.createQuery("select min (i.id) from Item i", Long.class).getSingleResult().intValue();
      int max = em.createQuery("select max (i.id) from Item i", Long.class).getSingleResult().intValue();

      while (randomItems.size() < 3)
      {
         long id = new Random().nextInt((max - min) + 1) + min;
         Item item = em.find(Item.class, id);
         if (item != null)
            randomItems.add(item);
      }
   }

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

   public List<Item> getRandomItems()
   {
      return new ArrayList<>(randomItems);
   }
}