package user_registration.use_case.interactor;

import org.junit.jupiter.api.Test;
import user_registration.entity.CommonUserRegistrationFactory;
import user_registration.frameworks_and_drivers.database_generator.UserRegistrationInMemory;
import user_registration.interface_adapters.UserRegistrationPresenter;
import user_registration.ports.UserRegistrationGenerator;
import user_registration.use_case.database_access.UserRegistrationDsGateway;
import user_registration.use_case.input.UserRegistrationInputBoundary;
import user_registration.use_case.input.UserRegistrationInputData;
import user_registration.use_case.output.UserRegistrationOutputData;

import static org.junit.jupiter.api.Assertions.*;


class UserRegistrationInteractorTest {
    /**
     * Testing the User Registration Use Cas
     */
    @Test
    void createInputObject() {
        UserRegistrationDsGateway userRegistrationRepository = new UserRegistrationInMemory();


        UserRegistrationPresenter presenter = new UserRegistrationPresenter(){
            public UserRegistrationOutputData successView(UserRegistrationOutputData user){
                assertEquals("Fyodor", user.getFirstName());
                assertNotNull(user.getCreationTime());
                assertTrue(userRegistrationRepository.usernameExists("Karamazov"));
                return null;
            }

            public UserRegistrationOutputData prepareFailView(String error){
                fail("User Registration User Case has failed");
                return null;
            }
        };
        UserRegistrationGenerator userRegistrationGenerator = new CommonUserRegistrationFactory();
        UserRegistrationInputBoundary interactor = new UserRegistrationInteractor(userRegistrationRepository, presenter,
                userRegistrationGenerator);

        UserRegistrationInputData inputData = new UserRegistrationInputData("Fyodor", "Dostoevsky",
                "Karamazov", "abcdefg", "Depot1", "Depot User");


        interactor.createInputObject(inputData);
    }
}