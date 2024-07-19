package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestJsonReader {
    JsonReader reader;
    JsonReader reader2;
    Tracker tracker;

    @BeforeEach
    void runBefore() {
        reader = new JsonReader("data/testNothing.json");
        reader2 = new JsonReader("data/testTwoElements.json");
        tracker = new Tracker();
    }

    @Test
    void testRead() {
        try {
            assertEquals(reader.read(), tracker);
        } catch (IOException e) {
        }
    }

    @Test
    void testReader() {
        try {
            assertEquals(reader.read().getList().size(), 2);
        } catch (IOException e) {
        }
    }
}
