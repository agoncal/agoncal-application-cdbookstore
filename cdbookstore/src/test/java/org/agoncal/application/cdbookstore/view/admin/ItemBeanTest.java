package org.agoncal.application.cdbookstore.view.admin;

import org.agoncal.application.cdbookstore.model.Item;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import static org.junit.Assert.*;

@RunWith(Arquillian.class)
public class ItemBeanTest {

    // ======================================
    // =          Injection Points          =
    // ======================================

    @Inject
    private ItemBean itemBean;

    // ======================================
    // =         Deployment methods         =
    // ======================================

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap
                .create(JavaArchive.class)
                .addClass(ItemBean.class)
                .addClass(Item.class)
                .addAsManifestResource("META-INF/persistence-test.xml", "persistence.xml")
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    // ======================================
    // =            Test methods            =
    // ======================================

    @Test
    public void should_be_deployed() {
        assertNotNull(itemBean);
    }

    @Test
    public void should_crud() {
        // Creates an object
        Item item = new Item();
        item.setTitle("Dummy value");

        // Inserts the object into the database
        itemBean.setItem(item);
        itemBean.create();
        itemBean.update();
        item = itemBean.getItem();
        assertNotNull(item.getId());

        // Finds the object from the database and checks it's the right one
        item = itemBean.findById(item.getId());
        assertEquals("Dummy value", item.getTitle());

        // Deletes the object from the database and checks it's not there anymore
        itemBean.setId(item.getId());
        itemBean.create();
        itemBean.delete();
        item = itemBean.findById(item.getId());
        assertNull(item);
    }

    @Test
    public void should_paginate() {
        // Creates an empty example
        Item example = new Item();

        // Paginates through the example
        itemBean.setExample(example);
        itemBean.paginate();
        assertTrue((itemBean.getPageItems().size() == itemBean.getPageSize())
                || (itemBean.getPageItems().size() == itemBean.getCount()));
    }
}
