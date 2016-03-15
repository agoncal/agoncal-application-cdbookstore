package org.agoncal.application.cdbookstore.view.admin;

import org.agoncal.application.cdbookstore.model.Artist;
import org.agoncal.application.cdbookstore.model.Author;
import org.agoncal.application.cdbookstore.model.Language;
import org.agoncal.application.cdbookstore.model.LanguageConverter;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import static org.agoncal.application.cdbookstore.model.Language.ENGLISH;
import static org.junit.Assert.*;

@RunWith(Arquillian.class)
public class AuthorBeanTest {

    // ======================================
    // =          Injection Points          =
    // ======================================

    @Inject
    private AuthorBean authorBean;

    // ======================================
    // =         Deployment methods         =
    // ======================================

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap
                .create(JavaArchive.class)
                .addClass(AuthorBean.class)
                .addClass(Author.class)
                .addClass(Artist.class)
                .addClass(Language.class)
                .addClass(LanguageConverter.class)
                .addAsManifestResource("META-INF/persistence-test.xml", "persistence.xml")
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    // ======================================
    // =            Test methods            =
    // ======================================

    @Test
    public void should_be_deployed() {
        assertNotNull(authorBean);
    }

    @Test
    public void should_crud() {
        // Creates an object
        Author author = new Author();
        author.setFirstName("Dummy value");
        author.setLastName("Dummy value");
        author.setPreferredLanguage(ENGLISH);

        // Inserts the object into the database
        authorBean.setAuthor(author);
        authorBean.create();
        authorBean.update();
        author = authorBean.getAuthor();
        assertNotNull(author.getId());

        // Finds the object from the database and checks it's the right one
        author = authorBean.findById(author.getId());
        assertEquals("Dummy value", author.getFirstName());

        // Deletes the object from the database and checks it's not there anymore
        authorBean.setId(author.getId());
        authorBean.create();
        authorBean.delete();
        author = authorBean.findById(author.getId());
        assertNull(author);
    }

    @Test
    public void should_paginate() {
        // Creates an empty example
        Author example = new Author();

        // Paginates through the example
        authorBean.setExample(example);
        authorBean.paginate();
        assertTrue((authorBean.getPageItems().size() == authorBean.getPageSize())
                || (authorBean.getPageItems().size() == authorBean.getCount()));
    }
}
