package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TestTracker {

    Tracker tracker;
    Player joshPlayer;
    Player bernardPlayer;
    Player sanPlayer;


    @BeforeEach
    void runBefore() {
        tracker = new Tracker();
        joshPlayer = new Player("Josh", 19, 190, 175);
        bernardPlayer = new Player("Bernard", 18, 130, 130);
        sanPlayer = new Player("San", 4, 120, 120);


    }

    @Test
    void addPlayerToListTest() {
        assertEquals(tracker.getList().size(), 0);
        tracker.addPlayerToList(joshPlayer);
        assertEquals(tracker.getPlayer("Josh"), joshPlayer);
        assertEquals(tracker.getList().size(), 1);
    }

    @Test
    void removePlayerToListTest() {
        tracker.addPlayerToList(joshPlayer);
        tracker.addPlayerToList(bernardPlayer);
        assertEquals(tracker.getList().size(), 2);
        tracker.removePlayerFromList(joshPlayer);
        assertNull(tracker.getPlayer("Josh"));
        assertEquals(tracker.getList().size(), 1);
    }

    @Test
    void getPlayerTest() {
        tracker.addPlayerToList(joshPlayer);
        assertEquals(tracker.getPlayer("Josh"), joshPlayer);
    }

    @Test
    void getListTest() {
        assertEquals(tracker.getList().size(), 0);
        tracker.addPlayerToList(joshPlayer);
        assertEquals(tracker.getList().size(), 1);
        tracker.addPlayerToList(bernardPlayer);
        assertEquals(tracker.getList().size(), 2);
        tracker.addPlayerToList(sanPlayer);
        assertEquals(tracker.getList().size(), 3);
    }
}
