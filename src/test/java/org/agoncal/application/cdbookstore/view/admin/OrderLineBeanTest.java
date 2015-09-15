package org.agoncal.application.cdbookstore.view.admin;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.agoncal.application.cdbookstore.model.Item;
import org.agoncal.application.cdbookstore.model.OrderLine;
import org.agoncal.application.cdbookstore.view.admin.OrderLineBean;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class OrderLineBeanTest
{

   @Inject
   private OrderLineBean orderLineBean;

   @Deployment
   public static JavaArchive createDeployment()
   {
      return ShrinkWrap
               .create(JavaArchive.class)
               .addClass(OrderLineBean.class)
               .addClass(OrderLine.class)
               .addClass(Item.class)
               .addAsManifestResource("META-INF/persistence-test.xml", "persistence.xml")
               .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
   }

   @Test
   public void should_be_deployed()
   {
      assertNotNull(orderLineBean);
   }

   @Test
   public void should_crud()
   {
      // Creates an object
      OrderLine orderLine = new OrderLine();
      orderLine.setQuantity(99);

      // Inserts the object into the database
      orderLineBean.setOrderLine(orderLine);
      orderLineBean.create();
      orderLineBean.update();
      orderLine = orderLineBean.getOrderLine();
      assertNotNull(orderLine.getId());

      // Finds the object from the database and checks it's the right one
      orderLine = orderLineBean.findById(orderLine.getId());
      assertEquals(new Integer(99), orderLine.getQuantity());

      // Deletes the object from the database and checks it's not there anymore
      orderLineBean.setId(orderLine.getId());
      orderLineBean.create();
      orderLineBean.delete();
      orderLine = orderLineBean.findById(orderLine.getId());
      assertNull(orderLine);
   }

   @Test
   public void should_paginate()
   {
      // Creates an empty example
      OrderLine example = new OrderLine();

      // Paginates through the example
      orderLineBean.setExample(example);
      orderLineBean.paginate();
      assertTrue((orderLineBean.getPageItems().size() == orderLineBean.getPageSize())
               || (orderLineBean.getPageItems().size() == orderLineBean.getCount()));
   }
}
