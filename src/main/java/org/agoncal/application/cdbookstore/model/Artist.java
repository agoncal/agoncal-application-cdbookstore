package org.agoncal.application.cdbookstore.model;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

@MappedSuperclass
public class Artist
{

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

   @Override
   public String toString()
   {
      String result = getClass().getSimpleName() + " ";
      if (firstName != null && !firstName.trim().isEmpty())
         result += "firstName: " + firstName;
      if (lastName != null && !lastName.trim().isEmpty())
         result += ", lastName: " + lastName;
      if (bio != null && !bio.trim().isEmpty())
         result += ", bio: " + bio;
      if (dateOfBirth != null)
         result += ", dateOfBirth: " + dateOfBirth;
      if (age != null)
         result += ", age: " + age;
      return result;
   }

   @PostLoad
   @PostPersist
   @PostUpdate
   public String calculateAge()
   {
      throw new UnsupportedOperationException("Not supported yet.");
   }
}