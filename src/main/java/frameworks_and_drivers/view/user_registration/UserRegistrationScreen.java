package frameworks_and_drivers.view.user_registration;

//import drug_request_frameworks_drivers.PanelGenerator;

import frameworks_and_drivers.view.screens.panel_creator.PanelCreator;
import interface_adapters.user_registration.UserRegistrationController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserRegistrationScreen extends JPanel implements ActionListener {
    /**
     * The first name of the user
     */
    JTextField firstName = new JTextField(15);

    /**
     * The last name of the person
     */
    JTextField lastName = new JTextField(15);

    /**
     * The username of the person
     */
    JTextField username = new JTextField(15);

    /**
     * The password of the person
     */
    JTextField password = new JTextField(15);
//    JComboBox drugName = new JComboBox();

    JTextField requestResponse = new JTextField(15);

    /**
     * the controller
     */
    UserRegistrationController userRegistrationController;

    public UserRegistrationScreen(UserRegistrationController userRegistrationController) {
        this.userRegistrationController = userRegistrationController;

        /*
          the title of the window below
         */
        JLabel title = new JLabel("User Registration Screen");

        /*
          centers the title on the window horizontally
         */
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        /*
        Made the requestResponse panel read only, so it can't be edited by the user
        instead it will be used to display the response to the user.
         */
        requestResponse.setEditable(false);

        /*
          Packages multiple components as a single component using panel Generator.
         */
        PanelCreator firstNamePanel = new PanelCreator(new JLabel("Enter First Name"), firstName);
        PanelCreator lastNamePanel = new PanelCreator(new JLabel("Enter Last Name"), lastName);
        PanelCreator usernamePanel = new PanelCreator(new JLabel("Enter username"), username);
        PanelCreator passwordPanel = new PanelCreator(new JLabel("Enter password "), password);
        PanelCreator responsePanel = new PanelCreator(new JLabel("Created user "), requestResponse);

            /*
          create new buttons submitUserRegistration and cancelUserRegistration
         */
        JButton submitUserRegistration = new JButton(" Submit User Registration");
        JButton cancelUserRegistration = new JButton("Cancel");

        /*
          create userRegistrationButtons panel to add buttons to
         */
        JPanel userRegistrationButtons = new JPanel();

        userRegistrationButtons.add(submitUserRegistration);
        userRegistrationButtons.add(cancelUserRegistration);

        submitUserRegistration.addActionListener(this);
        cancelUserRegistration.addActionListener(this);
        /*
          setLayout invalidates componenet hierarchy and creates a layout manager, BoxLayout, which vertically
          lays out components.
          Uncomment the line below and see how we lose vertical component hierarchy.
         */
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        /*
          Purpose of the below is to add the components to the end of the container in the order they are listed below
         */
        this.add(title);
        this.add(firstNamePanel);
        this.add(lastNamePanel);
        this.add(usernamePanel);
        this.add(passwordPanel);
        this.add(userRegistrationButtons);
        this.add(responsePanel);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        System.out.println("Clicked " + actionEvent.getActionCommand());
        try {
            userRegistrationController.createInputObject(firstName.getText(), lastName.getText(), username.getText(),
                    password.getText());
            JOptionPane.showMessageDialog(this, String.format("User Registration Request recorded for " +
                    "%s", username.getText()));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
}
