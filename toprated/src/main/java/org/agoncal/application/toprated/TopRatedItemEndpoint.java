package org.agoncal.application.toprated;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Random;
import java.util.logging.Logger;

@Path("/topitems")
@Transactional
public class TopRatedItemEndpoint {

    // ======================================
    // =          Injection Points          =
    // ======================================

    @Inject
    private EntityManager em;

    @Inject
    private Logger logger;

    // ======================================
    // =          Business methods          =
    // ======================================

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public RatedItems getTopBooks() {
        RatedItems results = new RatedItems();

        int min = em.createQuery("select min (i.id) from RatedItem i", Long.class).getSingleResult().intValue();
        int max = em.createQuery("select max (i.id) from RatedItem i", Long.class).getSingleResult().intValue();

        while (results.size() < 5) {
            long id = new Random().nextInt((max - min) + 1) + min;
            RatedItem item = em.find(RatedItem.class, id);
            if (item != null)
                results.add(item);
        }

        logger.info("Top Items are " + results);

        return results;
    }
}
