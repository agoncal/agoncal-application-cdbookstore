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
public class MusicianBeanTest {

    // ======================================
    // =          Injection Points          =
    // ======================================

    @Inject
    private MusicianBean musicianBean;

    // ======================================
    // =         Deployment methods         =
    // ======================================

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap
                .create(JavaArchive.class)
                .addClass(MusicianBean.class)
                .addClass(Musician.class)
                .addClass(Artist.class)
                .addClass(CD.class)
                .addClass(Item.class)
                .addClass(Genre.class)
                .addClass(Label.class)
                .addAsManifestResource("META-INF/persistence-test.xml", "persistence.xml")
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    // ======================================
    // =            Test methods            =
    // ======================================

    @Test
    public void should_be_deployed() {
        assertNotNull(musicianBean);
    }

    @Test
    public void should_crud() {
        // Creates an object
        Musician musician = new Musician();
        musician.setFirstName("Dummy value");
        musician.setLastName("Dummy value");

        // Inserts the object into the database
        musicianBean.setMusician(musician);
        musicianBean.create();
        musicianBean.update();
        musician = musicianBean.getMusician();
        assertNotNull(musician.getId());

        // Finds the object from the database and checks it's the right one
        musician = musicianBean.findById(musician.getId());
        assertEquals("Dummy value", musician.getFirstName());

        // Deletes the object from the database and checks it's not there anymore
        musicianBean.setId(musician.getId());
        musicianBean.create();
        musicianBean.delete();
        musician = musicianBean.findById(musician.getId());
        assertNull(musician);
    }

    @Test
    public void should_paginate() {
        // Creates an empty example
        Musician example = new Musician();

        // Paginates through the example
        musicianBean.setExample(example);
        musicianBean.paginate();
        assertTrue((musicianBean.getPageItems().size() == musicianBean.getPageSize())
                || (musicianBean.getPageItems().size() == musicianBean.getCount()));
    }
}
