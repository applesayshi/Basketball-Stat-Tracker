package ui;

import model.Player;
import model.Tracker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

// creates the panel that removes the player from the tracker
public class RemovePlayerPanel {

    private JFrame frame = new JFrame();
    private JPanel panel = new JPanel();
    private int width = 100;
    private int height = 100;
    private JTextField playerNameText;
    private Tracker tracker;
    private JButton enterButton;
    String playerName;

    // constructs a remove player panel after pressing remove player key in start panel
    public RemovePlayerPanel(Tracker tracker) {
        this.tracker = tracker;
        createStarterPanel();
        createFrame();
        createTextField();
        createEnterButton();
        deleteMadePlayer();
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
        frame.setTitle("Remove Players");
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

        createLabels("Enter Player Name");
        playerNameText = new JTextField(20);
        playerNameText.setBounds(100, 20, 100, 25);
        panel.add(playerNameText);
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
    public void deleteMadePlayer() {
        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                playerName = playerNameText.getText();

                ArrayList<Player> listOfPlayers = new ArrayList<>();
                for (Player p : tracker.getList()) {
                    listOfPlayers.add(p);
                }
                for (Player p : listOfPlayers) {
                    if (p.getName().equals(playerName)) {
                        tracker.removePlayerFromList(p);
                    }
                }

                playerNameText.setText("");

                panel.setVisible(false);
                frame.setVisible(false);
            }
        });
    }
}
