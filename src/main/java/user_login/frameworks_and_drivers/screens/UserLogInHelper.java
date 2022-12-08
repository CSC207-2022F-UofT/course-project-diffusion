package user_login.frameworks_and_drivers.screens;

import user_login.frameworks_and_drivers.database_generator.UserLoginRecorder;
import user_login.interface_adapters.UserLoginController;
import user_login.interface_adapters.UserLoginPresenter;
import user_login.ports.UserLoginFactory;
import user_login.use_case.database_access.UserLoginDsGateway;
import user_login.use_case.interactor.UserLoginInteractor;
import user_login.user_login_entities.CommonUserloginFactory;

import java.io.IOException;

/**
 * Sets up the use case engine for the LogIn Screen
 */
public class UserLogInHelper {
    /**
     * plugs in the databsae access, presenter and Entities into the interactor and injects the output
     * as a view using the presenter.
     * @return the screen displaying the view.
     */
    public UserLoginScreen LogInScreenGenerator() {
        UserLoginDsGateway userLoginDsGateway;
        try{
            userLoginDsGateway = new UserLoginRecorder("./UsersRegistered5.csv");
        } catch (IOException e) {
            throw new RuntimeException("Cant generate LoginRequestLog");
        }
        UserLoginPresenter userLoginPresenter = new UserLoginPresenter();
        UserLoginFactory userLoginFactory = new CommonUserloginFactory();
        UserLoginInteractor userLoginInteractor = new UserLoginInteractor(userLoginDsGateway, userLoginPresenter,
                userLoginFactory);
        UserLoginController userLoginController = new UserLoginController(userLoginInteractor);
        UserLoginScreen userLoginScreen = new UserLoginScreen(userLoginController);

        userLoginPresenter.setView(userLoginScreen);

        return userLoginScreen;
    }
}
