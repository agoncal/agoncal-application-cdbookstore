package org.agoncal.application.toprated;

import org.junit.Test;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class TopRatedProcessorTest {

    @Test
    public void should_process_toprated() throws IOException {
        List<Long> topRateditemIds = new ArrayList<>();

        InputStream stream = Files.newInputStream(Paths.get("src/test/resources/toprated.json"));
        try (JsonReader reader = Json.createReader(stream)) {
            JsonArray array = reader.readArray();
            for (int i = 0; i < array.size(); i++) {
                topRateditemIds.add((long) array.getJsonObject(i).getInt("id"));
            }
        }
        System.out.println(topRateditemIds);
        assertTrue(topRateditemIds.size() > 0);
    }
}
