package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.Objects;

// Creates a tracker, which is a list of players.
public class Tracker implements Writable {

    private ArrayList<Player> listOfPlayers;
    private final EventLog eventLog = EventLog.getInstance();

    // EFFECTS: Constructs a tracker with an empty list of players
    public Tracker() {
        this.listOfPlayers = new ArrayList<>();
    }

    // MODIFIES: this
    // EFFECTS: adds a given player to the list of players to keep track
    public void addPlayerToList(Player player) {
        this.listOfPlayers.add(player);
        eventLog.logEvent(new Event("Added " + player.getName() + " to the tracker"));
    }


    // REQUIRES: List cannot be empty
    // MODIFIES: this
    // EFFECTS: removes a given player from the list of players
    public void removePlayerFromList(Player player) {
        this.listOfPlayers.remove(player);
        eventLog.logEvent(new Event("Removed " + player.getName() + " from the tracker"));
    }

    // EFFECTS: returns the list of players
    public ArrayList<Player> getList() {
        return this.listOfPlayers;
    }

    // REQUIRES:
    // MODIFIES:
    // EFFECTS: Retrieves player with given name from the listOfPlayers.
    //          If same name, then return the first person of that name in the list
    public Player getPlayer(String name) {
        for (Player player: listOfPlayers) {
            if (Objects.equals(player.getName(), name)) {
                return player;
            }
        }
        return null;
    }


    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("Players", players());
        return json;
    }

    public JSONArray players() {
        JSONArray jsonA = new JSONArray();

        for (Player p : listOfPlayers) {
            JSONObject jsonPlayer = new JSONObject();
            jsonPlayer.put("Player", p.getName());
            jsonPlayer.put("stats", p.toJson());
            jsonA.put(jsonPlayer);
        }
        return jsonA;
    }
}
