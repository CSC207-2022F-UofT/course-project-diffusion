package user_registration.frameworks_and_drivers.screens.panel_creator;

import javax.swing.*;

/**
 * PanelGenerator allows description and textfield to be added to the end of the container hierarchy together, so they
 * appear beside each other.
 */
public class PanelCreator extends JPanel {
    public PanelCreator(JLabel description, JTextField textField){
        this.add(description);
        this.add(textField);
    }
}
