package receive_request.receive_request_use_case;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReceiveRequestOutputModelTest {
    ReceiveRequestOutputModel outputModel = new ReceiveRequestOutputModel();

    @Test
    void getValidStateTest1() {
        assertFalse(outputModel.getValidState());
    }

    @Test
    void setValidStateTest1() {
        outputModel.setValidState(true);
        assertTrue(outputModel.validRequestState);
    }

    @Test
    void setValidStateTest2() {
        outputModel.setValidState(false);
        assertFalse(outputModel.validRequestState);
    }
}