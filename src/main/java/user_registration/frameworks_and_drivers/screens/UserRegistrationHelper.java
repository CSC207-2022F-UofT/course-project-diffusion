package user_registration.frameworks_and_drivers.screens;

import user_registration.entity.CommonUserRegistrationFactory;
import user_registration.frameworks_and_drivers.database_generator.UserRegistrationRecorder;
import user_registration.interface_adapters.UserRegistrationController;
import user_registration.interface_adapters.UserRegistrationPresenter;
import user_registration.ports.UserRegistrationGenerator;
import user_registration.use_case.database_access.UserRegistrationDsGateway;
import user_registration.use_case.interactor.UserRegistrationInteractor;

import java.io.IOException;

/**
 *
 */
public class UserRegistrationHelper {
    public UserRegistrationScreen GenerateRegistrationScreen() {
         /*
        Use Case engine below, setting up the database plugging in input object into the interactor and returning
        the output object to be injected into the view by the presenter.
         */

        /*
        Database construction below
         */
        UserRegistrationDsGateway userRegistrationDsGateway;
        System.out.println("construct the database");
        try{
            userRegistrationDsGateway = new UserRegistrationRecorder("./UserRegistrationLog.csv");

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Can't create file.");
        }

        UserRegistrationPresenter userRegistrationOutputBoundary = new UserRegistrationPresenter();
        UserRegistrationGenerator userRegistrationGenerator = new CommonUserRegistrationFactory();

        /*
        Plugging parts into the interactor.
         */
        UserRegistrationInteractor userRegistrationInteractor = new UserRegistrationInteractor(userRegistrationDsGateway,
                userRegistrationOutputBoundary, userRegistrationGenerator);

        /*
        Plugging the interactor into the Controller.
         */
        UserRegistrationController userRegistrationController = new UserRegistrationController(userRegistrationInteractor);

        /*
        Creating the screen
         */
        UserRegistrationScreen userRegistrationScreen = new UserRegistrationScreen(userRegistrationController);

        /*
        Injects the output data the presenter wants to present by injecting it into the GUI.
         */
        userRegistrationOutputBoundary.setView(userRegistrationScreen);
        return userRegistrationScreen;
    }
}
