package main_frame;

import drug_fulfill.drug_fulfill_depot_inventories.DrugFulfillHelper;
import drug_fulfill.drug_fulfill_depot_inventories.OrderScreen;
import drug_search.frameworks_drivers.DrugSearchHelper;
import drug_search.frameworks_drivers.DrugSearchScreen;
import drug_search.frameworks_drivers.DrugSearchScreenNew;
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

public class MainFrame {
//    static JFrame mainFrame = new JFrame("Card Layout Test");

    //    static Container contentPane = mainFrame.getContentPane();
    JPanel contentPane;
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

//        DrugSearchHelper drugSearchHelper = new DrugSearchHelper();
//        DrugSearchScreenNew drugSearchScreen = drugSearchHelper.generateDrugSearchScreen();

        DrugFulfillHelper drugFulfillHelper = new DrugFulfillHelper();
        OrderScreen orderScreen = drugFulfillHelper.DrugFulfillGenerator();

        /*
        Using a helper for the use case engine setup and creating the screens
         */


        /*
        Create a homeScreenButtonPanel
         */
        JPanel homeScreenButtonPanel = new JPanel();
        JPanel registrationScreenButtonPanel = new JPanel();
        JPanel logInScreenButtonPanel = new JPanel();
        JPanel submitLoginButtonPanel = new JPanel();

        /*
        Create buttons login and registration to add to buttonPanel.
         */
        JButton login = new JButton("LogIn");
        JButton registration = new JButton("Registration");

        JButton registrationLI = new JButton("Login");
        JButton registrationHS = new JButton("Return Home");

        JButton logInHS = new JButton("Return Home");
        JButton logInR = new JButton("Registration");

        JButton submitLoginButton = new JButton("Submit Login");
//        submitLoginButton.setEnabled(true);


        /*
        Add buttons login and registration to buttonPanel
         */
        homeScreenButtonPanel.add(login);
        homeScreenButtonPanel.add(registration);

        registrationScreenButtonPanel.add(registrationLI);
        registrationScreenButtonPanel.add(registrationHS);

        logInScreenButtonPanel.add(logInHS);
        logInScreenButtonPanel.add(logInR);

        submitLoginButtonPanel.add(submitLoginButton);


        homeScreen.add(homeScreenButtonPanel);
        userRegistrationScreen.add(registrationScreenButtonPanel);
        userLoginScreen.add(logInScreenButtonPanel);
        userLoginScreen.add(submitLoginButtonPanel);

        /*
        Note the Below will add the button panel to the HomeScreen panel directly. Look for Ref - 1 below where
        buttonPanel is added to the mainFrame contentPane instead.
         */

        /*
        Adds the homeScreen to the contentPane.
         */

        /*
        The usecase engine construction has been outsourced to the UserRegistrationHelper to clean up the
        mainFrame.
         */



        /*
        Adding the screen to the mainframe container, contentpane,  and naming it as well.
         */
//        contentPane.add(userRegistrationScreen, "User Registration");
        contentPane.add(homeScreen, "Home Screen");
        contentPane.add(userRegistrationScreen, "User Registration");
//        contentPane.add(userLoginScreen, "User LogIn");
//        contentPane.add(drugSearchScreen, "User LogIn");
//        contentPane.add(drugSearchScreen.getPanel(), "User LogIn");
//        contentPane.add(drugRequestScreen, "Drug Request Screen");


        contentPane.add(orderScreen, "User LogIn");




        /*
        Create a RegistrationScreen Navigation Panel
         */
//        JPanel registrationScreenButtonPanel = new JPanel();
//        registrationScreenButtonPanel.add(new JButton(login));
//        userRegistrationHelper.GenerateRegistrationScreen().add(login);

        /*
        Was commented out since previously this had to be done after adding in the userRegistrationScreen to the
        mainFrame. However, order doesn't seem to matter.
         */
//        userRegistrationOutputBoundary.setView(userRegistrationScreen);


        /*
        Add a ActionListener to the LogIn button. Also add a action performed method to it.
        Cast type Cardlayout to Layout manager of contentPane. Allowing cardlayout to access it.
        Flip to the card of the specified container.
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
        registrationLI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Clicked " + registrationLI.getText());
                CardLayout cardLayout = (CardLayout) contentPane.getLayout();
                cardLayout.show(contentPane,"User LogIn");
            }
        });
        registrationHS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Clicked " + registrationHS.getText());
                CardLayout cardLayout = (CardLayout) contentPane.getLayout();
                cardLayout.show(contentPane, "Home Screen");

            }
        });
        logInHS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Clicked " + logInHS.getText());
                CardLayout cardLayout = (CardLayout) contentPane.getLayout();
                cardLayout.show(contentPane, "Home Screen");
            }
        });

        logInR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Clicked " + logInR.getText());
                CardLayout cardLayout = (CardLayout) contentPane.getLayout();
                cardLayout.show(contentPane, "User Registration");

            }
        });

        submitLoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Clicked " + submitLoginButton.getText());
                if (userLoginScreen.getSubmitLoginStatus().equals(true)) {
                    submitLoginButton.setEnabled(true);
                    CardLayout cardLayout = (CardLayout) contentPane.getLayout();
                    cardLayout.show(contentPane, "Drug Request Screen");
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

        // REF - 1) Add the contentPane (JPanel) and buttonPanel to the JFrame.
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


        /*
        Older code has been commented out below.
         */
//        CardLayout cardLayout = new CardLayout();
//
//        mainFrame.setLayout(cardLayout);
//        HomeScreen homeScreen = new HomeScreen();
//        homeScreen.

//        //Below are the parts for the use case entities engine
//        UserRegistrationDsGateway userRegistrationDsGateway;
//        try{
//            userRegistrationDsGateway = new UserRegistrationRecorder("./RegistrationList3.csv");
//
//        } catch (IOException e) {
//            throw new RuntimeException("Can't create file.");
//        }
//
////        UserRegistrationDsGateway userRegistrationDsGateway = null;
//        UserRegistrationPresenter userRegistrationOutputBoundary = new UserRegistrationPresenter();
//        UserRegistrationGenerator userRegistrationGenerator = new CommonUserRegistrationFactory();
//        UserRegistrationInteractor userRegistrationInteractor = new UserRegistrationInteractor(userRegistrationDsGateway,
//                userRegistrationOutputBoundary, userRegistrationGenerator);
//        UserRegistrationController userRegistrationController = new UserRegistrationController(userRegistrationInteractor);
//
//        //below is the DrugRequestScreen panel which is added to this JFrame Window
//        UserRegistrationScreen userRegistrationScreen = new UserRegistrationScreen(userRegistrationController);
//
//
//
////        add(userRegistrationScreen);
////        userRegistrationScreen.add(userRegistrationController);
//        mainFrame.add(userRegistrationScreen);
//
//        userRegistrationOutputBoundary.setView(userRegistrationScreen);
//
////        mainFrame.add(userRegistrationScreen);
//
//
//
//
////        mainFrame.add(new UserRegistrationScreen(new UserRegistrationHelper()), "1");


//        cardLayout.show(mainFrame.getContentPane(), "1");

//        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        mainFrame.pack();
//        mainFrame.setLocationRelativeTo(null);
//        mainFrame.pack();
//
//        mainFrame.setVisible(true);

    }
}
