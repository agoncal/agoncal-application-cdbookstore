package org.agoncal.application.topsells;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
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

@RunWith(Arquillian.class)
@RunAsClient
public class TopItemEndpointTest {

    @ArquillianResource
    private URI baseURL;

    @Deployment(testable = false)
    public static WebArchive createDeployment() {
        return ShrinkWrap
                .create(WebArchive.class)
                .addClass(RestApplication.class)
                .addClass(ResourceProducer.class)
                .addClass(TopItem.class)
                .addClass(TopItemEndpoint.class)
                .addAsResource("META-INF/persistence-test.xml", "META-INF/persistence.xml")
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Test
    public void should_be_deployed() {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(baseURL).path("rest").path("topitems");
        assertEquals(Response.Status.OK.getStatusCode(), target.request(MediaType.APPLICATION_XML).get().getStatus());
    }

    @Test
    public void shouldCRUDBooks() throws IOException {

        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(baseURL).path("rest").path("topitems");
        int initialSize = target.request(MediaType.APPLICATION_XML).get(TopItems.class).size();

        // creates a book
        TopItem topItem = new TopItem();
        Response response = target.request().post(Entity.entity(topItem, MediaType.APPLICATION_XML));
        assertEquals(201, response.getStatus());
        URI locationNewBook = response.getLocation();

        // checks there is one more book
        assertEquals(initialSize + 1, target.request(MediaType.APPLICATION_XML).get(TopItems.class).size());

        // deletes the created book
        response = client.target(locationNewBook).request().delete();
        assertEquals(204, response.getStatus());

        // checks there is one less book
        assertEquals(initialSize, target.request(MediaType.APPLICATION_XML).get(TopItems.class).size());
    }
}
