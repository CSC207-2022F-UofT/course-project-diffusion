package receive_request.receive_request_interface_adapters;

import receive_request.receive_request_use_case.ReceiveRequestInputBoundary;
import receive_request.receive_request_use_case.ReceiveRequestInputModel;
import receive_request.receive_request_use_case.ReceiveRequestOutputModel;

import java.io.FileNotFoundException;

public class ReceiveRequestController {
    ReceiveRequestInputBoundary receiveRequestInputBoundary;

    public ReceiveRequestController(ReceiveRequestInputBoundary receiveRequestGateway) {
        this.receiveRequestInputBoundary = receiveRequestGateway;
    }

    public ReceiveRequestOutputModel checkInventory(String drugName, String drugBottle) throws FileNotFoundException {
        ReceiveRequestInputModel receiveRequestInputModel = new ReceiveRequestInputModel(drugName, drugBottle);
        return receiveRequestInputBoundary.checkInventory(receiveRequestInputModel);
    }
}
