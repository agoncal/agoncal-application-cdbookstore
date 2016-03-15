package org.agoncal.application.cdbookstore.view.admin;

import org.agoncal.application.cdbookstore.model.*;
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
public class BookBeanTest {

    // ======================================
    // =          Injection Points          =
    // ======================================

    @Inject
    private BookBean bookBean;

    // ======================================
    // =         Deployment methods         =
    // ======================================

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap
                .create(JavaArchive.class)
                .addClass(BookBean.class)
                .addClass(Book.class)
                .addClass(Item.class)
                .addClass(Language.class)
                .addClass(LanguageConverter.class)
                .addClass(Category.class)
                .addClass(Publisher.class)
                .addClass(Artist.class)
                .addClass(Author.class)
                .addAsManifestResource("META-INF/persistence-test.xml", "persistence.xml")
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    // ======================================
    // =            Test methods            =
    // ======================================

    @Test
    public void should_be_deployed() {
        assertNotNull(bookBean);
    }

    @Test
    public void should_crud() {
        // Creates an object
        Book book = new Book();
        book.setTitle("Dummy value");
        book.setIsbn("Dummy value");

        // Inserts the object into the database
        bookBean.setBook(book);
        bookBean.create();
        bookBean.update();
        book = bookBean.getBook();
        assertNotNull(book.getId());

        // Finds the object from the database and checks it's the right one
        book = bookBean.findById(book.getId());
        assertEquals("Dummy value", book.getTitle());

        // Deletes the object from the database and checks it's not there anymore
        bookBean.setId(book.getId());
        bookBean.create();
        bookBean.delete();
        book = bookBean.findById(book.getId());
        assertNull(book);
    }

    @Test
    public void should_paginate() {
        // Creates an empty example
        Book example = new Book();

        // Paginates through the example
        bookBean.setExample(example);
        bookBean.paginate();
        assertTrue((bookBean.getPageItems().size() == bookBean.getPageSize())
                || (bookBean.getPageItems().size() == bookBean.getCount()));
    }
}
