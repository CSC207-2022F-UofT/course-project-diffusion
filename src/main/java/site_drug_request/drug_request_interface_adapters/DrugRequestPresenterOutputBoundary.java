package site_drug_request.drug_request_interface_adapters;

import site_drug_request.drug_request_use_case.DrugRequestResponseModel;

public interface DrugRequestPresenterOutputBoundary {
    DrugRequestResponseModel viewPresenter (DrugRequestResponseModel drugRequestResponseModel);
//    void drugRequestSubmitted();
//    void practiceDrugRequestSubmitted();
//    void actionPerformed (ActionEvent actionEvent);
}
