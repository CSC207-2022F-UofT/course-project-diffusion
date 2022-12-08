package receive_request.receive_request_use_case;

public interface ReceiveRequestOutputBoundary{
    /**
     * Return the Output Model
     */
    ReceiveRequestOutputModel result(ReceiveRequestOutputModel receiveRequestOutputModel);
}
