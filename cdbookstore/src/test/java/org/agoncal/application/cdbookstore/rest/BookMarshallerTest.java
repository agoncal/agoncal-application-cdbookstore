package org.agoncal.application.cdbookstore.rest;

import org.agoncal.application.cdbookstore.model.*;
import org.junit.Test;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class BookMarshallerTest {

    @Test
    public void should_marshall() throws JAXBException {
        Book book = new Book("1234", "H2G2", "Best Scifi book", 63.98F, 123, Language.ENGLISH);
        book.setCategory(new Category("IT"));
        book.setPublisher(new Publisher("Megadodo"));
        book.addAuthor(new Author("Douglas", "Adams"));
        book.addAuthor(new Author("John", "Cleese"));

        StringWriter writer = new StringWriter();
        JAXBContext context = JAXBContext.newInstance(Book.class);

        Marshaller m = context.createMarshaller();
        m.marshal(book, writer);
        System.out.println(writer.toString());
    }

    @Test
    public void should_buid_book_json() {
        JsonObject jsonBook = Json.createObjectBuilder().add("book", Json.createObjectBuilder()
                .add("isbn", "1234")
                .add("title", "H2G2")
                .add("unit-cost", "63.98")
                .add("nb-of-pages", "123")
                .add("description", "Best Scifi book")
                .add("language", "ENGLISH")
                .add("category", Json.createObjectBuilder()
                        .add("name", "IT")
                )
                .add("publisher", Json.createObjectBuilder()
                        .add("name", "Megadodo")
                )
                .add("authors", Json.createArrayBuilder()
                        .add(Json.createObjectBuilder()
                                .add("first-name", "Douglas")
                                .add("last-name", "Adams"))
                        .add(Json.createObjectBuilder()
                                .add("first-name", "John")
                                .add("last-name", "Cleese")
                        )
                )
        ).build();
        System.out.println(jsonBook);
    }

    @Test
    public void should_process_books() throws IOException {
        List<Long> bookIds = new ArrayList<>();

        InputStream stream = Files.newInputStream(Paths.get("src/test/resources/books.json"));
        try (JsonReader reader = Json.createReader(stream)) {
            JsonArray array = reader.readArray();
            for (int i = 0; i < array.size(); i++) {
                bookIds.add((long) array.getJsonObject(i).getInt("id"));
                System.out.println(array.getJsonObject(i).getInt("id"));
                System.out.println(array.getJsonObject(i).getString("title"));
            }
        }
        System.out.println(bookIds);
        assertTrue(bookIds.size() > 0);
    }
}
