package receive_request.receive_request_interface_adapters;

import receive_request.receive_request_use_case.ReceiveRequestInputBoundary;
import receive_request.receive_request_use_case.ReceiveRequestInputModel;
import receive_request.receive_request_use_case.ReceiveRequestOutputModel;
import site_drug_request.drug_request_use_case.ReceiveRequestControllerI;

import java.io.FileNotFoundException;

public class ReceiveRequestController implements ReceiveRequestControllerI {
    ReceiveRequestInputBoundary receiveRequestInputBoundary;

    public ReceiveRequestController(ReceiveRequestInputBoundary receiveRequestGateway) {
        this.receiveRequestInputBoundary = receiveRequestGateway;
    }

    @Override
    public ReceiveRequestOutputModel checkInventory(String drugName, String drugBottle) throws FileNotFoundException {
        ReceiveRequestInputModel receiveRequestInputModel = new ReceiveRequestInputModel(drugName, drugBottle);
        return receiveRequestInputBoundary.checkInventory(receiveRequestInputModel);
    }
}
