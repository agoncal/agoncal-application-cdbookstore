package org.agoncal.application.topsells;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(name = TopItem.FIND_TOP_ITEMS, query = "SELECT b FROM Book b")
})
public class TopItem implements Serializable {

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

    @Version
    @Column(name = "version")
    protected int version;

    @Column(length = 200)
    @NotNull
    @Size(min = 1, max = 200)
    protected String title;

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

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    // ======================================
    // =   Methods hash, equals, toString   =
    // ======================================

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TopItem topItem = (TopItem) o;
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
                ", version=" + version +
                ", title='" + title + '\'' +
                '}';
    }
}