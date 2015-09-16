package org.agoncal.application.cdbookstore.view.shopping;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Named
@RequestScoped
@Transactional
public class CatalogBean
{

   @Inject
   private FacesContext facesContext;

   @PersistenceContext(unitName = "applicationCDBookStorePU")
   private EntityManager em;

}