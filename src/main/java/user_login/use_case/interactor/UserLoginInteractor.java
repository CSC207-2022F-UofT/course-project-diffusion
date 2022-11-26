package user_login.use_case.interactor;

import user_login.ports.UserLogin;
import user_login.ports.UserLoginFactory;
import user_login.use_case.database_access.UserLoginDsGateway;
import user_login.use_case.database_access.UserLoginDsInputData;
import user_login.use_case.input.UserLoginInputData;
import user_login.use_case.input.UserloginInputBoundary;
import user_login.use_case.output.UserLoginOutputBoundary;
import user_login.use_case.output.UserloginOutputData;

import java.time.LocalDateTime;

public class UserLoginInteractor implements UserloginInputBoundary {
    final UserLoginDsGateway userLoginDsGateway;
    final UserLoginOutputBoundary userLoginOutputBoundary;
    final UserLoginFactory userLoginFactory;

    public UserLoginInteractor(UserLoginDsGateway userLoginDsGateway, UserLoginOutputBoundary userLoginOutputBoundary, UserLoginFactory userLoginFactory) {
        this.userLoginDsGateway = userLoginDsGateway;
        this.userLoginOutputBoundary = userLoginOutputBoundary;
        this.userLoginFactory = userLoginFactory;
    }

    @Override
    public UserloginOutputData createInputObject(UserLoginInputData userloginInputData) {
        UserLogin userLoginRequest = userLoginFactory.createUser(userloginInputData.getUsername(),
                userloginInputData.getPassword());
        if (!userLoginRequest.usernameIsValid()) {
            return userLoginOutputBoundary.failView("Username is invalid");
        } else if (!userLoginRequest.passwordIsValid()) {
            return userLoginOutputBoundary.failView("Password is invalid");
        }
        LocalDateTime userLoginRequestTime = LocalDateTime.now();

        UserLoginDsInputData loginDsInputData = new UserLoginDsInputData(userLoginRequest.getUsername(),
                userLoginRequest.getPassword(), userLoginRequestTime);
        userLoginDsGateway.saveUserLogin(loginDsInputData);

        UserloginOutputData  userloginOutputData= new UserloginOutputData(userLoginRequest.getUsername(),
                userLoginRequestTime.toString());
        return userLoginOutputBoundary.successView(userloginOutputData);

    }
}

