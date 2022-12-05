package user_registration.frameworks_and_drivers.screens;

//import site_drug_request.drug_request_frameworks_drivers.PanelGenerator;

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


    JTextField requestResponse = new JTextField(45);

    /**
     * the controller
     */
    UserRegistrationController userRegistrationController;

    /**
     * default JComboBox which is initally not loaded with data,
     */
    JComboBox<String> defaultBox;

    /**
     * selectSite JComboBox which will display the sites
     */
    JComboBox<String> selectSite;

    /**
     * selectDepot JComboBox which will dispaly all the depots.
     */
    JComboBox<String> selectDepot;

    /**
     The JRadioButton's siteUserButton and depotUserButton which will be selected by the user.
     */
    JRadioButton siteUserButton, depotUserButton;

    /**
     The role will be specified with an integer, initially it's assigned a value of 0. A value of 1 will represent a
     site user role and a value of 2 will represent a depot user role.
     */
    String role = "";

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
         Set submitUserRegistration to false (disable), this will be enabled once a User Role is selected. This is
         necessary to do in order to prevent exception where user will click submit before selecting a site. Otherwise,
         our input object will have null values for the locationName and Role.
          */
        submitUserRegistration.setEnabled(false);

        /*
          create userRegistrationButtons panel to add buttons to
         */
        JPanel userRegistrationButtons = new JPanel();

        /*
        Add the JButtons to the userRegistrationButtons panel.
         */
        userRegistrationButtons.add(submitUserRegistration);
        userRegistrationButtons.add(cancelUserRegistration);

        /*
        Add action listeners for the following buttons.
         */
        submitUserRegistration.addActionListener(this);
        cancelUserRegistration.addActionListener(this);


        /*
         * A JRadioButton to register a site and depot user role. The setActionCommand will set a String referring to the
         * specific action command, it's component specific and could be used in the future (not used atm, but here
         * to provide flexibility if required later) to refer to the specifc component.
         * get
         */
        siteUserButton = new JRadioButton("Site User Role");
        siteUserButton.setActionCommand("Site");

        depotUserButton = new JRadioButton("Depot User Role");
        depotUserButton.setActionCommand("Depot");


        /*
        Add the siteUserButton and depotUserButton a button group, this allows for only one to be selected at a time.
         */
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(siteUserButton);
        buttonGroup.add(depotUserButton);

        /*
        Put the siteUserButton and depotUserButton in a JPanel to allow them to display side by side.
         */
        JPanel radioButtonPanel = new JPanel();
        radioButtonPanel.add(siteUserButton);
        radioButtonPanel.add(depotUserButton);

        /*
        Sample Depot Data and Site options to display
         */
        String[] sites = {"Site1", "Site2", "Site3"};
        String[] depots = {"Depot1", "Depot2", "Depot3"};


        /*
        Initialize the JComboBox's and add the list of sites and depots to the respected JComboBox's.
         */
        selectSite = new JComboBox<>(sites);
        selectDepot = new JComboBox<>(depots);
        defaultBox = new JComboBox<>();

        /*
        Create a JPanel for the defaultComboBox.
         */
        JPanel defaultComboBoxpanel = new JPanel();
        defaultComboBoxpanel.add(defaultBox);

        /*
        Prevent the user from interacting with the defaultBox. Will be enabled once they select  JRadioButton.
         */
        defaultBox.setEnabled(false);

        /*
        Add actionListeners to the JRadioButtons.
         */
        depotUserButton.addActionListener(this);
        siteUserButton.addActionListener(this);
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
        this.add(radioButtonPanel);
        this.add(defaultComboBoxpanel);
        this.add(userRegistrationButtons);
        this.add(responsePanel);
    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == submitUserRegistration) {
            System.out.println("Clicked " + actionEvent.getActionCommand());
            try {
                userRegistrationController.createInputObject(firstName.getText(), lastName.getText(), username.getText(),
                        password.getText(), selectSite.getSelectedItem(), role);
                JOptionPane.showMessageDialog(this, String.format("User Registration Request recorded for " +
                        "%s", username.getText()));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(cancelUserRegistration, e.getMessage());
            }
        } else if (actionEvent.getSource() == cancelUserRegistration) {
            System.exit(0);
        } else if (actionEvent.getSource().equals(siteUserButton)) {

            defaultBox.setModel(selectSite.getModel());

            defaultBox.setEnabled(true);

            submitUserRegistration.setEnabled(true);


            role = "Site User";
        } else if (actionEvent.getSource().equals(depotUserButton)) {
            System.out.println(selectDepot.getSelectedItem());

            defaultBox.setModel(selectDepot.getModel());

            defaultBox.setEnabled(true);

            submitUserRegistration.setEnabled(true);

            role = "Depot User";
        }

    }
    @Override
    public UserRegistrationOutputData presenterOutput (UserRegistrationOutputData presenterOutputData){
        UserRegistrationViewmodel userRegistrationViewmodel =
                new UserRegistrationViewmodel(presenterOutputData.getFirstName(),
                        presenterOutputData.getLastname(), presenterOutputData.getUsername(),
                        presenterOutputData.getCreationTime());
        requestResponse.setText(String.format("Welcome %s, %s,! Your new user, %s, was created at %s",
                userRegistrationViewmodel.getFirstName(), userRegistrationViewmodel.getLastname(),
                userRegistrationViewmodel.getUsername(), userRegistrationViewmodel.getCreationTime()));
        return presenterOutputData;
    }
}
