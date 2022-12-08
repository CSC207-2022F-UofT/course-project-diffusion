package helper_methods;

import javax.swing.*;

public class PanelCreator extends JPanel{
    public PanelCreator(JLabel description, JTextField textField){
        this.add(description);
        this.add(textField);
    }
}