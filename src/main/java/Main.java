import drug_fulfill_entities.CommonDrugFulfillFactory;
import drug_fulfill_entities.DrugFulfillFactory;
import drug_fulfill_use_case.DrugFulfillDsGateway;
import drug_fulfill_use_case.DrugFulfillInputBoundary;
import drug_fulfill_use_case.DrugFulfillInteractor;
import drug_fulfill_use_case.DrugRequestPresenter;
import screens.*;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        // Build the main program window
        JFrame application = new JFrame("Order Example");
        CardLayout cardLayout = new CardLayout();
        JPanel screens = new JPanel(cardLayout);
        application.add(screens);

        // Create the parts to plug into the Use Case+Entities engine
        DrugFulfillDsGateway user;
        try {
            user = new FileDepotInventoryA("./depotx.csv");
        } catch (IOException e) {
            throw new RuntimeException("Could not create file.");
        }
        DrugRequestPresenter presenter = new DrugRequestResponseFormatter();
        DrugFulfillFactory orderFactory = new CommonDrugFulfillFactory();
        DrugFulfillInputBoundary interactor = new DrugFulfillInteractor(
                user, presenter, orderFactory);
        DrugRequestController drugRequestController = new DrugRequestController(
                interactor
        );

        // Build the GUI, plugging in the parts
        RegisterScreen registerScreen = new RegisterScreen(drugRequestController);
        screens.add(registerScreen, "welcome");
        cardLayout.show(screens, "register");
        application.pack();
        application.setVisible(true);

        // Unused screens; we'll uncomment this later
        //WelcomeScreen welcomeScreen = new WelcomeScreen();
        //LoginScreen loginScreen = new LoginScreen();
        //LoggedInScreen loggedInScreen = new LoggedInScreen();
        //screens.add(welcomeScreen, "register");
        //screens.add(loginScreen, "login");
        //screens.add(loggedInScreen, "loggedIn");

    }

}