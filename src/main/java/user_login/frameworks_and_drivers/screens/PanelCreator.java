package user_login.frameworks_and_drivers.screens;

import javax.swing.*;

public class PanelCreator extends JPanel{
    public PanelCreator(JLabel description, JTextField textField){
        this.add(description);
        this.add(textField);
    }
}
