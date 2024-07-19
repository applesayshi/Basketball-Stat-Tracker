package ui;

import model.Player;
import model.Tracker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// This is the pop-up panel that is created when the add Players button is pressed
public class AddPlayersPanel {

    private JFrame frame = new JFrame();
    private JPanel panel = new JPanel();
    private int width = 300;
    private int height = 300;
    private JButton enterButton;
    private JTextField playerNameText;
    private JTextField ageText;
    private JTextField weightText;
    private JTextField heightText;
    Player newPlayer;
    String playerName;
    int playerAge;
    int playerWeight;
    int playerHeight;
    Tracker tracker;

    // constructs an add players panel with tracker as its parameter
    public AddPlayersPanel(Tracker tracker) {
        this.tracker = tracker;
        createStarterPanel();
        createFrame();
        createTextField();
        createEnterButton();
        produceMadePlayer();
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
        frame.setTitle("Add Players");
        frame.pack();
        frame.setVisible(true);

    }

    // MODIFIES: panel
    // EFFECTS: creates labels for the overall GUI, and adds label to panel
    private void createLabels(String c) {
        JLabel label = new JLabel(c);
        panel.add(label);
    }

    // EFFECTS: creates the text field for the player name, age, weight and height.
    private void createTextField() {

        createLabels("Player Name");
        playerNameText = new JTextField(20);
        playerNameText.setBounds(100, 20, 100, 25);
        panel.add(playerNameText);

        createLabels("Player Age");
        ageText = new JTextField(20);
        ageText.setBounds(100, 20, 100, 25);
        panel.add(ageText);

        createLabels("Player Weight");
        weightText = new JTextField(20);
        weightText.setBounds(100, 20, 100, 25);
        panel.add(weightText);

        createLabels("Player Height");
        heightText = new JTextField(20);
        heightText.setBounds(100, 20, 100, 25);
        panel.add(heightText);
    }

    // EFFECTS: creates the enter button that will close the window, and add player to list
    private void createEnterButton() {
        enterButton = new JButton("Enter");
        enterButton.setBounds(10, 80, 30, 25);
        panel.add(enterButton);
    }

    // EFFECTS: makes this classes own set visibility method
    public void makeOwnSetVisible(boolean b) {
        frame.setVisible(b);
        panel.setVisible(b);
    }

    // EFFECTS: button listener for when the enter button is pressed after creating
    //          a character
    public void produceMadePlayer() {
        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                playerName = playerNameText.getText();
                playerAge = Integer.parseInt(ageText.getText().trim());
                playerWeight = Integer.parseInt(weightText.getText().trim());
                playerHeight = Integer.parseInt(heightText.getText().trim());
                newPlayer = new Player(playerName, playerAge, playerWeight, playerHeight);
                tracker.addPlayerToList(newPlayer);

                playerNameText.setText("");
                ageText.setText("");
                weightText.setText("");
                heightText.setText("");

                panel.setVisible(false);
                frame.setVisible(false);
            }
        });
    }
}
