package screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Frameworks/Drivers layer

public class RegisterScreen extends JPanel implements ActionListener {
    /**
     * The drugName chosen by the user
     */
    JTextField drugName = new JTextField(15);
    /**
     * The password
     */
    JTextField bottle = new JTextField(15);
    /**
     * The second password to make sure the user understands
     */
    JPasswordField repeatPassword = new JPasswordField(15);

    /**
     * The emergency toggle
     */
    JCheckBox isEmergency;

    /**
     * The controller
     */
    DrugRequestController userRegisterController;

    /**
     * A window with a title and a JButton.
     */
    public RegisterScreen(DrugRequestController controller) {

        this.userRegisterController = controller;

        JLabel title = new JLabel("Order Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel drugNameInfo = new LabelTextPanel(
                new JLabel("Choose drugName"), drugName);
        LabelTextPanel passwordInfo = new LabelTextPanel(
                new JLabel("Choose amount/bottle"), bottle);


        isEmergency=new JCheckBox("Toggle if Emergency");
        isEmergency.setBounds(100,100,150,20);

        JButton signUp = new JButton("Sign up");
        JButton cancel = new JButton("Cancel");

        JPanel buttons = new JPanel();
        buttons.add(signUp);
        buttons.add(cancel);

        signUp.addActionListener(this);
        cancel.addActionListener(this);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(drugNameInfo);
        this.add(passwordInfo);
        this.add(isEmergency);
        this.add(buttons);

    }

    /**
     * React to a button click that results in evt.
     */
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
        Boolean ie = Boolean.FALSE;
        if(isEmergency.isSelected()){
            ie = Boolean.TRUE;
        }
        try {
            userRegisterController.create(drugName.getText(),
                    Integer.parseInt(bottle.getText()), //just some number for now
                    //String.valueOf(password.getPassword()),
                    //String.valueOf(repeatPassword.getPassword()),
                    ie);



            JOptionPane.showMessageDialog(this,  String.format(bottle.getText()) + String.format(drugName.getText()) + "is emergency " + isEmergency.isSelected());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "please put in a number for amount");
        }

    }
}