package error_report_framework_driver;

import javax.swing.*;

public class PanelGenerator extends JPanel{
    public PanelGenerator(JLabel description, JTextField textField){
        this.add(description);
        this.add(textField);
    }
}
