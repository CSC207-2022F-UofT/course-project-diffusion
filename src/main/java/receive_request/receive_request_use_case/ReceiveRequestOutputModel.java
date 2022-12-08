package receive_request.receive_request_use_case;

public class ReceiveRequestOutputModel{
    boolean validRequestState;
    /**
     * The default output is false
     */
    public ReceiveRequestOutputModel() {
        this.validRequestState = false;
    }

    public boolean getValidState() {
        return validRequestState;
    }

    public void setValidState(boolean validRequest) {
        this.validRequestState = validRequest;
    }
}
