package user_registration.interface_adapters;

import user_registration.use_case.output.UserRegistrationOutputBoundary;
import user_registration.use_case.output.UserRegistrationOutputData;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UserRegistrationPresenter implements UserRegistrationOutputBoundary {
    UserPresenterOutputBoundary userPresenterOutputBoundary;
    @Override
    public UserRegistrationOutputData successView(UserRegistrationOutputData userData) {
        LocalDateTime responseDate = LocalDateTime.parse(userData.getCreationTime());
        userData.setCreationTime(responseDate.format(DateTimeFormatter.ofPattern("hh:mm:ss")));
        userPresenterOutputBoundary.presenterOutput(userData);
        return userData;
    }

    @Override
    public UserRegistrationOutputData failureView(String error) {
        throw new RuntimeException(error);
    }


    public void setView(UserPresenterOutputBoundary presenterOutputBoundary) {
        this.userPresenterOutputBoundary = presenterOutputBoundary;
    }

}
