package receive_request.receive_request_use_case;

import java.io.FileNotFoundException;

public interface ReceiveRequestInputBoundary {
    /**
     * Use ReceiveRequestDatabaseAccessor to check if inventory of the depot has enough quantity of the requested drug.
     */
    ReceiveRequestOutputModel checkInventory(ReceiveRequestInputModel receiveRequestInputModel) throws FileNotFoundException;
}
