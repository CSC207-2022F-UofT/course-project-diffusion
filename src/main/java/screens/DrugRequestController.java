package screens;

import drug_fulfill_use_case.DrugFulfillInputBoundary;
import drug_fulfill_use_case.DrugFulfillRequestModel;
import drug_fulfill_use_case.EmergencyOrderResponseModel;

// Interface adapters layer

public class DrugRequestController {

    final DrugFulfillInputBoundary userInput;

    public DrugRequestController(DrugFulfillInputBoundary depotGateway) {
        this.userInput = depotGateway;
    }

    EmergencyOrderResponseModel create(String drug, int bottle, Boolean emergencyToggle) {
        DrugFulfillRequestModel requestModel = new DrugFulfillRequestModel(
                drug, bottle, emergencyToggle);

        return userInput.create(requestModel);
    }
}
