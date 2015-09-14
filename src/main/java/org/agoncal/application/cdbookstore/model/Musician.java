package org.agoncal.application.cdbookstore.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

@Entity
public class Musician implements Serializable
{

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   @Column(name = "id", updatable = false, nullable = false)
   private Long id;
   @Version
   @Column(name = "version")
   private int version;

   @Column(length = 50)
   @NotNull
   @Size(min = 2, max = 50)
   private String firstName;

   @Column(length = 50)
   @NotNull
   @Size(min = 2, max = 50)
   private String lastName;

   @Column(length = 5000)
   @Size(max = 5000)
   private String bio;

   @Column
   @Temporal(TemporalType.DATE)
   @Past
   private Date dateOfBirth;

   @Transient
   private Integer age;

   @Column
   private String preferredInstrument;

   @ManyToMany
   private Set<CD> cds = new HashSet<CD>();

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
      if (!(obj instanceof Musician))
      {
         return false;
      }
      Musician other = (Musician) obj;
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

   public String getFirstName()
   {
      return firstName;
   }

   public void setFirstName(String firstName)
   {
      this.firstName = firstName;
   }

   public String getLastName()
   {
      return lastName;
   }

   public void setLastName(String lastName)
   {
      this.lastName = lastName;
   }

   public String getBio()
   {
      return bio;
   }

   public void setBio(String bio)
   {
      this.bio = bio;
   }

   public Date getDateOfBirth()
   {
      return dateOfBirth;
   }

   public void setDateOfBirth(Date dateOfBirth)
   {
      this.dateOfBirth = dateOfBirth;
   }

   public Integer getAge()
   {
      return age;
   }

   public void setAge(Integer age)
   {
      this.age = age;
   }

   public String getPreferredInstrument()
   {
      return preferredInstrument;
   }

   public void setPreferredInstrument(String preferredInstrument)
   {
      this.preferredInstrument = preferredInstrument;
   }

   @Override
   public String toString()
   {
      String result = getClass().getSimpleName() + " ";
      if (id != null)
         result += "id: " + id;
      result += ", version: " + version;
      if (firstName != null && !firstName.trim().isEmpty())
         result += ", firstName: " + firstName;
      if (lastName != null && !lastName.trim().isEmpty())
         result += ", lastName: " + lastName;
      if (bio != null && !bio.trim().isEmpty())
         result += ", bio: " + bio;
      if (dateOfBirth != null)
         result += ", dateOfBirth: " + dateOfBirth;
      if (age != null)
         result += ", age: " + age;
      if (preferredInstrument != null
               && !preferredInstrument.trim().isEmpty())
         result += ", preferredInstrument: " + preferredInstrument;
      return result;
   }

   public Set<CD> getCds()
   {
      return this.cds;
   }

   public void setCds(final Set<CD> cds)
   {
      this.cds = cds;
   }
}