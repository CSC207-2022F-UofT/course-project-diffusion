package receive_request.receive_request_use_case;

import org.junit.jupiter.api.Test;
import receive_request.recceive_request_frameworks_drivers.ReceiveRequestDatabaseAccessor;
import receive_request.receive_request_interface_adapters.ReceiveRequestPresenter;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class ReceiveRequestInteractorTest {
    ReceiveRequestOutputBoundary outputBoundary = new ReceiveRequestPresenter();
    ReceiveRequestDatabaseAccessorI databaseAccessor = new ReceiveRequestDatabaseAccessor();
    ReceiveRequestInputBoundary interactor = new ReceiveRequestInteractor(outputBoundary, databaseAccessor);

    @Test
    void checkInventoryTestValid1() throws FileNotFoundException {
        ReceiveRequestInputModel inputModel = new ReceiveRequestInputModel("DrugA", "20");
        assertTrue(interactor.checkInventory(inputModel).validRequestState);
    }

    @Test
    void checkInventoryTestValid2() throws FileNotFoundException {
        ReceiveRequestInputModel inputModel = new ReceiveRequestInputModel("DrugB", "20");
        assertTrue(interactor.checkInventory(inputModel).validRequestState);
    }

    @Test
    void checkInventoryTest0() throws FileNotFoundException {
        ReceiveRequestInputModel inputModel = new ReceiveRequestInputModel("DrugA", "0");
        assertTrue(interactor.checkInventory(inputModel).validRequestState);
    }

    @Test
    void checkInventoryTestUnder() throws FileNotFoundException {
        ReceiveRequestInputModel inputModel = new ReceiveRequestInputModel("DrugA", "10");
        assertTrue(interactor.checkInventory(inputModel).validRequestState);
    }

    @Test
    void checkInventoryTestOver() throws FileNotFoundException {
        ReceiveRequestInputModel inputModel = new ReceiveRequestInputModel("DrugA", "21");
        assertFalse(interactor.checkInventory(inputModel).validRequestState);
    }

    @Test
    void checkInventoryTestWrongName() throws FileNotFoundException {
        ReceiveRequestInputModel inputModel = new ReceiveRequestInputModel("DrugD", "20");
        assertFalse(interactor.checkInventory(inputModel).validRequestState);
    }

    @Test
    void checkInventoryTestWrongNameQuantity() throws FileNotFoundException {
        ReceiveRequestInputModel inputModel = new ReceiveRequestInputModel("DrugD", "100");
        assertFalse(interactor.checkInventory(inputModel).validRequestState);
    }
}