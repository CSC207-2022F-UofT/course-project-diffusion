package frameworks_and_drivers.view.frames.user_registration;


import entities.common_user_registration.CommonUserRegistrationFactory;
import frameworks_and_drivers.view.database_access.UserRegistrationRecorder;
import frameworks_and_drivers.view.screens.UserRegistrationScreen;
import interface_adapters.user_registration.UserRegistrationController;
import interface_adapters.user_registration.UserRegistrationPresenter;
import ports.use_case_and_entities.UserRegistrationGenerator;
import usecases.user_registration.database_access.UserRegistrationDsGateway;
import usecases.user_registration.interactor.UserRegistrationInteractor;
import usecases.user_registration.output.UserRegistrationOutputBoundary;

import javax.swing.*;
import java.io.IOException;

public class UserRegistrationFrame extends JFrame {
    public UserRegistrationFrame(){
        super("Drug Request Example");

        //Before Adding components you now need an appropriate Layout manager
//        setLayout(new CardLayout());

        //Below are the parts for the use case entities engine
        UserRegistrationDsGateway userRegistrationDsGateway;
        try{
            userRegistrationDsGateway = new UserRegistrationRecorder("./Registration1.csv");

        } catch (IOException e) {
            throw new RuntimeException("Can't create file.");
        }

//        UserRegistrationDsGateway userRegistrationDsGateway = null;
        UserRegistrationOutputBoundary userRegistrationOutputBoundary = new UserRegistrationPresenter();
        UserRegistrationGenerator userRegistrationGenerator = new CommonUserRegistrationFactory();
        UserRegistrationInteractor userRegistrationInteractor = new UserRegistrationInteractor(userRegistrationDsGateway,
                userRegistrationOutputBoundary, userRegistrationGenerator);
        UserRegistrationController userRegistrationController = new UserRegistrationController(userRegistrationInteractor);

        //below is the DrugRequestScreen panel which is added to this JFrame Winfow
        UserRegistrationScreen userRegistrationScreen = new UserRegistrationScreen(userRegistrationController);
        add(userRegistrationScreen);

        //below makes the program stop running when you click close
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //below is the size of the JFram
        setSize(600,500);

        //below makes the program visible
        setVisible(true);
    }
}
