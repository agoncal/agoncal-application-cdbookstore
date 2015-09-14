package org.agoncal.application.cdbookstore.util;

import javax.faces.context.FacesContext;
import javax.enterprise.inject.Produces;
import javax.enterprise.context.RequestScoped;
import javax.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.Logger;
public class ResourcProducer {

	@Produces
	@RequestScoped
	private FacesContext produceFacesContext() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Produces
	@RequestScoped
	private HttpServletResponse produceHttpServletResponse() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Produces
	private Logger produceLogger() {
		throw new UnsupportedOperationException("Not supported yet.");
	}
}