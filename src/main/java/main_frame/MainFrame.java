package main_frame;

import drug_fulfill.drug_fulfill_depot_inventories.DrugFulfillHelper;
import drug_fulfill.drug_fulfill_depot_inventories.DrugFulfillScreen;
import drug_search.frameworks_drivers.DrugSearchHelper;
import drug_search.frameworks_drivers.DrugSearchScreen;
import site_drug_request.drug_request_frameworks_drivers.DrugRequestHelper;
import site_drug_request.drug_request_frameworks_drivers.DrugRequestScreen;
import user_login.frameworks_and_drivers.screens.UserLogInHelper;
import user_login.frameworks_and_drivers.screens.UserLoginScreen;
import user_registration.frameworks_and_drivers.screens.HomeScreen;
import user_registration.frameworks_and_drivers.screens.UserRegistrationHelper;
import user_registration.frameworks_and_drivers.screens.UserRegistrationScreen;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

/**
 * MainFrame Class initializes the various screens and is called by the Main class.
 */
public class MainFrame {
    JFrame mainFrame;
    /**
     * contentPane is a container where all the screens are added.
     */
    Container contentPane;
    /**
     * siteRole is set to "Site User"
     */
    String siteRole = "Site User";
    /**
     * depotRole is set to "Depot User"
     */
    String depotRole = "Depot User";
    /**
     * The homeScreen panel.
     */
    HomeScreen homeScreen;
    /**
     * Helps initialise the userLogInScreen
     */
    UserLogInHelper userLogInHelper;
    /**
     * The userLoginScreen panel
     */
    UserLoginScreen userLoginScreen;
    /**
     * Helps initialise the userRegistrationScreen
     */
    UserRegistrationHelper userRegistrationHelper;
    /**
     * The userRegistrationScreen panel
     */
    UserRegistrationScreen userRegistrationScreen;
    /**
     * Helps initialise the drugRequestScreen
     */
    DrugRequestHelper drugRequestHelper;
    /**
     * The drugRequestScreen panel
     */
    DrugRequestScreen drugRequestScreen;
    /**
     * Helps initialise the drugScreenScreenNewer
     */
    DrugSearchHelper drugSearchHelper;
    /**
     * The drugSearchScreenNewer panel
     */
    DrugSearchScreen drugSearchScreenNewer;
    /**
     * Helps initialise the drugFulfillScreen
     */
    DrugFulfillHelper drugFulfillHelper;
    /**
     * The drugFullfillScreen panel
     */
    DrugFulfillScreen drugFulfillScreen;

    String previousScreen = "Home Screen";

    /**
     * Responsible for adding the various Screens into the contentPanel container of the MainFrame.
     */
    public MainFrame() {
        /*
        Set up the mainFrame, the contentpane container and set its layout and size
         */
        mainFrame = new JFrame("Welcome to Diffusion");
        contentPane = mainFrame.getContentPane();
        contentPane = new JPanel();
        contentPane.setLayout(new CardLayout(200, 200));
        mainFrame.add(contentPane, BorderLayout.CENTER);


        //Create an object of each of the various screens that will be added to the contentpane JPanel as
        //a new card for the Card layout
         homeScreen = new HomeScreen();

         userLogInHelper = new UserLogInHelper();
         userLoginScreen = userLogInHelper.LogInScreenGenerator();

         userRegistrationHelper = new UserRegistrationHelper();
         userRegistrationScreen = userRegistrationHelper.GenerateRegistrationScreen();

         drugRequestHelper = new DrugRequestHelper();
         drugRequestScreen = drugRequestHelper.DrugRequestGenerator();

         drugSearchHelper = new DrugSearchHelper();
         drugSearchScreenNewer = drugSearchHelper.generateDrugSearchScreen();

         drugFulfillHelper = new DrugFulfillHelper();
         drugFulfillScreen = drugFulfillHelper.DrugFulfillGenerator();

        /*
        Create buttonPanels for the various screen
         */
        JPanel homeScreenButtonPanel = new JPanel();
        JPanel homeScreenButtonPanel2 = new JPanel();
        JPanel registrationScreenButtonPanel = new JPanel();
        JPanel logInScreenButtonPanel = new JPanel();
        JPanel submitLoginButtonPanel = new JPanel();
        JPanel drugRequestButtonPanel = new JPanel();
        JPanel drugOrderButtonPanel = new JPanel();
        JPanel drugSearchButtonPanel = drugSearchScreenNewer.getSearchButtonPanel();

        /*
        Create buttons for each screen  to add to eachScreens button panel.
         */
        JButton login = new JButton("LogIn");
        JButton registration = new JButton("Registration");

        JButton registrationScreenLogInButton = new JButton("Login");
        JButton registrationScreenHomeScreenButton = new JButton("Return Home");

        JButton logInScreenHomeScreenButton = new JButton("Return Home");
        JButton logInScreenRegistrationButton = new JButton("Registration");

        JButton submitLoginButton = new JButton("Click Here if login Status is Approved");

//        JButton drugRequestButton = new JButton("Drug Request");
        JButton drugRequestScreenHomeButton = new JButton("Return Home");
        JButton drugRequestScreensSearchButton = new JButton("Drug Search");

        JButton drugSearchButton = new JButton("Drug Search");
        JButton goBackButtonDrugSearchScreen = new JButton("Go Back");


        JButton drugOrderButton = new JButton("Drug Order");
        JButton drugSearchButtonDrugOrderScreen = new JButton("Drug Search");

        /*
        Add the various buttons to their respective screens button panel
         */
        homeScreenButtonPanel.add(login);
        homeScreenButtonPanel.add(registration);

        registrationScreenButtonPanel.add(registrationScreenLogInButton);
        registrationScreenButtonPanel.add(registrationScreenHomeScreenButton);

        logInScreenButtonPanel.add(logInScreenHomeScreenButton);
        logInScreenButtonPanel.add(logInScreenRegistrationButton);

        submitLoginButtonPanel.add(submitLoginButton);

        drugRequestButtonPanel.add(drugRequestScreenHomeButton);
        drugRequestButtonPanel.add(drugRequestScreensSearchButton);

        drugSearchButtonPanel.add(goBackButtonDrugSearchScreen);

        drugOrderButtonPanel.add(drugSearchButtonDrugOrderScreen);


        /*
        Add the button panels to the Screens.
         */
        homeScreen.add(homeScreenButtonPanel);
        homeScreen.add(homeScreenButtonPanel2);
        userRegistrationScreen.add(registrationScreenButtonPanel);
        userLoginScreen.add(logInScreenButtonPanel);
        userLoginScreen.add(submitLoginButtonPanel);
        drugRequestScreen.add(drugRequestButtonPanel);
        drugFulfillScreen.add(drugOrderButtonPanel);


        /*
        Adding the screen to the mainframe container, contentpane.
        Import Note, the Text entered is a constraint which needs to match exactly with how it is written in the
        Action Listener.
         */
        contentPane.add(homeScreen, "Home Screen");
        contentPane.add(userRegistrationScreen, "User Registration");
        contentPane.add(userLoginScreen, "User LogIn");
        contentPane.add(drugSearchScreenNewer, "Drug Search");
        contentPane.add(drugFulfillScreen, "Drug Order Screen");
        contentPane.add(drugRequestScreen, "Drug Request Screen");
//        contentPane.add(drugDrugFulfillScreen, "Drug Order Screen");


        /*
        Add a ActionListener to the  button. Also add an action performed method to it.
        Cast type Card layout to Layout manager of contentPane. Allowing card-layout to access it.
        Flip to the specified card in the contentPane.
         */
        login.addActionListener(e -> {
            System.out.println("Clicked " + login.getText());
            CardLayout cardLayout = (CardLayout) contentPane.getLayout();
            cardLayout.show(contentPane, "User LogIn");
        });

        registration.addActionListener(e -> {
            System.out.println("Clicked " + registration.getText());
            CardLayout cardLayout = (CardLayout) contentPane.getLayout();
            cardLayout.show(contentPane,"User Registration");
        });
        registrationScreenLogInButton.addActionListener(e -> {
            System.out.println("Clicked " + registrationScreenLogInButton.getText());
            CardLayout cardLayout = (CardLayout) contentPane.getLayout();
            cardLayout.show(contentPane,"User LogIn");
        });
        registrationScreenHomeScreenButton.addActionListener(e -> {
            System.out.println("Clicked " + registrationScreenHomeScreenButton.getText());
            CardLayout cardLayout = (CardLayout) contentPane.getLayout();
            cardLayout.show(contentPane, "Home Screen");

        });
        logInScreenHomeScreenButton.addActionListener(e -> {
            System.out.println("Clicked " + logInScreenHomeScreenButton.getText());
            CardLayout cardLayout = (CardLayout) contentPane.getLayout();
            cardLayout.show(contentPane, "Home Screen");
        });

        logInScreenRegistrationButton.addActionListener(e -> {
            System.out.println("Clicked " + logInScreenRegistrationButton.getText());
            CardLayout cardLayout = (CardLayout) contentPane.getLayout();
            cardLayout.show(contentPane, "User Registration");

        });

        submitLoginButton.addActionListener(e -> {
            System.out.println("Clicked " + submitLoginButton.getText());
            if (userLoginScreen.getSubmitLoginStatus()) {
                CardLayout cardLayout = (CardLayout) contentPane.getLayout();
                if (Objects.equals(userLoginScreen.getUserRole(), siteRole)) {
                    drugRequestScreen.setAccountID(userLoginScreen.getAccountID());
                    drugRequestScreen.setSiteName(userLoginScreen.getLocationName());
//                    drugFulfillScreen.setLocationRole(siteRole);
//                    drugFulfillScreen.setLocationID(userLoginScreen.getAccountID());
                    cardLayout.show(contentPane, "Drug Request Screen");
                } else if (Objects.equals(userLoginScreen.getUserRole(), depotRole)) {
                    drugFulfillScreen.setLocationID(userLoginScreen.getLocationName());
                cardLayout.show(contentPane, "Drug Order Screen");
                }
            } else{
                JOptionPane.showMessageDialog(userLoginScreen, "User Login Status Not Approved.");
            }
        });

        drugSearchButton.addActionListener(e -> {
            System.out.println("Clicked " + drugSearchButton.getText());
            CardLayout cardLayout = (CardLayout) contentPane.getLayout();
            cardLayout.show(contentPane, "Home Screen");

        });

        drugOrderButton.addActionListener(e -> {
            System.out.println("Clicked " + drugOrderButton.getText());
            CardLayout cardLayout = (CardLayout) contentPane.getLayout();
            cardLayout.show(contentPane, "Drug Order Screen");

        });

        drugRequestScreenHomeButton.addActionListener(e -> {
            System.out.println("Clicked " + drugRequestScreenHomeButton.getText());
            CardLayout cardLayout = (CardLayout) contentPane.getLayout();
            cardLayout.show(contentPane, "Home Screen");

        });

        drugRequestScreensSearchButton.addActionListener(e -> {
            System.out.println("Clicked " + drugRequestScreensSearchButton.getText());
            CardLayout cardLayout = (CardLayout) contentPane.getLayout();
            cardLayout.show(contentPane, "Drug Search");
            previousScreen = "Drug Request Screen";
        });

        goBackButtonDrugSearchScreen.addActionListener(e -> {
            System.out.println("Clicked " + goBackButtonDrugSearchScreen.getText());
            CardLayout cardLayout = (CardLayout) contentPane.getLayout();
            cardLayout.show(contentPane, previousScreen);

        });

        drugSearchButtonDrugOrderScreen.addActionListener(e -> {
            System.out.println("Clicked " + drugSearchButtonDrugOrderScreen.getText());
            CardLayout cardLayout = (CardLayout) contentPane.getLayout();
            cardLayout.show(contentPane, "Drug Search");
            previousScreen = "Drug Order Screen";
        });


        /*
        Sizes the mainFrame so that all components are at their preferred size, if you uncomment this you will
        the mainframe will only be as big as the open, close and minimize buttons.
         */
        mainFrame.pack();

        /*
        Exits program when close button is clicked.
         */
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /*
        Makes the mainFrame visible.
         */
        mainFrame.setVisible(true);

    }
}
