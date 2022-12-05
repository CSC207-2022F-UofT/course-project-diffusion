package drug_request_frameworks_drivers;

import javax.swing.*;

/**
 * PanelGenerator allows description and textfield to be added to the end of the container hierarchy together, so they
 * appear beside each other.
 */
public class PanelGenerator extends JPanel {
    public PanelGenerator(JLabel description, JTextField textField){
        this.add(description);
        this.add(textField);
    }
}
