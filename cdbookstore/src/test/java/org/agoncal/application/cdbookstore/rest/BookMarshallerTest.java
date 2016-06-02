package org.agoncal.application.cdbookstore.rest;

import org.agoncal.application.cdbookstore.model.*;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

public class BookMarshallerTest {

    @Test
    public void should_marshall() throws JAXBException {
        Book book = new Book("1234", "H2G2", "Best Scifi book", 63.98F, 123, Language.ENGLISH);
        book.setCategory(new Category("IT"));
        book.setPublisher(new Publisher("IT"));

        StringWriter writer = new StringWriter();
        JAXBContext context = JAXBContext.newInstance(Book.class);

        Marshaller m = context.createMarshaller();
        m.marshal(book, writer);
        System.out.println(writer.toString());
    }
}
