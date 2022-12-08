package drug_fulfill.drug_fulfill_depot_inventories;

import javax.swing.*;

// Frameworks/Drivers layer

public class LabelTextPanel extends JPanel {
    public LabelTextPanel(JLabel label, JTextField textField) {
        this.add(label);
        this.add(textField);
    }
}
