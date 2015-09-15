package org.agoncal.application.cdbookstore.rest;

import static org.junit.Assert.assertEquals;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.agoncal.application.cdbookstore.model.*;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
@RunAsClient
public class CDEndpointTest
{

   @ArquillianResource
   private URI baseURL;

   @Deployment(testable = false)
   public static WebArchive createDeployment()
   {
      return ShrinkWrap
               .create(WebArchive.class)
               .addClass(RestApplication.class)
               .addClass(CDEndpoint.class)
               .addClass(CD.class)
               .addClass(Item.class)
               .addClass(Genre.class)
               .addClass(Label.class)
               .addClass(Artist.class)
               .addClass(Musician.class)
               .addAsResource("META-INF/persistence-test.xml", "META-INF/persistence.xml")
               .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
   }

   @Test
   public void should_be_deployed()
   {
      Client client = ClientBuilder.newClient();
      WebTarget target = client.target(baseURL).path("rest").path("cds");
      assertEquals(Response.Status.OK.getStatusCode(), target.request(MediaType.APPLICATION_XML).get().getStatus());
   }
}
