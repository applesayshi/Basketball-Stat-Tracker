package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TestPlayer {

    ArrayList<Integer> listOfPoints;
    ArrayList<Integer> listOfBlocks;
    ArrayList<Integer> listOfAssists;
    Player joshPlayer;
    Player bernardPlayer;
    Player sanPlayer;

    @BeforeEach
    void runBefore() {
        listOfAssists = new ArrayList<>();
        listOfBlocks = new ArrayList<>();
        listOfPoints = new ArrayList<>();
        joshPlayer = new Player("Josh", 19, 190, 175);
        bernardPlayer = new Player("Bernard", 18, 130, 130);
        sanPlayer = new Player("San", 4, 120, 120);
    }

    @Test
    void updateAgeTest() {
        assertEquals(joshPlayer.getAge(), 19);
        joshPlayer.updateAge(20);
        assertEquals(joshPlayer.getAge(), 20);

    }

    @Test
    void updateWeightTest() {
        assertEquals(joshPlayer.getWeight(), 190);
        joshPlayer.updateWeight(500);
        assertEquals(joshPlayer.getWeight(), 500);
    }

    @Test
    void updateHeightTest() {

        assertEquals(joshPlayer.getHeight(), 175);
        joshPlayer.updateHeight(160);
        assertEquals(joshPlayer.getHeight(), 160);
    }


    @Test
    void getNameTest() {
        assertEquals(joshPlayer.getName(), "Josh");
        assertEquals(bernardPlayer.getName(), "Bernard");
        assertEquals(sanPlayer.getName(), "San");

    }


    @Test
    void getAgeTest() {
        assertEquals(joshPlayer.getAge(), 19);
        assertEquals(bernardPlayer.getAge(), 18);
        assertEquals(sanPlayer.getAge(), 4);
    }


    @Test
    void getHighestPointsTest() {
        joshPlayer.addPoints(20);
        joshPlayer.addPoints(25);
        assertEquals(joshPlayer.getHighestPoints(), 25);
        joshPlayer.addPoints(80);
        joshPlayer.addPoints(80);
        assertEquals(joshPlayer.getHighestPoints(), 80);

    }

    @Test
    void getHighestBlocksTest() {
        bernardPlayer.addBlocks(3);
        bernardPlayer.addBlocks(6);
        assertEquals(bernardPlayer.getHighestBlocks(), 6);
        bernardPlayer.addBlocks(9);
        bernardPlayer.addBlocks(9);
        assertEquals(bernardPlayer.getHighestBlocks(), 9);

    }

    @Test
    void getHighestAssistsTest() {
        sanPlayer.addAssists(3);
        sanPlayer.addAssists(6);
        assertEquals(sanPlayer.getHighestAssists(), 6);
        sanPlayer.addAssists(9);
        sanPlayer.addAssists(9);
        assertEquals (sanPlayer.getHighestAssists(), 9);
    }


    @Test
    void getAveragePoints() {
        joshPlayer.addPoints(20);
        joshPlayer.addPoints(25);
        joshPlayer.addPoints(80);
        joshPlayer.addPoints(80);
        assertEquals(51, joshPlayer.getAveragePoints());

    }

    @Test
    void getAverageBlocks() {
        bernardPlayer.addBlocks(3);
        bernardPlayer.addBlocks(6);
        bernardPlayer.addBlocks(9);
        bernardPlayer.addBlocks(9);
        assertEquals(6, bernardPlayer.getAverageBlocks());
    }

    @Test
    void getAverageAssists() {
        sanPlayer.addAssists(3);
        sanPlayer.addAssists(6);
        sanPlayer.addAssists(9);
        sanPlayer.addAssists(9);
        assertEquals(6, sanPlayer.getAverageAssists());

    }


}