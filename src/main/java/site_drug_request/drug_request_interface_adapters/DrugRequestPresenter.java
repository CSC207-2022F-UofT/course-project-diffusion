package site_drug_request.drug_request_interface_adapters;

import site_drug_request.drug_request_frameworks_drivers.DrugRequestFailed;
import site_drug_request.drug_request_use_case.DrugRequestOutputBoundary;
import site_drug_request.drug_request_use_case.DrugRequestResponseModel;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DrugRequestPresenter implements DrugRequestOutputBoundary {
    DrugRequestPresenterOutputBoundary drugRequestPresenterOutputBoundary;
    //    public DrugRequestPresenter(){;
//    }
    @Override
    public DrugRequestResponseModel prepareSuccessView(DrugRequestResponseModel responseModel) {
        LocalDateTime responseDate = LocalDateTime.parse(responseModel.getCreationTime());
        responseModel.setCreationTime(responseDate.format(DateTimeFormatter.ofPattern("hh:mm:ss")));
        drugRequestPresenterOutputBoundary.viewPresenter(responseModel);
        return responseModel;

    }
    public void setView(DrugRequestPresenterOutputBoundary view){
        this.drugRequestPresenterOutputBoundary = view;
    }


    @Override
    public DrugRequestResponseModel prepareFailView(String error) {
        throw new DrugRequestFailed(error);
    }
}
