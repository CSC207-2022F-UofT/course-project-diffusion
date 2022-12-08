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

/**
 * Interactor class implements the UserRegistrationInputBoundary and allows for checks to carried out on the input
 * data using the entities business rules and can also send the data to the database if successfully passes all
 * tests.
 */
public class UserRegistrationInteractor implements UserRegistrationInputBoundary {
    final UserRegistrationDsGateway userRegistrationDsGateway;
    final UserRegistrationOutputBoundary userRegistrationOutputBoundary;
    final UserRegistrationGenerator userRegistrationGenerator;

    public UserRegistrationInteractor(UserRegistrationDsGateway userRegistrationDsGateway,
                                      UserRegistrationOutputBoundary userRegistrationOutputBoundary,
                                      UserRegistrationGenerator userRegistrationGenerator) {
        this.userRegistrationDsGateway = userRegistrationDsGateway;
        this.userRegistrationOutputBoundary = userRegistrationOutputBoundary;
        this.userRegistrationGenerator = userRegistrationGenerator;
    }

    /**
     *
     * @param registrationInputData - the input data from the controller
     * @return failure view if a business rules is failed, or the success view with the order if the drug request is
     * successful.
     */
    @Override
    public UserRegistrationOutputData createInputObject(UserRegistrationInputData registrationInputData) {
        UserRegistration userRequest = userRegistrationGenerator.createUser(registrationInputData.getFirstName(),
                registrationInputData.getLastName(), registrationInputData.getUserame(), registrationInputData.getPassword());
        if (!userRequest.firstNameIsValid()) {
            return userRegistrationOutputBoundary.failureView("Firstname is invalid ");
        } else if (!userRequest.lastNameIsValid()) {
            return userRegistrationOutputBoundary.failureView("Lastname is invalid ");
        } else if (!userRequest.userNameIsValid()) {
            return userRegistrationOutputBoundary.failureView("Username is invalid ");
        } else if (!userRequest.passwordIsValid()) {
            return userRegistrationOutputBoundary.failureView("Password is invalid ");
        } else if (userRegistrationDsGateway.usernameExists(registrationInputData.getUserame())){
            return userRegistrationOutputBoundary.failureView("Username already exists");
        }
        LocalDateTime registrationDateTime = LocalDateTime.now();

        /*
         * Output for Database to save the drug request
         */
        UserRegistrationDsInputData dsInputData = new UserRegistrationDsInputData(registrationInputData.getFirstName(),
                userRequest.getLastName(), userRequest.getUsername(), userRequest.getPassword(),
                registrationInputData.getLocationName(),
                registrationInputData.getRole(), registrationDateTime);
        userRegistrationDsGateway.saveUserRegistration(dsInputData);

        /*
         *Output data from the interactor sent to the presenter.
         */
        UserRegistrationOutputData registrationOutputData = new UserRegistrationOutputData(userRequest.getFirstName(),
                userRequest.getLastName(), userRequest.getUsername(), registrationDateTime.toString());
        return userRegistrationOutputBoundary.successView(registrationOutputData);
    }
}