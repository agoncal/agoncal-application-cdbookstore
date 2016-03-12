package org.agoncal.application.topsells;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Antonio Goncalves
 *         http://www.antoniogoncalves.org
 *         --
 */
@XmlRootElement
@XmlSeeAlso(TopItem.class)
public class TopItems extends ArrayList<TopItem> {

    // ======================================
    // =            Constructors            =
    // ======================================

    public TopItems() {
        super();
    }

    public TopItems(Collection<? extends TopItem> c) {
        super(c);
    }

    // ======================================
    // =          Getters & Setters         =
    // ======================================

    @XmlElement(name = "topItem")
    public List<TopItem> getTopItems() {
        return this;
    }
}