package receive_request.receive_request_entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommonValidRequestTest {
    CommonValidRequest validRequest = new CommonValidRequest("DrugX", "30");

    @Test
    void getNameTestMatch() { assertEquals("DrugX", validRequest.getName()); }

    @Test
    void getNameTestWrongName() {
        assertNotEquals("DrugY", validRequest.getName());
    }

    @Test
    void getNameTestEmpty() { assertNotEquals("", validRequest.getName()); }

    @Test
    void getBottleTestMatch() {
        assertEquals("30", validRequest.getBottle());
    }

    @Test
    void getBottleTestWrongNum() {
        assertNotEquals("0", validRequest.getBottle());
    }

    @Test
    void getBottleTestEmpty() {
        assertNotEquals("", validRequest.getBottle());
    }
}