package user_login.interface_adapters;

import user_login.use_case.output.UserLoginOutputBoundary;
import user_login.use_case.output.UserloginOutputData;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UserLoginPresenter implements UserLoginOutputBoundary {
    UserLoginPresenterOutputBoundary userLoginPresenterOutputBoundary;
    @Override
    public UserloginOutputData successView(UserloginOutputData userloginOutputData) {
        LocalDateTime responseDate = LocalDateTime.parse(userloginOutputData.getCreationTime());
        userloginOutputData.setCreationTime(responseDate.format(DateTimeFormatter.ofPattern("hh:mm:ss")));
        userLoginPresenterOutputBoundary.presenterOutput(userloginOutputData);
        System.out.println(userloginOutputData.getRole());
        return userloginOutputData;
    }

    @Override
    public UserloginOutputData failView(String error) {
        throw new RuntimeException(error);
    }
    public void setView(UserLoginPresenterOutputBoundary presenterOutputBoundary){
        this.userLoginPresenterOutputBoundary = presenterOutputBoundary;
    }
}
