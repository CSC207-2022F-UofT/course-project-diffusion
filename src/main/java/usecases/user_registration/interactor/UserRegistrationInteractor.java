package usecases.user_registration.interactor;

import ports.use_case_and_entities.UserRegistration;
import ports.use_case_and_entities.UserRegistrationGenerator;
import usecases.user_registration.database_access.UserRegistrationDsGateway;
import usecases.user_registration.database_access.UserRegistrationInputData;
import usecases.user_registration.input.UserRegistrationInputBoundary;
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

    @Override
    public UserRegistrationOutputData createInputObject(usecases.user_registration.input.UserRegistrationInputData userPOJO) {
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
        }
        LocalDateTime registrationDateTime = LocalDateTime.now();

        /**
         * Output for Database
         */
        UserRegistrationInputData dsInputData = new UserRegistrationInputData(userRequest.getFirstName(),
                userRequest.getLastName(), userRequest.getUsername(), userRequest.getPassword(), registrationDateTime);


        UserRegistrationOutputData registrationOutputData = new UserRegistrationOutputData(userRequest.getFirstName(),
                userRequest.getLastName(), userRequest.getUsername(), registrationDateTime.toString());
        return userRegistrationOutputBoundary.successView(registrationOutputData);
    }
}
