package receive_request.receive_request_use_case;

import java.io.FileNotFoundException;

public interface ReceiveRequestInputBoundary {
    ReceiveRequestOutputModel checkInventory(ReceiveRequestInputModel receiveRequestInputModel) throws FileNotFoundException;
}
