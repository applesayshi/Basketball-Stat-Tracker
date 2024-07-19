package persistence;

import model.Player;
import model.Tracker;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

// Represents a reader that reads workroom from JSON data stored in file
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads workroom from file and returns it;
    // throws IOException if an error occurs reading data from file
    public Tracker read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseTracker(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }
        return contentBuilder.toString();
    }

    // EFFECTS: parses workroom from JSON object and returns it
    private Tracker parseTracker(JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("Players");
        Tracker tracker = new Tracker();
        createTracker(tracker, jsonArray);
        return tracker;
    }

    // MODIFIES: wrs
    // EFFECTS: parses thingies from JSON object and adds them to workroom
    private void createTracker(Tracker tracker, JSONArray jsonArray) {

        for (Object json : jsonArray) {
            JSONObject player = (JSONObject) json;
            String name = player.getString("Player");
            JSONObject playerStats = player.getJSONObject("stats");
            addPlayer(tracker, playerStats, name);
        }
    }


    // MODIFIES: wr
    // EFFECTS: creates the points and stats from JSON object and adds them to player
    private void addPlayer(Tracker tracker, JSONObject jsonObject, String name) {


        int age = jsonObject.getInt("age");
        int weight = jsonObject.getInt("weight");
        int height = jsonObject.getInt("height");

        Player player = new Player(name, age, weight, height);
        tracker.addPlayerToList(player);
    }
}
