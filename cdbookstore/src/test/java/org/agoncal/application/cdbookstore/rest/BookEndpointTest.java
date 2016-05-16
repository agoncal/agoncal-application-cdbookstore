package org.agoncal.application.cdbookstore.rest;

import org.agoncal.application.cdbookstore.model.*;
import org.agoncal.application.cdbookstore.util.ResourceProducer;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.net.URI;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@RunWith(Arquillian.class)
@RunAsClient
public class BookEndpointTest {

    // ======================================
    // =          Injection Points          =
    // ======================================

    @ArquillianResource
    private URI baseURL;

    // ======================================
    // =         Deployment methods         =
    // ======================================

    @Deployment(testable = false)
    public static WebArchive createDeployment() {
        return ShrinkWrap
                .create(WebArchive.class)
                .addClass(RestApplication.class)
                .addClass(BookEndpoint.class)
                .addClass(Book.class)
                .addClass(Item.class)
                .addClass(Language.class)
                .addClass(LanguageConverter.class)
                .addClass(Category.class)
                .addClass(Publisher.class)
                .addClass(Artist.class)
                .addClass(Author.class)
                .addClass(ResourceProducer.class)
                .addAsResource("META-INF/persistence-test.xml", "META-INF/persistence.xml")
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    // ======================================
    // =            Test methods            =
    // ======================================

    @Test
    public void should_be_deployed() {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(baseURL).path("rest").path("books");
        assertEquals(Response.Status.OK.getStatusCode(), target.request(MediaType.APPLICATION_XML).get().getStatus());
    }

    @Test @Ignore
    public void shouldCRUDBooks() throws IOException {

        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(baseURL).path("rest").path("books");
        int initialSize = target.request(MediaType.APPLICATION_XML).get(Books.class).size();

        // creates a book
        Book book = new Book("1234-5678", "H2G2", "The best Scifi book", 45.5f, 345, Language.ENGLISH);
        Response response = target.request().post(Entity.entity(book, MediaType.APPLICATION_XML));
        assertEquals(201, response.getStatus());
        URI locationNewBook = response.getLocation();

        // checks there is one more book
        assertEquals(initialSize + 1, target.request(MediaType.APPLICATION_XML).get(Books.class).size());

        // deletes the created book
        response = client.target(locationNewBook).request().delete();
        assertEquals(204, response.getStatus());

        // checks there is one less book
        assertEquals(initialSize, target.request(MediaType.APPLICATION_XML).get(Books.class).size());
    }
}
