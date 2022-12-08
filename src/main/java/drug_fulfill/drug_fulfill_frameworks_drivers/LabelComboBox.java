package drug_fulfill.drug_fulfill_frameworks_drivers;

import javax.swing.*;

// Frameworks/Drivers layer

public class LabelComboBox extends JPanel {
    public LabelComboBox(JLabel combo, JComboBox textField) {
        this.add(combo);
        this.add(textField);
    }
}
