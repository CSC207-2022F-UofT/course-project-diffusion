package receive_request.receive_request_interface_adapters;

import receive_request.receive_request_use_case.ReceiveRequestOutputBoundary;
import receive_request.receive_request_use_case.ReceiveRequestOutputModel;

public class ReceiveRequestPresenter implements ReceiveRequestOutputBoundary {
    /**
     * {@inheritDoc}
     */
    @Override
    public ReceiveRequestOutputModel result(ReceiveRequestOutputModel receiveRequestOutputModel) {
        return receiveRequestOutputModel;
    }
}
