package user_registration.use_case.interactor;

import user_registration.ports.UserRegistration;
import user_registration.ports.UserRegistrationGenerator;
import user_registration.use_case.database_access.UserRegistrationDsGateway;
import user_registration.use_case.database_access.UserRegistrationDsInputData;
import user_registration.use_case.input.UserRegistrationInputBoundary;
import user_registration.use_case.input.UserRegistrationInputData;
import user_registration.use_case.output.UserRegistrationOutputBoundary;
import user_registration.use_case.output.UserRegistrationOutputData;

import java.time.LocalDateTime;

public class UserRegistrationInteractor implements UserRegistrationInputBoundary {
    final UserRegistrationDsGateway userRegistrationDsGateway;
    final UserRegistrationOutputBoundary userRegistrationOutputBoundary;
    final UserRegistrationGenerator userRegistrationGenerator;

    public UserRegistrationInteractor(UserRegistrationDsGateway userRegistrationDsGateway,
                                      UserRegistrationOutputBoundary userRegistrationOutputBoundary, UserRegistrationGenerator userRegistrationGenerator) {
        this.userRegistrationDsGateway = userRegistrationDsGateway;
        this.userRegistrationOutputBoundary = userRegistrationOutputBoundary;
        this.userRegistrationGenerator = userRegistrationGenerator;
    }

    @Override
    public UserRegistrationOutputData createInputObject(UserRegistrationInputData userPOJO) {
        UserRegistration userRequest = userRegistrationGenerator.createUser(userPOJO.getFirstName(),
                userPOJO.getLastName(), userPOJO.getUserame(), userPOJO.getPassword());
        if (!userRequest.firstNameIsValid()) {
            return userRegistrationOutputBoundary.failureView("Firstname is invalid ");
        } else if (!userRequest.lastNameIsValid()) {
            return userRegistrationOutputBoundary.failureView("Lastname is invalid ");
        } else if (!userRequest.userNameisValid()) {
            return userRegistrationOutputBoundary.failureView("Username is invalid ");
        } else if (!userRequest.passwordIsValid()) {
            return userRegistrationOutputBoundary.failureView("Password is invalid ");
        } else if (userRegistrationDsGateway.usernameExists(userPOJO.getUserame())){
            return userRegistrationOutputBoundary.failureView("Username already exists");
        }
        LocalDateTime registrationDateTime = LocalDateTime.now();

        /**
         * Output for Database
         */
        UserRegistrationDsInputData dsInputData = new UserRegistrationDsInputData(userPOJO.getFirstName(),
                userRequest.getLastName(), userRequest.getUsername(), userRequest.getPassword(), userPOJO.getLocationName(),
                userPOJO.getRole(), registrationDateTime);
        userRegistrationDsGateway.saveUserRegistration(dsInputData);

        UserRegistrationOutputData registrationOutputData = new UserRegistrationOutputData(userRequest.getFirstName(),
                userRequest.getLastName(), userRequest.getUsername(), registrationDateTime.toString());
        return userRegistrationOutputBoundary.successView(registrationOutputData);
    }
}