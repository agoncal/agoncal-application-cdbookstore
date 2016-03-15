package org.agoncal.application.cdbookstore.view.admin;

import org.agoncal.application.cdbookstore.model.User;
import org.agoncal.application.cdbookstore.model.UserRole;
import org.agoncal.application.cdbookstore.util.PasswordUtils;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import static org.junit.Assert.*;

@RunWith(Arquillian.class)
public class UserBeanTest {

    // ======================================
    // =          Injection Points          =
    // ======================================

    @Inject
    private UserBean userBean;

    // ======================================
    // =         Deployment methods         =
    // ======================================

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap
                .create(JavaArchive.class)
                .addClass(UserBean.class)
                .addClass(User.class)
                .addClass(UserRole.class)
                .addClass(PasswordUtils.class)
                .addAsManifestResource("META-INF/persistence-test.xml", "persistence.xml")
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    // ======================================
    // =            Test methods            =
    // ======================================

    @Test
    public void should_be_deployed() {
        Assert.assertNotNull(userBean);
    }

    @Test
    public void should_crud() {
        // Creates an object
        User user = new User();
        user.setFirstName("Dummy value");
        user.setLastName("Dummy value");
        user.setLogin("Dummy");
        user.setPassword("Dummy value");
        user.setEmail("Dummy value");

        // Inserts the object into the database
        userBean.setUser(user);
        userBean.create();
        userBean.update();
        user = userBean.getUser();
        assertNotNull(user.getId());

        // Finds the object from the database and checks it's the right one
        user = userBean.findById(user.getId());
        assertEquals("Dummy value", user.getFirstName());

        // Deletes the object from the database and checks it's not there anymore
        userBean.setId(user.getId());
        userBean.create();
        userBean.delete();
        user = userBean.findById(user.getId());
        assertNull(user);
    }

    @Test
    public void should_paginate() {
        // Creates an empty example
        User example = new User();

        // Paginates through the example
        userBean.setExample(example);
        userBean.paginate();
        assertTrue((userBean.getPageItems().size() == userBean.getPageSize())
                || (userBean.getPageItems().size() == userBean.getCount()));
    }
}
