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
    public UserloginOutputData createInputObject(UserLoginInputData userloginPOJO) {
        UserLogin userLoginRequest = userLoginFactory.createUser(userloginPOJO.getUsername(),
                userloginPOJO.getPassword());
        if (!userLoginRequest.usernameIsValid()) {
            return userLoginOutputBoundary.failView("Username is invalid");
        } else if (!userLoginRequest.passwordIsValid()) {
            return userLoginOutputBoundary.failView("Password is invalid");
        } else if (!userLoginDsGateway.usernameExists(userloginPOJO.getUsername())){
            return userLoginOutputBoundary.failView("Username is incorrect");
        } else if (!userLoginDsGateway.passwordExists(userloginPOJO.getPassword())){
            return userLoginOutputBoundary.failView("Password is incorrect");
        }
        LocalDateTime userLoginRequestTime = LocalDateTime.now();

        UserLoginDsInputData loginDsInputData = new UserLoginDsInputData(userLoginRequest.getUsername(),
                userLoginRequest.getPassword(), userLoginRequestTime);
//        userLoginDsGateway.saveUserLogin(loginDsInputData);

        /*
        Retrieve the role of the user from the database.
         */
        String role = userLoginDsGateway.userRole(userloginPOJO.getUsername());
        String locationName = userLoginDsGateway.locationName(userloginPOJO.getUsername());

        /*
        Create the return object
         */
        UserloginOutputData  userloginOutputData = new UserloginOutputData(userloginPOJO.getUsername(),
                userLoginRequestTime.toString(), role, locationName);

        /*
        Return out if successful
         */
        return userLoginOutputBoundary.successView(userloginOutputData);

    }
}

