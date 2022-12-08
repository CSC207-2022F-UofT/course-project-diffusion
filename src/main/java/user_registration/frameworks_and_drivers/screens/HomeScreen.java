package user_registration.frameworks_and_drivers.screens;

import javax.swing.*;
import java.awt.*;

/**
 *Create the HomeScreen Panel
 */
public class HomeScreen extends JPanel{

    /**
     * A Home screen with a title and buttons to switch to log In or registration screen.
     */
    public HomeScreen() {
        /*
          Create a JLabel title and centre it.
         */
        JLabel title = new JLabel("Select Registration if you are a new user.");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        /*
        Create JPanel homeScreenPanel to store components for the homescreen which will have a Boxlayout
         */
        JPanel homeScreenPanel = new JPanel();
        homeScreenPanel.setLayout(new BoxLayout(homeScreenPanel, BoxLayout.Y_AXIS));

        homeScreenPanel.add(title);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        setSize(600, 500);

        this.add(title);
        this.add(homeScreenPanel);

    }
}
