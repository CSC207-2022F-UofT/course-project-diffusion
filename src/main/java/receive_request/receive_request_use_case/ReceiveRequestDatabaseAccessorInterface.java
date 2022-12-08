package receive_request.receive_request_use_case;

import java.io.FileNotFoundException;

public interface ReceiveRequestDatabaseAccessorInterface {
    /**
     * Check if inventory of the depot has enough quantity of the requested drug.
     *
     * @param drugName is the name of the drug
     * @param drugBottle is the quantity
     */
    String checkInventory(String drugName, String drugBottle) throws FileNotFoundException;
}
