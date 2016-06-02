package org.agoncal.application.cdbookstore.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Antonio Goncalves
 *         http://www.antoniogoncalves.org
 *         --
 */

@Entity
@XmlRootElement
@DiscriminatorValue("C")
public class CD extends Item {

    // ======================================
    // =             Attributes             =
    // ======================================

    @Column(name = "nb_of_discs")
    private Integer nbOfDiscs;

    @ManyToOne
    private Label label;

    @ManyToMany
    private Set<Musician> musicians = new HashSet<>();

    @ManyToOne
    private Genre genre;

    // ======================================
    // =        Getters and Setters         =
    // ======================================

    public Long getId() {
        return this.id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public int getVersion() {
        return this.version;
    }

    public void setVersion(final int version) {
        this.version = version;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(Float unitCost) {
        this.unitCost = unitCost;
    }

    public Integer getNbOfDiscs() {
        return nbOfDiscs;
    }

    public void setNbOfDiscs(Integer nbOfDiscs) {
        this.nbOfDiscs = nbOfDiscs;
    }

    public Label getLabel() {
        return this.label;
    }

    public void setLabel(final Label label) {
        this.label = label;
    }

    public Set<Musician> getMusicians() {
        return this.musicians;
    }

    public void setMusicians(final Set<Musician> musicians) {
        this.musicians = musicians;
    }

    public Genre getGenre() {
        return this.genre;
    }

    public void setGenre(final Genre genre) {
        this.genre = genre;
    }

    // ======================================
    // =   Methods hash, equals, toString   =
    // ======================================

    @Override
    public String toString() {
        String result = getClass().getSimpleName() + " ";
        if (id != null)
            result += "id: " + id;
        result += ", version: " + version;
        if (title != null && !title.trim().isEmpty())
            result += ", title: " + title;
        if (description != null && !description.trim().isEmpty())
            result += ", description: " + description;
        if (unitCost != null)
            result += ", unitCost: " + unitCost;
        if (nbOfDiscs != null)
            result += ", nbOfDiscs: " + nbOfDiscs;
        return result;
    }
}