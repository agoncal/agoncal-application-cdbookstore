package org.agoncal.application.cdbookstore.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class CD implements Serializable
{

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   @Column(name = "id", updatable = false, nullable = false)
   private Long id;
   @Version
   @Column(name = "version")
   private int version;

   @Column(length = 30)
   @NotNull
   @Size(min = 1, max = 30)
   private String title;

   @Column(length = 3000)
   @Size(min = 1, max = 3000)
   private String description;

   @Column
   @Min(1)
   private Float unitCost;

   @Column
   private Float totalDuration;

   @ManyToOne
   private Label label;

   @ManyToMany
   private Set<Musician> musicians = new HashSet<Musician>();

   @ManyToOne
   private Genre genre;

   public Long getId()
   {
      return this.id;
   }

   public void setId(final Long id)
   {
      this.id = id;
   }

   public int getVersion()
   {
      return this.version;
   }

   public void setVersion(final int version)
   {
      this.version = version;
   }

   @Override
   public boolean equals(Object obj)
   {
      if (this == obj)
      {
         return true;
      }
      if (!(obj instanceof CD))
      {
         return false;
      }
      CD other = (CD) obj;
      if (id != null)
      {
         if (!id.equals(other.id))
         {
            return false;
         }
      }
      return true;
   }

   @Override
   public int hashCode()
   {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((id == null) ? 0 : id.hashCode());
      return result;
   }

   public String getTitle()
   {
      return title;
   }

   public void setTitle(String title)
   {
      this.title = title;
   }

   public String getDescription()
   {
      return description;
   }

   public void setDescription(String description)
   {
      this.description = description;
   }

   public Float getUnitCost()
   {
      return unitCost;
   }

   public void setUnitCost(Float unitCost)
   {
      this.unitCost = unitCost;
   }

   public Float getTotalDuration()
   {
      return totalDuration;
   }

   public void setTotalDuration(Float totalDuration)
   {
      this.totalDuration = totalDuration;
   }

   @Override
   public String toString()
   {
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
      if (totalDuration != null)
         result += ", totalDuration: " + totalDuration;
      return result;
   }

   public Label getLabel()
   {
      return this.label;
   }

   public void setLabel(final Label label)
   {
      this.label = label;
   }

   public Set<Musician> getMusicians()
   {
      return this.musicians;
   }

   public void setMusicians(final Set<Musician> musicians)
   {
      this.musicians = musicians;
   }

   public Genre getGenre()
   {
      return this.genre;
   }

   public void setGenre(final Genre genre)
   {
      this.genre = genre;
   }
}