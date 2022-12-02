package main_frame;

import user_login.frameworks_and_drivers.screens.UserLogInHelper;
import user_registration.frameworks_and_drivers.screens.HomeScreen;
import user_registration.frameworks_and_drivers.screens.UserRegistrationHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame {
//    static JFrame mainFrame = new JFrame("Card Layout Test");

//    static Container contentPane = mainFrame.getContentPane();
    public MainFrame() {

        JFrame mainFrame = new JFrame("Welcome to Diffusion");

        //contentPane here is the base for the CardLayout, for which other JPanels will be added.
        JPanel contentPane = new JPanel();
//        Container contentPane = mainFrame.getContentPane();
        contentPane.setLayout(new CardLayout(20, 30));

        //Create an object of each of the various screens that will be added to the contentpane JPanel as
        //a new card.
        HomeScreen homeScreen = new HomeScreen();

        /*
        Create a buttonPanel
         */
        JPanel buttonPanel = new JPanel();

        /*
        Create buttons login and registration to add to buttonPanel.
         */
        JButton login = new JButton("Login");
        JButton registration = new JButton("Registration");


        /*
        Add buttons login and registration to buttonPanel
         */
        buttonPanel.add(login);
        buttonPanel.add(registration);

        /*
        Note the Below will add the button panel to the HomeScreen panel directly. Look for Ref - 1 below where
        buttonPanel is added to the mainFrame contentPane instead.
         */
        homeScreen.add(buttonPanel);

        /*
        Adds the homeScreen to the contentPane.
         */
        contentPane.add(homeScreen, "Home Screen");

        /*
        The usecase engine construction has been outsourced to the UserRegistrationHelper to clean up the
        mainFrame.
         */
//        /*
//        Use Case engine below, setting up the database plugging in input object into the interactor and returning
//        the output object to be injected into the view by the presenter.
//         */
//
//        /*
//        Database construction below
//         */
//        UserRegistrationDsGateway userRegistrationDsGateway;
//        try{
//            userRegistrationDsGateway = new UserRegistrationRecorder("./RegistrationList3.csv");
//
//        } catch (IOException e) {
//            throw new RuntimeException("Can't create file.");
//        }
//
//        UserRegistrationPresenter userRegistrationOutputBoundary = new UserRegistrationPresenter();
//        UserRegistrationGenerator userRegistrationGenerator = new CommonUserRegistrationFactory();
//
//        /*
//        Plugging parts into the interactor.
//         */
//        UserRegistrationInteractor userRegistrationInteractor = new UserRegistrationInteractor(userRegistrationDsGateway,
//                userRegistrationOutputBoundary, userRegistrationGenerator);
//
//        /*
//        Plugging the interactor into the Controller.
//         */
//        UserRegistrationController userRegistrationController = new UserRegistrationController(userRegistrationInteractor);
//
//        /*
//        Creating the screen
//         */
//        UserRegistrationScreen userRegistrationScreen = new UserRegistrationScreen(userRegistrationController);
//
//        /*
//        Injects the output data the presenter wants to present by injecting it into the GUI.
//         */
//        userRegistrationOutputBoundary.setView(userRegistrationScreen);

        /*
        Using a helper for the use case engine setup and creating the screens
         */
        UserRegistrationHelper userRegistrationHelper = new UserRegistrationHelper();

        UserLogInHelper userLogInHelper = new UserLogInHelper();
        /*
        Adding the screen to the mainframe container, contentpane,  and naming it as well.
         */
//        contentPane.add(userRegistrationScreen, "User Registration");
        contentPane.add(userRegistrationHelper.GenerateRegistrationScreen(), "User Registration");
        contentPane.add(userLogInHelper.LogInScreenGenerator(), "User LogIn");

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
                System.out.println("Clicked" + login.getText());
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
