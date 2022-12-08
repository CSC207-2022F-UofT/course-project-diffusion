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
        assertFalse(outputModel.getSuffientQauntity());
    }

    @Test
    void setNameExistTrueTest() {
        outputModel.setNameExistTrue();
        assertTrue(outputModel.nameExist);
        assertTrue(outputModel.getNameExist());
    }

    @Test
    void setSuffientQauntityTrue() {
        outputModel.setSuffientQauntityTrue();
        assertTrue(outputModel.suffientQauntity);
        assertTrue(outputModel.getSuffientQauntity());
    }

    @Test
    void setBothTrue() {
        outputModel.setNameExistTrue();
        outputModel.setSuffientQauntityTrue();
        assertTrue(outputModel.nameExist);
        assertTrue(outputModel.getNameExist());
        assertTrue(outputModel.suffientQauntity);
        assertTrue(outputModel.getSuffientQauntity());
    }
}