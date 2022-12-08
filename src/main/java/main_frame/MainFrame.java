package main_frame;

import drug_fulfill.drug_fulfill_depot_inventories.DrugFulfillHelper;
import drug_fulfill.drug_fulfill_depot_inventories.OrderScreen;
import drug_search.frameworks_drivers.DrugSearchHelper;
import drug_search.frameworks_drivers.DrugSearchScreenNewer;
import site_drug_request.drug_request_frameworks_drivers.DrugRequestHelper;
import site_drug_request.drug_request_frameworks_drivers.DrugRequestScreen;
import user_login.frameworks_and_drivers.screens.UserLogInHelper;
import user_login.frameworks_and_drivers.screens.UserLoginScreen;
import user_registration.frameworks_and_drivers.screens.HomeScreen;
import user_registration.frameworks_and_drivers.screens.UserRegistrationHelper;
import user_registration.frameworks_and_drivers.screens.UserRegistrationScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

/**
 * Responsible for adding the various JPanel frames into the MainFrame
 */
public class MainFrame {
    JPanel contentPane;
    String siteRole = "Site User";
    String depotRole = "Depot User";
    public MainFrame() {

        JFrame mainFrame = new JFrame("Welcome to Diffusion");

        //contentPane here is the base for the CardLayout, for which other JPanels will be added.
        contentPane = new JPanel();
//        Container contentPane = mainFrame.getContentPane();
        contentPane.setLayout(new CardLayout(200, 200));


        //Create an object of each of the various screens that will be added to the contentpane JPanel as
        //a new card.
        HomeScreen homeScreen = new HomeScreen();

        UserLogInHelper userLogInHelper = new UserLogInHelper();
        UserLoginScreen userLoginScreen = userLogInHelper.LogInScreenGenerator();

        UserRegistrationHelper userRegistrationHelper = new UserRegistrationHelper();
        UserRegistrationScreen userRegistrationScreen = userRegistrationHelper.GenerateRegistrationScreen();

        DrugRequestHelper drugRequestHelper = new DrugRequestHelper();
        DrugRequestScreen drugRequestScreen = drugRequestHelper.DrugRequestGenerator();

        DrugSearchHelper drugSearchHelper = new DrugSearchHelper();
        DrugSearchScreenNewer drugSearchScreenNewer = drugSearchHelper.generateDrugSearchScreen();

        DrugFulfillHelper drugFulfillHelper = new DrugFulfillHelper();
        OrderScreen drugOrderScreen = drugFulfillHelper.DrugFulfillGenerator();

        /*
        Create a buttonPanels for the various screen
         */
        JPanel homeScreenButtonPanel = new JPanel();
        JPanel homeScreenButtonPanel2 = new JPanel();
        JPanel registrationScreenButtonPanel = new JPanel();
        JPanel logInScreenButtonPanel = new JPanel();
        JPanel submitLoginButtonPanel = new JPanel();
        JPanel drugRequestButtonPanel = new JPanel();
        JPanel drugOrderButtonPanel = new JPanel();
        JPanel drugSearchButtonPanel = new JPanel();

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

        JButton drugRequestButton = new JButton("Drug Request");
        JButton drugRequestScreenHomeButton = new JButton("Return Home");
        JButton drugRequestScreensSearchButton = new JButton("Drug Search");

        JButton drugSearchButton = new JButton("Drug Search");
        JButton homeScreenButtonDrugSearchScreen = new JButton("HomeScreen");


        JButton drugOrderButton = new JButton("Drug Order");
        JButton drugSearchButtonDrugOrderScreen = new JButton("Drug Search");
//        submitLoginButton.setEnabled(false);


        /*
        Add the various buttons to their respective screens button panel
         */
        homeScreenButtonPanel.add(login);
        homeScreenButtonPanel.add(registration);
        /*
        Add a login and HomeScreen navigation button to the registrationScreenButtonPanel.
         */
        registrationScreenButtonPanel.add(registrationScreenLogInButton);
        registrationScreenButtonPanel.add(registrationScreenHomeScreenButton);

        /*
        Add logIn and homeScreen navigation buttons to loginScreenButtonPanel.
         */
        logInScreenButtonPanel.add(logInScreenHomeScreenButton);
        logInScreenButtonPanel.add(logInScreenRegistrationButton);

        submitLoginButtonPanel.add(submitLoginButton);

        drugRequestButtonPanel.add(drugRequestScreenHomeButton);
        drugRequestButtonPanel.add(drugRequestScreensSearchButton);

        drugSearchButtonPanel.add(homeScreenButtonDrugSearchScreen);

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
        drugOrderScreen.add(drugOrderButtonPanel);
//        drugSearchScreenNewer.add(drugSearchButtonPanel);


        /*
        Adding the screen to the mainframe container, contentpane.
        Import Note, the Text entered is a constraint which needs to match exactly with how it is written in the Action Listener.
         */
        contentPane.add(homeScreen, "Home Screen");
        contentPane.add(userRegistrationScreen, "User Registration");
        contentPane.add(userLoginScreen, "User LogIn");
        contentPane.add(drugSearchScreenNewer, "Drug Search");
        contentPane.add(drugOrderScreen, "Drug Order Screen");
        contentPane.add(drugRequestScreen, "Drug Request Screen");
//        contentPane.add(drugOrderScreen, "Drug Order Screen");


        /*
        Add a ActionListener to the  button. Also add an action performed method to it.
        Cast type Cardlayout to Layout manager of contentPane. Allowing cardlayout to access it.
        Flip to the specified card in the contentPane.
         */
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Clicked " + login.getText());
                CardLayout cardLayout = (CardLayout) contentPane.getLayout();
                cardLayout.show(contentPane, "User LogIn");
            }
        });

        registration.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Clicked " + registration.getText());
                CardLayout cardLayout = (CardLayout) contentPane.getLayout();
                cardLayout.show(contentPane,"User Registration");
            }
        });
        registrationScreenLogInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Clicked " + registrationScreenLogInButton.getText());
                CardLayout cardLayout = (CardLayout) contentPane.getLayout();
                cardLayout.show(contentPane,"User LogIn");
            }
        });
        registrationScreenHomeScreenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Clicked " + registrationScreenHomeScreenButton.getText());
                CardLayout cardLayout = (CardLayout) contentPane.getLayout();
                cardLayout.show(contentPane, "Home Screen");

            }
        });
        logInScreenHomeScreenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Clicked " + logInScreenHomeScreenButton.getText());
                CardLayout cardLayout = (CardLayout) contentPane.getLayout();
                cardLayout.show(contentPane, "Home Screen");
            }
        });

        logInScreenRegistrationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Clicked " + logInScreenRegistrationButton.getText());
                CardLayout cardLayout = (CardLayout) contentPane.getLayout();
                cardLayout.show(contentPane, "User Registration");

            }
        });

        submitLoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Clicked " + submitLoginButton.getText());
                if (userLoginScreen.getSubmitLoginStatus()) {
                    System.out.println(true);
                    CardLayout cardLayout = (CardLayout) contentPane.getLayout();
                    System.out.println(userLoginScreen.getLoginStatusType());
                    System.out.println(siteRole);
                    System.out.println(Objects.equals(userLoginScreen.getLoginStatusType(), siteRole));
                    if (Objects.equals(userLoginScreen.getLoginStatusType(), siteRole)) {
//                        drugOrderScreen.setUserRole(userRegistrationScreen.getRole());
//                        System.out.println(true);
                        cardLayout.show(contentPane, "Drug Request Screen");
                    } else if (Objects.equals(userLoginScreen.getLoginStatusType(), depotRole)) {
                    cardLayout.show(contentPane, "Drug Order Screen");
                    }
//                    submitLoginButton.setEnabled(true);
                } else{
                    JOptionPane.showMessageDialog(userLoginScreen, "User Login Status Not Approved.");
                }
//                try{if (userLoginScreen.getSubmitLoginStatus().equals(true)){
//                    submitLoginButton.setEnabled(true);
//                    CardLayout cardLayout = (CardLayout) contentPane.getLayout();
//                    cardLayout.show(contentPane, "Drug Request Screen");
//                }
//
//                }catch (Exception actionEvent){
//                    JOptionPane.showMessageDialog(userLoginScreen, "User Login Status not Approved.");
//                }
            }
        });

        drugSearchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Clicked " + drugSearchButton.getText());
                CardLayout cardLayout = (CardLayout) contentPane.getLayout();
                cardLayout.show(contentPane, "Home Screen");

            }
        });

        drugOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Clicked " + drugOrderButton.getText());
                CardLayout cardLayout = (CardLayout) contentPane.getLayout();
                cardLayout.show(contentPane, "Drug Order Screen");

            }
        });

        drugRequestScreenHomeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Clicked " + drugRequestScreenHomeButton.getText());
                CardLayout cardLayout = (CardLayout) contentPane.getLayout();
                cardLayout.show(contentPane, "Home Screen");

            }
        });

        drugRequestScreensSearchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Clicked " + drugRequestScreensSearchButton.getText());
                CardLayout cardLayout = (CardLayout) contentPane.getLayout();
                cardLayout.show(contentPane, "Drug Search");

            }
        });

        homeScreenButtonDrugSearchScreen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Clicked " + homeScreenButtonDrugSearchScreen.getText());
                CardLayout cardLayout = (CardLayout) contentPane.getLayout();
                cardLayout.show(contentPane, "Home Screen");

            }
        });

        drugSearchButtonDrugOrderScreen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Clicked " + drugSearchButtonDrugOrderScreen.getText());
                CardLayout cardLayout = (CardLayout) contentPane.getLayout();
                cardLayout.show(contentPane, "Drug Search");

            }
        });

        mainFrame.add(contentPane, BorderLayout.CENTER);

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
