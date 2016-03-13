package org.agoncal.application.toprated;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "rated_item")
@NamedQueries({
        @NamedQuery(name = RatedItem.FIND_TOP_ITEMS, query = "SELECT i FROM RatedItem i WHERE i.rank = 5")
})
public class RatedItem implements Serializable {

    // ======================================
    // =             Constants              =
    // ======================================

    public static final String FIND_TOP_ITEMS = "TopItem.findTopRated";

    // ======================================
    // =             Attributes             =
    // ======================================

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    protected Long id;

    @Column(length = 200)
    @NotNull
    @Size(min = 1, max = 200)
    protected String title;

    protected Integer rank;

    // ======================================
    // =        Getters and Setters         =
    // ======================================

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    // ======================================
    // =   Methods hash, equals, toString   =
    // ======================================

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RatedItem topItem = (RatedItem) o;
        return Objects.equals(id, topItem.id) &&
                Objects.equals(title, topItem.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title);
    }

    @Override
    public String toString() {
        return "TopItem{" +
                "id=" + id +
                ", rank=" + rank +
                ", title='" + title + '\'' +
                '}';
    }
}