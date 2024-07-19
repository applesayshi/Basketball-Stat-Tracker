package model;

// represents a player with name, age, weight (in pounds), and height(cm)
// as well as a separate list for each of points, blocks, and assists
// (Terms are all basketball statistics)

import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;

// Creates a player with a name, age, weight, and height.
// Also creates lists of points, blocks and assists.
public class Player implements Writable {

    private String name;
    private int age;
    private int weight;
    private int height;
    private ArrayList<Integer> listOfPoints;
    private ArrayList<Integer> listOfBlocks;
    private ArrayList<Integer> listOfAssists;



    // EFFECTS: Constructs a player with given name, age, weight, and height,
    // as well as an empty list for all stats (points, blocks, assists)
    public Player(String name, int age, int weight, int height) {

        this.name = name;
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.listOfPoints = new ArrayList<>();
        this.listOfBlocks = new ArrayList<>();
        this.listOfAssists = new ArrayList<>();
    }

    // REQUIRES: newAge >= 0
    // MODIFIES: this
    // EFFECTS: Updates the player age with newAge
    public void updateAge(int newAge) {
        this.age = newAge;
    }

    // REQUIRES: newWeight >= 0
    // MODIFIES: this
    // EFFECTS: Updates the player weight with newWeight
    public void updateWeight(int newWeight) {
        this.weight = newWeight;
    }

    // REQUIRES: newHeight >= 0
    // MODIFIES: this
    // EFFECTS: Updates the player height with new height
    public void updateHeight(int newHeight) {
        this.height = newHeight;
    }

    // REQUIRES;
    // MODIFIES:
    // EFFECTS: gets the name of this player
    public String getName() {
        return this.name;
    }

    // REQUIRES;
    // MODIFIES:
    // EFFECTS: gets the age of this player
    public int getAge() {
        return this.age;
    }

    // REQUIRES;
    // MODIFIES:
    // EFFECTS: gets the age of this player
    public int getWeight() {
        return this.weight;
    }

    // REQUIRES;
    // MODIFIES:
    // EFFECTS: gets the age of this player
    public int getHeight() {
        return this.height;
    }

    // MODIFIES: this
    // EFFECTS: adds the given number of points, and returns the list
    public void addPoints(int numberOfPoints) {
        this.listOfPoints.add(numberOfPoints);
    }

    // MODIFIES: this
    // EFFECTS: adds the given number of blocks, and returns the list
    public ArrayList<Integer> addBlocks(int numberOfBlocks) {
        this.listOfBlocks.add(numberOfBlocks);
        return this.listOfBlocks;
    }


    // MODIFIES: this
    // EFFECTS: adds the given number of assists, and returns the list
    public ArrayList<Integer> addAssists(int numberOfAssists) {
        this.listOfAssists.add(numberOfAssists);
        return this.listOfAssists;
    }

    // REQUIRES: List cannot be empty
    // MODIFIES:
    // EFFECTS: gets the highest points the player has gotten in a game

    public int getHighestPoints() {

        int highest = 0;
        if (!this.listOfPoints.isEmpty()) {
            for (int points : this.listOfPoints) {
                if (points >= highest) {
                    highest = points;
                }
            }
            return highest;
        }
        return 0;
    }


    // REQUIRES: list cannot be empty
    // MODIFIES:
    // EFFECTS: gets the highest number of blocks a player has in a game

    public int getHighestBlocks() {

        int highest = 0;
        if (!this.listOfBlocks.isEmpty()) {
            for (int blocks : this.listOfBlocks) {
                if (blocks >= highest) {
                    highest = blocks;
                }
            }
            return highest;
        }
        return 0;
    }


    // REQUIRES: list cannot be empty
    // MODIFIES:
    // EFFECTS: gets the highest number of assists a player has in one game
    public int getHighestAssists() {

        int highest = 0;
        if (!this.listOfAssists.isEmpty()) {
            for (int assists : this.listOfAssists) {
                if (assists >= highest) {
                    highest = assists;
                }
            }
            return highest;
        }
        return 0;
    }

    // MODIFIES:
    // EFFECTS: gets the average whole number of points a player has over all games
    public int getAveragePoints() {
        int numberOfGames = this.listOfPoints.size();
        int sum = 0;
        for (int i : listOfPoints) {
            sum = i + sum;
        }
        if (numberOfGames == 0) {
            return 0;
        }
        return sum / numberOfGames;
    }

    // MODIFIES:
    // EFFECTS: gets the average whole number of points a player has over all games
    public int getAverageBlocks() {
        int numberOfGames = this.listOfBlocks.size();
        int sum = 0;
        for (int i : listOfBlocks) {
            sum = i + sum;
        }
        if (numberOfGames == 0) {
            return 0;
        }
        return sum / numberOfGames;
    }

    // MODIFIES:
    // EFFECTS: gets the average whole number of points a player has over all games
    public int getAverageAssists() {
        int numberOfGames = this.listOfAssists.size();
        int sum = 0;
        for (int i : listOfAssists) {
            sum = i + sum;
        }
        if (numberOfGames == 0) {
            return 0;
        }
        return sum / numberOfGames;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", getName());
        json.put("age", getAge());
        json.put("weight", getWeight());
        json.put("height", getHeight());
        json.put("points", getHighestPoints());
        json.put("points", getHighestPoints());
        json.put("blocks", getHighestBlocks());
        json.put("assists", getHighestAssists());
        json.put("all points", listOfPoints);
        json.put("all blocks", listOfBlocks);
        json.put("all assists", listOfAssists);
        return json;
    }

}
