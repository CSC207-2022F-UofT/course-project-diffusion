package usecases.user_registration.interactor;

import interface_adapters.user_registration.UserRegistrationController;
import ports.use_case_and_entities.UserRegistration;
import ports.use_case_and_entities.UserRegistrationGenerator;
import usecases.user_registration.database_access.UserRegistrationDsGateway;
import usecases.user_registration.database_access.UserRegistrationDsInputData;
import usecases.user_registration.input.UserRegistrationInputBoundary;
import usecases.user_registration.input.UserRegistrationInputData;
import usecases.user_registration.output.UserRegistrationOutputBoundary;
import usecases.user_registration.output.UserRegistrationOutputData;

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

    String x = "dddddd";
    @Override
    public UserRegistrationOutputData createInputObject(UserRegistrationInputData userPOJO) {
        UserRegistration userRequest = userRegistrationGenerator.createUser(userPOJO.getFirstName(),
                userPOJO.getLastName(), x, userPOJO.getPassword());
        if (!userRequest.firstNameIsValid()) {
            return userRegistrationOutputBoundary.failureView("Firstname is invalid ");
        } else if (!userRequest.lastNameIsValid()) {
            return userRegistrationOutputBoundary.failureView("Lastname is invalid ");
        } else if (!userRequest.userNameisValid()) {
            return userRegistrationOutputBoundary.failureView("Username is invalid ");
        } else if (!userRequest.passwordIsValid()) {
            return userRegistrationOutputBoundary.failureView("Password is invalid ");
        }
        LocalDateTime registrationDateTime = LocalDateTime.now();

        String x = "dddddd";


        /**
         * Output for Database
         */
        UserRegistrationDsInputData dsInputData = new UserRegistrationDsInputData(userRequest.getFirstName(),
                userRequest.getLastName(), userRequest.getUsername(), userRequest.getPassword(), registrationDateTime);
        userRegistrationDsGateway.saveUserRegistration(dsInputData);

//        UserRegistrationDsInputData x = new UserRegistrationDsInputData(String fef, )"dddd";
        UserRegistrationOutputData registrationOutputData = new UserRegistrationOutputData(userRequest.getFirstName(),
                userRequest.getLastName(), userRequest.getUsername(), registrationDateTime.toString());
        return userRegistrationOutputBoundary.successView(registrationOutputData);
    }
}
