package org.agoncal.application.toprated;

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

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonReader;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.StringReader;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(Arquillian.class)
@RunAsClient
public class TopRatedItemEndpointTest {

    @ArquillianResource
    private URI baseURL;

    @Deployment(testable = false)
    public static WebArchive createDeployment() {
        return ShrinkWrap
                .create(WebArchive.class)
                .addClass(RatedItem.class)
                .addClass(RatedItems.class)
                .addClass(ResourceProducer.class)
                .addClass(RestApplication.class)
                .addClass(TopRatedItemEndpoint.class)
                .addAsResource("META-INF/persistence-test.xml", "META-INF/persistence.xml")
                .addAsResource("import_h2.sql", "import_h2.sql")
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Test
    public void should_be_deployed() {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(baseURL).path("toprateditems");
        assertEquals(Response.Status.OK.getStatusCode(), target.request(MediaType.APPLICATION_JSON).get().getStatus());
    }

    @Test @Ignore
    public void should_check_items() {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(baseURL).path("toprateditems");
        Response response = target.request(MediaType.APPLICATION_JSON).get();
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());

        String body = response.readEntity(String.class);
        System.out.println("############################");
        System.out.println(body);

        List<Long> topRateditemIds = new ArrayList<>();
        try (JsonReader reader = Json.createReader(new StringReader(body))) {
            JsonArray array = reader.readArray();
            for (int i = 0; i < array.size(); i++) {
                topRateditemIds.add((long) array.getJsonObject(i).getInt("id"));
            }
        }
        assertTrue(topRateditemIds.size() > 0);
    }
}
