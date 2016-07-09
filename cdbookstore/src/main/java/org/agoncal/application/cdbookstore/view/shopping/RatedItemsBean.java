package org.agoncal.application.cdbookstore.view.shopping;

import org.agoncal.application.cdbookstore.model.Item;
import org.agoncal.application.cdbookstore.util.Auditable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonReader;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.StringReader;
import java.util.*;
import java.util.logging.Logger;

@Named
@RequestScoped
@Transactional
public class RatedItemsBean {

    // ======================================
    // =          Injection Points          =
    // ======================================

    @Inject
    private FacesContext facesContext;

    @Inject
    private Logger logger;

    @Inject
    private EntityManager em;

    // ======================================
    // =             Attributes             =
    // ======================================

    List<Item> topRatedItems;
    Set<Item> randomItems = new HashSet<>();

    // ======================================
    // =         Lifecycle methods          =
    // ======================================

    @PostConstruct
    private void init() {
        doFindTopRated();
        doFindRandomThree();

    }

    // ======================================
    // =          Business methods          =
    // ======================================

    @Auditable
    private void doFindRandomThree() {
        int min = em.createQuery("select min (i.id) from Item i", Long.class).getSingleResult().intValue();
        int max = em.createQuery("select max (i.id) from Item i", Long.class).getSingleResult().intValue();

        while (randomItems.size() < 3) {
            long id = new Random().nextInt((max - min) + 1) + min;
            Item item = em.find(Item.class, id);
            if (item != null)
                randomItems.add(item);
        }
    }

    @Auditable
    private void doFindTopRated() {

        Response response;

        // Tries on port 8080 if not 8085
        try {
            response = ClientBuilder.newClient().target("http://localhost:8080/applicationToprated/toprateditems").request(MediaType.APPLICATION_JSON).get();
        } catch (Exception e) {
            response = ClientBuilder.newClient().target("http://localhost:8085/applicationToprated/toprateditems").request(MediaType.APPLICATION_JSON).get();
        }

        if (response.getStatus() != Response.Status.OK.getStatusCode())
            return;

        String body = response.readEntity(String.class);

        List<Long> topRateditemIds = new ArrayList<>();
        try (JsonReader reader = Json.createReader(new StringReader(body))) {
            JsonArray array = reader.readArray();
            for (int i = 0; i < array.size(); i++) {
                topRateditemIds.add((long) array.getJsonObject(i).getInt("id"));
            }
        }

        if (!topRateditemIds.isEmpty()) {
            logger.fine("Top rated books ids " + topRateditemIds);
            TypedQuery<Item> query = em.createNamedQuery(Item.FIND_TOP_RATED, Item.class);
            query.setParameter("ids", topRateditemIds);
            topRatedItems = query.getResultList();
            logger.fine("Number of top rated items found " + topRatedItems.size());
        }

    }

    // ======================================
    // =        Getters and Setters         =
    // ======================================

    public List<Item> getTopRatedItems() {
        return topRatedItems;
    }

    public void setTopRatedItems(List<Item> topRatedItems) {
        this.topRatedItems = topRatedItems;
    }

    public List<Item> getRandomItems() {
        return new ArrayList<>(randomItems);
    }
}