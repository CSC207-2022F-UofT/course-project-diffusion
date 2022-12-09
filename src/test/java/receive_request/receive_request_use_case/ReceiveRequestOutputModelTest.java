package receive_request.receive_request_use_case;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReceiveRequestOutputModelTest {
    ReceiveRequestOutputModel outputModel = new ReceiveRequestOutputModel();

    @Test
    void getNameExistTestDefault() {
        assertFalse(outputModel.getNameExist());
    }

    @Test
    void getSuffientQauntityTestDefault() {
        assertFalse(outputModel.getSufficientQuantity());
    }

    @Test
    void setNameExistTrueTest() {
        outputModel.setNameExistTrue();
        assertTrue(outputModel.nameExist);
        assertTrue(outputModel.getNameExist());
    }

    @Test
    void setSuffientQauntityTrue() {
        outputModel.setSufficientQuantityTrue();
        assertTrue(outputModel.sufficientQuantity);
        assertTrue(outputModel.getSufficientQuantity());
    }

    @Test
    void setBothTrue() {
        outputModel.setNameExistTrue();
        outputModel.setSufficientQuantityTrue();
        assertTrue(outputModel.nameExist);
        assertTrue(outputModel.getNameExist());
        assertTrue(outputModel.sufficientQuantity);
        assertTrue(outputModel.getSufficientQuantity());
    }
}