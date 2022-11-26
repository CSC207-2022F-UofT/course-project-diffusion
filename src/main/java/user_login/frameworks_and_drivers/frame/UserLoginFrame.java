package user_login.frameworks_and_drivers.frame;

import user_login.frameworks_and_drivers.database_access.UserLoginRecorder;
import user_login.frameworks_and_drivers.screens.UserLoginScreen;
import user_login.interface_adapters.UserLoginController;
import user_login.interface_adapters.UserLoginPresenter;
import user_login.interface_adapters.UserLoginPresenterOutputBoundary;
import user_login.ports.UserLoginFactory;
import user_login.use_case.database_access.UserLoginDsGateway;
import user_login.use_case.interactor.UserLoginInteractor;
import user_login.user_login_entities.CommonUserloginFactory;

import javax.swing.*;
import java.io.IOException;

public class UserLoginFrame extends JFrame {
    public UserLoginFrame() {
        super("User Login Example");

        UserLoginDsGateway userLoginDsGateway;
        try{
            userLoginDsGateway = new UserLoginRecorder("./LoginRequestLog");
        } catch (IOException e) {
            throw new RuntimeException("Cant generate LoginRequestLog");
        }
        UserLoginPresenter userLoginPresenter = new UserLoginPresenter();
        UserLoginFactory userLoginFactory = new CommonUserloginFactory();
        UserLoginInteractor userLoginInteractor = new UserLoginInteractor(userLoginDsGateway, userLoginPresenter,
                userLoginFactory);
        UserLoginController userLoginController = new UserLoginController(userLoginInteractor);
        UserLoginScreen userLoginScreen = new UserLoginScreen(userLoginController);
        add(userLoginScreen);

        userLoginPresenter.setView(userLoginScreen);

        add(userLoginScreen);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setSize(500, 500);

        setVisible(true);


    }
}
