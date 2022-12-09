package receive_request.receive_request_use_case;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReceiveRequestInputModelTest {
    ReceiveRequestInputModel inputModel = new ReceiveRequestInputModel("DrugX", "30");

    @Test
    void getNameTestMatch() {
        assertEquals("DrugX", inputModel.getName());
    }

    @Test
    void getNameTestWrongName() {
        assertNotEquals("DrugY", inputModel.getName());
    }

    @Test
    void getNameTestEmpty() {
        assertNotEquals("", inputModel.getName());
    }

    @Test
    void getBottleTestMatch() {
        assertEquals("30", inputModel.getBottle());
    }

    @Test
    void getBottleTestWrongNum() {
        assertNotEquals("0", inputModel.getBottle());
    }

    @Test
    void getBottleTestEmpty() {
        assertNotEquals("", inputModel.getBottle());
    }
}