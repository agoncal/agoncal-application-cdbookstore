package org.agoncal.application.cdbookstore.view.shopping;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.agoncal.application.cdbookstore.model.CreditCard;
import org.agoncal.application.cdbookstore.model.CreditCardType;
import org.agoncal.application.cdbookstore.model.Item;

/**
 * @author Antonio Goncalves http://www.antoniogoncalves.org --
 */

@Named
@SessionScoped
public class ShoppingCartBean implements Serializable
{

   // ======================================
   // = Attributes =
   // ======================================

   @Inject
   private FacesContext facesContext;

   @PersistenceContext(unitName = "applicationCDBookStorePU")
   private EntityManager em;

   private List<ShoppingCartItem> cartItems = new ArrayList<>();
   private CreditCard creditCard = new CreditCard();

   // ======================================
   // = Public Methods =
   // ======================================

   public String addItemToCart()
   {
      Item item = em.find(Item.class, getParamId("itemId"));

      boolean itemFound = false;
      for (ShoppingCartItem cartItem : cartItems)
      {
         // If item already exists in the shopping cart we just change the quantity
         if (cartItem.getItem().equals(item))
         {
            cartItem.setQuantity(cartItem.getQuantity() + 1);
            itemFound = true;
         }
      }
      if (!itemFound)
         // Otherwise it's added to the shopping cart
         cartItems.add(new ShoppingCartItem(item, 1));

      facesContext.addMessage(null,
              new FacesMessage(FacesMessage.SEVERITY_INFO, item.getTitle(), "Added to the shopping cart"));

      return "/shopping/viewItem.xhtml?faces-redirect=true&includeViewParams=true";
   }

   public String removeItemFromCart()
   {
      Item item = em.find(Item.class, getParamId("itemId"));

      for (ShoppingCartItem cartItem : cartItems)
      {
         if (cartItem.getItem().equals(item))
         {
            cartItems.remove(cartItem);
            return null;
         }
      }

      return null;
   }

   public String updateQuantity()
   {
      return null;
   }

   public String checkout()
   {
      return "confirmorder.faces";
   }

   // public String confirmOrder() {
   // order = orderBean.createOrder(getCustomer(), creditCard, getCartItems());
   // cartItems.clear();
   //
   // // Stop conversation
   // if (!conversation.isTransient()) {
   // conversation.end();
   // }
   //
   // return "orderconfirmed.faces";
   // }

   public List<ShoppingCartItem> getCartItems()
   {
      return cartItems;
   }

   public boolean shoppingCartIsEmpty()
   {
      return getCartItems() == null || getCartItems().size() == 0;
   }

   public Float getTotal()
   {
      if (cartItems == null || cartItems.isEmpty())
         return 0f;

      Float total = 0f;

      // Sum up the quantities
      for (ShoppingCartItem cartItem : cartItems)
      {
         total += (cartItem.getSubTotal());
      }
      return total;
   }

   protected Long getParamId(String param)
   {
      FacesContext context = FacesContext.getCurrentInstance();
      Map<String, String> map = context.getExternalContext().getRequestParameterMap();
      return Long.valueOf(map.get(param));
   }

   // ======================================
   // = Getters & setters =
   // ======================================

   public CreditCard getCreditCard()
   {
      return creditCard;
   }

   public void setCreditCard(CreditCard creditCard)
   {
      this.creditCard = creditCard;
   }

   public CreditCardType[] getCreditCardTypes()
   {
      return CreditCardType.values();
   }
}