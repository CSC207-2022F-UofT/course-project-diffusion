package site_drug_request.drug_request_interface_adapters;

import site_drug_request.drug_request_use_case.DrugRequestInputBoundary;
import site_drug_request.drug_request_use_case.DrugRequestInvokeModel;
import site_drug_request.drug_request_use_case.DrugRequestResponseModel;

public class DrugRequestController {
    DrugRequestInputBoundary drugRequestInputBoundary;

    public DrugRequestController(DrugRequestInputBoundary drugRequestGateway){
        this.drugRequestInputBoundary = drugRequestGateway;
    }

    public DrugRequestResponseModel create(String drugName, String drugBottle){
        DrugRequestInvokeModel drugRequestInvokeModel = new DrugRequestInvokeModel(drugName, drugBottle);
        return drugRequestInputBoundary.create(drugRequestInvokeModel);
//        return null;
    }
}
