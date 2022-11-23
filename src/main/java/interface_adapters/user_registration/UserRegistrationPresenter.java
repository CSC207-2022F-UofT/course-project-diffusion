package interface_adapters.user_registration;

import usecases.user_registration.output.UserRegistrationOutputBoundary;
import usecases.user_registration.output.UserRegistrationOutputData;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UserRegistrationPresenter implements UserRegistrationOutputBoundary {
    @Override
    public UserRegistrationOutputData successView(UserRegistrationOutputData userData) {
        LocalDateTime responseDate = LocalDateTime.parse(userData.getCreationTime());
        userData.setCreationTime(responseDate.format(DateTimeFormatter.ofPattern("hh:mm:ss")));
        return userData;
    }

    @Override
    public UserRegistrationOutputData failureView(String error) {
        throw new RuntimeException(error);
    }
}
