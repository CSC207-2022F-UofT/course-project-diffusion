import org.junit.jupiter.api.Test;
import user_login.frameworks_and_drivers.database_generator.UserLoginInMemory;
import user_login.interface_adapters.UserLoginPresenter;
import user_login.ports.UserLoginFactory;
import user_login.use_case.database_access.UserLoginDsGateway;
import user_login.use_case.input.UserLoginInputData;
import user_login.use_case.input.UserloginInputBoundary;
import user_login.use_case.interactor.UserLoginInteractor;
import user_login.use_case.output.UserloginOutputData;
import user_login.user_login_entities.CommonUserloginFactory;

import static org.junit.jupiter.api.Assertions.*;

class UserLoginInteractorTest {

    @Test
    void createInputObject() {

        UserLoginDsGateway repository = new UserLoginInMemory();

        UserLoginPresenter presenter = new UserLoginPresenter(){
            public UserloginOutputData successView(UserloginOutputData user){
                assertEquals("Fyodor", user.getUsername());
                assertEquals("DepotUser", user.getRole());
                assertEquals("Depot1", user.getLocationName());
                assertNotNull(user.getCreationTime());
                assertTrue(repository.usernameExists("Karamazov"));
                assertTrue(repository.passwordExists("abcdefg"));
                return null;
            }
            public UserloginOutputData failVIew(String error){
                fail("user login user case has failed");
                return null;

            }
        };
        UserLoginFactory userLoginFactory = new CommonUserloginFactory();
            UserloginInputBoundary interactor = new UserLoginInteractor(repository, presenter, userLoginFactory);
        UserLoginInputData inputData = new UserLoginInputData("Fyodor", "Dostoevsky");

        interactor.createInputObject(inputData);
        }
    }