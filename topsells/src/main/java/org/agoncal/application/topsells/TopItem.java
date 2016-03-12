package org.agoncal.application.topsells;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@NamedQueries({
         @NamedQuery(name = TopItem.FIND_TOP_ITEMS, query = "SELECT b FROM Book b")
})
public class TopItem implements Serializable
{

   public static final String FIND_TOP_ITEMS = "TopItem.findTopRated";

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   @Column(name = "id", updatable = false, nullable = false)
   protected Long id;

   private String isbn;

   public Long getId()
   {
      return this.id;
   }

   public void setId(final Long id)
   {
      this.id = id;
   }

   public String getIsbn()
   {
      return isbn;
   }

   public void setIsbn(String isbn)
   {
      this.isbn = isbn;
   }

   @Override
   public boolean equals(Object o)
   {
      if (this == o)
         return true;
      if (o == null || getClass() != o.getClass())
         return false;
      TopItem book = (TopItem) o;
      return Objects.equals(isbn, book.isbn);
   }

   @Override
   public int hashCode()
   {
      return Objects.hash(isbn);
   }

   @Override
   public String toString()
   {
      return "Book{" +
               "id=" + id +
               ", isbn='" + isbn + '\'' +
               '}';
   }
}