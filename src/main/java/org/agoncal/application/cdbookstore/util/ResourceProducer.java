package org.agoncal.application.cdbookstore.util;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Logger;

public class ResourceProducer
{

   @Produces
   @RequestScoped
   private FacesContext produceFacesContext()
   {
      throw new UnsupportedOperationException("Not supported yet.");
   }

   @Produces
   @RequestScoped
   private HttpServletResponse produceHttpServletResponse()
   {
      throw new UnsupportedOperationException("Not supported yet.");
   }

   @Produces
   private Logger produceLogger()
   {
      throw new UnsupportedOperationException("Not supported yet.");
   }
}