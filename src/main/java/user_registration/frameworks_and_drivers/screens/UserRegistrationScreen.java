package user_registration.frameworks_and_drivers.screens;

//import drug_request_frameworks_drivers.PanelGenerator;

import user_registration.frameworks_and_drivers.screens.panel_creator.PanelCreator;
import user_registration.interface_adapters.UserPresenterOutputBoundary;
import user_registration.interface_adapters.UserRegistrationController;
import user_registration.interface_adapters.UserRegistrationViewmodel;
import user_registration.usecase_engine.output.UserRegistrationOutputData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserRegistrationScreen extends JPanel implements ActionListener, UserPresenterOutputBoundary {
    JButton submitUserRegistration, cancelUserRegistration;
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

//    JPasswordField password = new JPasswordField(15);
//    JComboBox drugName = new JComboBox();

    JTextField requestResponse = new JTextField(35);

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
         submitUserRegistration = new JButton(" Submit User Registration");
         cancelUserRegistration = new JButton("Cancel");

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
        if (actionEvent.getSource() == submitUserRegistration) {


//        System.out.println("Clicked " + actionEvent.getActionCommand());
            try {
                userRegistrationController.createInputObject(firstName.getText(), lastName.getText(), username.getText(),
                        password.getText());
                JOptionPane.showMessageDialog(this, String.format("User Registration Request recorded for " +
                        "%s", username.getText()));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(cancelUserRegistration, e.getMessage());
            }
            } else if (actionEvent.getSource() == cancelUserRegistration) {
            System.exit(0);
            }
        }


    @Override
    public UserRegistrationOutputData presenterOutput(UserRegistrationOutputData presenterOutputData) {
        UserRegistrationViewmodel userRegistrationViewmodel = new UserRegistrationViewmodel(presenterOutputData.getFirstName(),
                presenterOutputData.getLastname(),presenterOutputData.getUsername(), presenterOutputData.getCreationTime());
        requestResponse.setText(String.format("Welcome %s, %s,! Your new user, %s was created at %s", userRegistrationViewmodel.getFirstName(),
                userRegistrationViewmodel.getLastname(), userRegistrationViewmodel.getUsername(), userRegistrationViewmodel.getCreationTime()));
        return presenterOutputData;
    }
}
