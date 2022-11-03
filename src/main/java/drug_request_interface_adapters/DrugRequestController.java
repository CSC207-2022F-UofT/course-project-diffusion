package drug_request_interface_adapters;

import drug_request_use_case.DrugRequestInputBoundary;
import drug_request_use_case.DrugRequestInvokeModel;
import drug_request_use_case.DrugRequestResponseModel;

public class DrugRequestController {
    final DrugRequestInputBoundary drugRequestInputBoundary;

    public DrugRequestController(DrugRequestInputBoundary drugRequestGateway){
        this.drugRequestInputBoundary = drugRequestGateway;
    }

    DrugRequestResponseModel create(String drugName, int drugBottle){
        DrugRequestInvokeModel drugRequestInvokeModel = new DrugRequestInvokeModel(drugName, drugBottle);
        return drugRequestInputBoundary.create(drugRequestInvokeModel);
    }
}
