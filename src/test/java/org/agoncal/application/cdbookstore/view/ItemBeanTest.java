package org.agoncal.application.cdbookstore.view;

import javax.inject.Inject;

import org.agoncal.application.cdbookstore.model.Item;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class ItemBeanTest
{

   @Inject
   private ItemBean itemBean;

   @Deployment
   public static JavaArchive createDeployment()
   {
      return ShrinkWrap
               .create(JavaArchive.class)
               .addClass(ItemBean.class)
               .addClass(Item.class)
               .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
               .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
   }

   @Test
   public void should_be_deployed()
   {
      Assert.assertNotNull(itemBean);
   }
}
