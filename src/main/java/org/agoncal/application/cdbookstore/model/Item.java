package org.agoncal.application.cdbookstore.model;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Item implements Serializable
{

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   @Column(name = "id", updatable = false, nullable = false)
   protected Long id;
   @Version
   @Column(name = "version")
   protected int version;

   @Column(length = 30)
   @NotNull
   @Size(min = 1, max = 30)
   protected String title;

   @Column(length = 3000)
   @Size(min = 1, max = 3000)
   protected String description;

   @Column
   @Min(1)
   protected Float unitCost;

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
      if (!(obj instanceof Item))
      {
         return false;
      }
      Item other = (Item) obj;
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
      return result;
   }
}