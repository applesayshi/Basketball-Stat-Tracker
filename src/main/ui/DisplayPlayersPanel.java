package ui;

import model.Player;
import model.Tracker;

import javax.swing.*;
import java.awt.*;

// Displays the players that are in the list of the tracker
public class DisplayPlayersPanel {

    private final JFrame frame = new JFrame();
    private final JPanel panel = new JPanel();
    private int width = 100;
    private int height = 100;
    private final Tracker tracker;

    // constructs a panel for displaying the players after the button is pressed in starter panel
    public DisplayPlayersPanel(Tracker tracker) {
        this.tracker = tracker;
        createStarterPanel();
        createFrame();
        putPlayersOnScreen();
    }

    // EFFECTS: creates the starter panel for the overall GUI, and adds button to panel
    private void createStarterPanel() {
        panel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
        panel.setSize(width, height);
        panel.setLayout(new GridLayout(0, 1));
    }

    // MODIFIES: frame
    // EFFECTS: creates a frame for the GUI and the panel
    private void createFrame() {
        frame.add(panel, BorderLayout.CENTER);
        frame.setTitle("Player Display");
        frame.pack();
        frame.setVisible(true);
    }

    // MODIFIES: panel
    // EFFECTS: creates labels for the overall GUI, and adds label to panel
    private void createLabels() {
        JLabel screenTitle = new JLabel("Players");
        panel.add(screenTitle);
    }

    // EFFECTS: creates labels for each player in the list of the tracker
    //          and puts it into the panel
    public void putPlayersOnScreen() {
        panel.removeAll();
        createLabels();
        for (Player p : this.tracker.getList()) {
            JLabel playerNameLabel = new JLabel(p.getName());
            JLabel playerAgeLabel = new JLabel(Integer.toString(p.getAge()));
            JLabel playerWeightLabel = new JLabel(Integer.toString(p.getWeight()));
            JLabel playerHeightLabel = new JLabel(Integer.toString(p.getHeight()));
            JLabel bars = new JLabel("_____________");
            panel.add(playerNameLabel);
            panel.add(playerAgeLabel);
            panel.add(playerWeightLabel);
            panel.add(playerHeightLabel);
            panel.add(bars);
        }
    }

    // creates this classes own visibility method
    public void makeOwnSetVisible(boolean b) {
        frame.setVisible(b);
        panel.setVisible(b);
    }
}
