package drug_request_interface_adapters;

import drug_request_use_case.DrugRequestResponseModel;

import java.awt.event.ActionEvent;

public interface DrugRequestPresenterOutputBoundary {
    DrugRequestResponseModel viewPresenter (DrugRequestResponseModel drugRequestResponseModel);
//    void drugRequestSubmitted();
//    void practiceDrugRequestSubmitted();
//    void actionPerformed (ActionEvent actionEvent);
}
