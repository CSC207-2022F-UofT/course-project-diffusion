package drug_fulfill.drug_fulfill_depot_inventories;

import javax.swing.*;

// Frameworks/Drivers layer

public class LabelComboBox extends JPanel {
    public LabelComboBox(JLabel combo, JComboBox textField) {
        this.add(combo);
        this.add(textField);
    }
}
