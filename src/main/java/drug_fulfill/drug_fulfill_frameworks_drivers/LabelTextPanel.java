package drug_fulfill.drug_fulfill_frameworks_drivers;

import javax.swing.*;

// Frameworks/Drivers layer

public class LabelTextPanel extends JPanel {
    public LabelTextPanel(JLabel label, JTextField textField) {
        this.add(label);
        this.add(textField);
    }
}
