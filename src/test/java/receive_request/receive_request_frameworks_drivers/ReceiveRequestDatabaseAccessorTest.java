package receive_request.receive_request_frameworks_drivers;

import org.junit.jupiter.api.Test;
import receive_request.recceive_request_frameworks_drivers.ReceiveRequestDatabaseAccessor;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class ReceiveRequestDatabaseAccessorTest {
    ReceiveRequestDatabaseAccessor databaseAccessor = new ReceiveRequestDatabaseAccessor();

    @Test
    void checkInventoryTestValid1() throws FileNotFoundException {
        assertEquals("Sufficient Inventory", databaseAccessor.checkInventory("Atorvastatin","20"));
    }

    @Test
    void checkInventoryTestValid2() throws FileNotFoundException {
        assertEquals("Sufficient Inventory", databaseAccessor.checkInventory("Levothyroxine","20"));
    }

    @Test
    void checkInventoryTest0() throws FileNotFoundException {
        assertEquals("Sufficient Inventory", databaseAccessor.checkInventory("Atorvastatin","0"));
    }

    @Test
    void checkInventoryTestUnder() throws FileNotFoundException {
        assertEquals("Sufficient Inventory", databaseAccessor.checkInventory("Levothyroxine","10"));
    }

    @Test
    void checkInventoryTestOver() throws FileNotFoundException {
        assertEquals("Insufficient Inventory", databaseAccessor.checkInventory("Atorvastatin","21"));
    }

    @Test
    void checkInventoryTestWrongName() throws FileNotFoundException {
        assertEquals("Drug not found", databaseAccessor.checkInventory("Sleeping pills","20"));
    }

    @Test
    void checkInventoryTestWrongNameQuantity() throws FileNotFoundException {
        assertEquals("Drug not found", databaseAccessor.checkInventory("Sleeping pills","100"));
    }
}