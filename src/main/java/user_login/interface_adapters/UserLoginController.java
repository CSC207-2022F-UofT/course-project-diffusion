package user_login.interface_adapters;

import user_login.use_case.input.UserLoginInputData;
import user_login.use_case.input.UserloginInputBoundary;
import user_login.use_case.output.UserloginOutputData;

public class UserLoginController {
    UserloginInputBoundary userloginInputBoundary;

    public UserLoginController(UserloginInputBoundary userloginInputBoundary) {
        this.userloginInputBoundary = userloginInputBoundary;
    }
    public UserloginOutputData createInputObject(String username, String password){
        UserLoginInputData inputData = new UserLoginInputData(username, password);
        return userloginInputBoundary.createInputObject(inputData);
    }
}
