package drug_fulfill.drug_fulfill_interface_adapters;

import drug_fulfill.drug_fulfill_use_case.DrugFulfillInputBoundary;
import drug_fulfill.drug_fulfill_use_case.DrugFulfillResponseModel;
import drug_fulfill.drug_fulfill_use_case.DrugFulfillRequestModel;

// Interface adapters layer

public class DrugFulfillController {

    final DrugFulfillInputBoundary userInput;

    public DrugFulfillController(DrugFulfillInputBoundary depotGateway) {
        this.userInput = depotGateway;
    }

    public DrugFulfillResponseModel create(String drug, int bottle, Boolean emergencyToggle, String depot) {
        DrugFulfillRequestModel requestModel = new DrugFulfillRequestModel(
                drug, bottle, emergencyToggle, depot);

        return userInput.create(requestModel);
    }
}
