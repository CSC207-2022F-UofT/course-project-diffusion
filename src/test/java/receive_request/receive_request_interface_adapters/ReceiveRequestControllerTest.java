package receive_request.receive_request_interface_adapters;

import org.junit.jupiter.api.Test;
import receive_request.recceive_request_frameworks_drivers.ReceiveRequestDatabaseAccessor;
import receive_request.receive_request_use_case.*;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class ReceiveRequestControllerTest {
    ReceiveRequestOutputBoundary outputBoundary = new ReceiveRequestPresenter();
    ReceiveRequestDatabaseAccessorInterface databaseAccessor = new ReceiveRequestDatabaseAccessor();
    ReceiveRequestInputBoundary inputBoundary = new ReceiveRequestInteractor(outputBoundary, databaseAccessor);
    ReceiveRequestController controller = new ReceiveRequestController(inputBoundary);

    @Test
    void checkInventoryTestValid1() throws FileNotFoundException {
        ReceiveRequestOutputModel outputModel = controller.checkInventory("Atorvastatin","20");
        assertTrue(outputModel.getNameExist());
        assertTrue(outputModel.getSufficientQuantity());
    }

    @Test
    void checkInventoryTestValid2() throws FileNotFoundException {
        ReceiveRequestOutputModel outputModel = controller.checkInventory("Levothyroxine","20");
        assertTrue(outputModel.getNameExist());
        assertTrue(outputModel.getSufficientQuantity());
    }

    @Test
    void checkInventoryTest0() throws FileNotFoundException {
        ReceiveRequestOutputModel outputModel = controller.checkInventory("Atorvastatin","0");
        assertTrue(outputModel.getNameExist());
        assertTrue(outputModel.getSufficientQuantity());
    }

    @Test
    void checkInventoryTestUnder() throws FileNotFoundException {
        ReceiveRequestOutputModel outputModel = controller.checkInventory("Levothyroxine","10");
        assertTrue(outputModel.getNameExist());
        assertTrue(outputModel.getSufficientQuantity());
    }

    @Test
    void checkInventoryTestOver() throws FileNotFoundException {
        ReceiveRequestOutputModel outputModel = controller.checkInventory("Atorvastatin","21");
        assertTrue(outputModel.getNameExist());
        assertFalse(outputModel.getSufficientQuantity());
    }

    @Test
    void checkInventoryTestWrongName() throws FileNotFoundException {
        ReceiveRequestOutputModel outputModel = controller.checkInventory("Sleeping pills","20");
        assertFalse(outputModel.getNameExist());
        assertFalse(outputModel.getSufficientQuantity());
    }

    @Test
    void checkInventoryTestWrongNameQuantity() throws FileNotFoundException {
        ReceiveRequestOutputModel outputModel = controller.checkInventory("Sleeping pills","100");
        assertFalse(outputModel.getNameExist());
        assertFalse(outputModel.getSufficientQuantity());
    }
}