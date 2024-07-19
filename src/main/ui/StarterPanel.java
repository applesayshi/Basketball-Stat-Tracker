package ui;

import model.EventLog;
import model.Event;
import model.Player;
import model.Tracker;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

// Creates the starter panel GUI for the basketball stat tracker
public class StarterPanel extends JFrame {

    private final JFrame frame = new JFrame();
    private final JPanel panel = new JPanel();
    private int width = 100;
    private int height = 100;
    private JButton displayPlayersButton;
    private JButton addPlayersButton;
    private JButton removePlayersButton;
    private JButton saveButton;
    private JButton loadButton;
    private JButton quitButton;

    private final Tracker tracker;
    private final AddPlayersPanel addPanel;
    private final DisplayPlayersPanel displayPanel;
    private RemovePlayerPanel removePanel;

    private static final String JSON_STORE = "./data/workroom.json";
    private final JsonWriter jsonWriter;
    private final JsonReader jsonReader;


    // Constructor for GUI
    public StarterPanel() {

        createStarterPanel();
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        tracker = new Tracker();

        createLabels();
        createDisplayPlayersButtons();
        createAddPlayersButtons();
        createRemovePlayersButtons();
        createSaveButtons();
        createLoadButtons();
        createQuitButton();
        createFrame();

        addPanel = new AddPlayersPanel(tracker);
        addPanel.makeOwnSetVisible(false);

        displayPanel = new DisplayPlayersPanel(tracker);
        displayPanel.makeOwnSetVisible(false);

        removePanel = new RemovePlayerPanel(tracker);
        removePanel.makeOwnSetVisible(false);

        pictureIcon();

    }

    // EFFECTS: creates the starter panel for the overall GUI, and adds button to panel
    private void createStarterPanel() {
        panel.setBorder(BorderFactory.createBevelBorder(100, Color.red, Color.green, Color.blue, Color.yellow));
        panel.setSize(width, height);
        panel.setLayout(new GridLayout(0, 1));
    }



    // MODIFIES: panel
    // EFFECTS: creates buttons for the overall GUI, and adds button to panel
    private void createAddPlayersButtons() {
        addPlayersButton = new JButton("Add Players");
        addPlayersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addPanel.makeOwnSetVisible(true);
            }
        });
        panel.add(addPlayersButton);
    }

    // MODIFIES: panel
    // EFFECTS: creates buttons for the overall GUI, and adds button to panel
    private void createRemovePlayersButtons() {
        removePlayersButton = new JButton("Remove Players");
        removePlayersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removePanel.makeOwnSetVisible(true);
            }
        });
        panel.add(removePlayersButton);
    }

    // MODIFIES: panel
    // EFFECTS: creates buttons for the overall GUI, and adds button to panel
    private void createSaveButtons() {
        saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveTracker();
            }
        });
        panel.add(saveButton);
    }

    // EFFECTS: Saves the tracker to memory
    public void saveTracker() {
        try {
            jsonWriter.open();
            jsonWriter.write(tracker);
            jsonWriter.close();
            System.out.println("Saved current tracker to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // MODIFIES: panel
    // EFFECTS: creates buttons for the overall GUI, and adds button to panel
    private void createDisplayPlayersButtons() {
        displayPlayersButton = new JButton("Display Players");
        displayPlayersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayPanel.putPlayersOnScreen();
                displayPanel.makeOwnSetVisible(true);
            }
        });
        panel.add(displayPlayersButton);
    }

    // MODIFIES: this
    // EFFECTS: loads workroom from file
    public void loadTracker() {
        try {
            for (Player p : jsonReader.read().getList()) {
                tracker.addPlayerToList(p);
            }
            System.out.println("Loaded current tracker from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }

    // MODIFIES: panel
    // EFFECTS: creates buttons for the overall GUI, and adds button to panel
    private void createLoadButtons() {
        loadButton = new JButton("Load");
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadTracker();
            }
        });
        panel.add(loadButton);
    }

    // EFFECTS: creates a quit button for the panel, and adds it to the frame
    private void createQuitButton() {
        quitButton = new JButton("Quit");
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                printLoggers(EventLog.getInstance());
                System.exit(0);
            }
        });
        panel.add(quitButton);
    }

    // MODIFIES: panel
    // EFFECTS: creates labels for the overall GUI, and adds label to panel
    private void createLabels() {
        JLabel screenTitle = new JLabel("Basketball Stat Tracker");
        panel.add(screenTitle);
    }

    // MODIFIES: frame
    // EFFECTS: creates a frame for the GUI and the panel
    private void createFrame() {
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Lebron-like players");
        frame.pack();
        frame.setVisible(true);
    }

    // Creates the interesting graphic for the GUI
    private void pictureIcon() {
        String imagePath = "data/thanasis.jpeg";
        ImageIcon image = new ImageIcon(imagePath);
        JLabel pictureLabel = new JLabel(image);
        frame.add(pictureLabel);
        frame.pack();
    }

    // EFFECTS: prints the EventLog to the panel
    private void printLoggers(EventLog log) {
        for (Event e : log) {
            System.out.println(e.toString());
        }
    }
}
