package receive_request.receive_request_use_case;

import java.io.FileNotFoundException;

public interface ReceiveRequestDatabaseAccessorInterface {
    boolean checkInventory(String drugName, String drugBottle) throws FileNotFoundException;
}
