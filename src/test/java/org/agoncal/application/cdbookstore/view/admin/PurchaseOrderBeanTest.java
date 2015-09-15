package org.agoncal.application.cdbookstore.view.admin;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.agoncal.application.cdbookstore.model.*;
import org.agoncal.application.cdbookstore.view.admin.PurchaseOrderBean;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class PurchaseOrderBeanTest
{

   @Inject
   private PurchaseOrderBean purchaseOrderBean;

   @Deployment
   public static JavaArchive createDeployment()
   {
      return ShrinkWrap
               .create(JavaArchive.class)
               .addClass(PurchaseOrderBean.class)
               .addClass(PurchaseOrder.class)
               .addClass(Address.class)
               .addClass(Country.class)
               .addClass(User.class)
               .addClass(UserRole.class)
               .addClass(CreditCard.class)
               .addClass(CreditCardType.class)
               .addClass(OrderLine.class)
               .addClass(Item.class)
               .addAsManifestResource("META-INF/persistence-test.xml", "persistence.xml")
               .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
   }

   @Test
   public void should_be_deployed()
   {
      assertNotNull(purchaseOrderBean);
   }

   @Test
   public void should_crud()
   {
      // Creates an object
      PurchaseOrder purchaseOrder = new PurchaseOrder();
      purchaseOrder.setCreditCardType(CreditCardType.MASTER_CARD);
      purchaseOrder.setCreditCardExpDate("Dummy");
      purchaseOrder.setCreditCardNumber("Dummy value");
      purchaseOrder.setStreet1("Dummy value");
      purchaseOrder.setCity("Dummy value");
      purchaseOrder.setZipcode("Dummy");

      // Inserts the object into the database
      purchaseOrderBean.setPurchaseOrder(purchaseOrder);
      purchaseOrderBean.create();
      purchaseOrderBean.update();
      purchaseOrder = purchaseOrderBean.getPurchaseOrder();
      assertNotNull(purchaseOrder.getId());

      // Finds the object from the database and checks it's the right one
      purchaseOrder = purchaseOrderBean.findById(purchaseOrder.getId());
      assertEquals("Dummy value", purchaseOrder.getStreet1());

      // Deletes the object from the database and checks it's not there anymore
      purchaseOrderBean.setId(purchaseOrder.getId());
      purchaseOrderBean.create();
      purchaseOrderBean.delete();
      purchaseOrder = purchaseOrderBean.findById(purchaseOrder.getId());
      assertNull(purchaseOrder);
   }

   @Test
   public void should_paginate()
   {
      // Creates an empty example
      PurchaseOrder example = new PurchaseOrder();

      // Paginates through the example
      purchaseOrderBean.setExample(example);
      purchaseOrderBean.paginate();
      assertTrue((purchaseOrderBean.getPageItems().size() == purchaseOrderBean.getPageSize())
               || (purchaseOrderBean.getPageItems().size() == purchaseOrderBean.getCount()));
   }
}
