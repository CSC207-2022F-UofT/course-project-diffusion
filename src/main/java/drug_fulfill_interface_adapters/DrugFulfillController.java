package drug_fulfill_interface_adapters;

import drug_fulfill_use_case.DrugFulfillInputBoundary;
import drug_fulfill_use_case.DrugFulfillRequestModel;
import drug_fulfill_use_case.DrugFulfillResponseModel;

// Interface adapters layer

public class DrugFulfillController {

    final DrugFulfillInputBoundary userInput;

    public DrugFulfillController(DrugFulfillInputBoundary depotGateway) {
        this.userInput = depotGateway;
    }

    public DrugFulfillResponseModel create(String drug, int bottle, Boolean emergencyToggle) {
        DrugFulfillRequestModel requestModel = new DrugFulfillRequestModel(
                drug, bottle, emergencyToggle);

        return userInput.create(requestModel);
    }
}
