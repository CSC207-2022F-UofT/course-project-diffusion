package site_drug_request.drug_request_use_case;

import receive_request.receive_request_use_case.ReceiveRequestOutputModel;

import java.io.FileNotFoundException;

public interface ReceiveRequestControllerI {
    ReceiveRequestOutputModel checkInventory(String drugName, String drugBottle) throws FileNotFoundException;
}
