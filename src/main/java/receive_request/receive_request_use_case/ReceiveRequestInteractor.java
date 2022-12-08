package receive_request.receive_request_use_case;

import receive_request.receive_request_entity.ValidRequest;
import receive_request.receive_request_entity.ValidRequestGenerator;

import java.io.FileNotFoundException;

public class ReceiveRequestInteractor implements ReceiveRequestInputBoundary{
    ReceiveRequestOutputBoundary receiveRequestOutputBoundary;
    public ReceiveRequestInteractor(ReceiveRequestOutputBoundary receiveRequestOutputBoundary) {
        this.receiveRequestOutputBoundary = receiveRequestOutputBoundary;

    }

    public ReceiveRequestOutputModel checkInventory(ReceiveRequestInputModel receiveRequestInputModel) throws FileNotFoundException {
        ValidRequest validRequest = ValidRequestGenerator.createValidRequest(receiveRequestInputModel.getName(), receiveRequestInputModel.getBottle());
        ReceiveRequestOutputModel receiveRequestOutputModel = new ReceiveRequestOutputModel();
        if (validRequest.checkInventory()) {
            receiveRequestOutputModel.setValidState(true);
        }
        return receiveRequestOutputBoundary.result(receiveRequestOutputModel);
    }
}