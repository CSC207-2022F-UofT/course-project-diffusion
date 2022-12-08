package receive_request.receive_request_use_case;

import receive_request.receive_request_entity.ValidRequest;
import receive_request.receive_request_entity.ValidRequestGenerator;

public class ReceiveRequestInteractor {
    public ReceiveRequestInteractor(ReceiveRequestInputModel drugRequestInputModel) { //change input type to drugRequestInputModel

    }

    public boolean checkInventory(String drugName, String drugBottle){
        ValidRequest validRequest = ValidRequestGenerator.createValidRequest(drugName, drugBottle);
        return validRequest.checkInventory();
    }
}