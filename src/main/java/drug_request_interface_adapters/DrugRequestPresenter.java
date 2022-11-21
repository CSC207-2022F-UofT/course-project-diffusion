package drug_request_interface_adapters;

import drug_request_frameworks_drivers.DrugRequestFailed;
import drug_request_frameworks_drivers.DrugRequestScreen;
import drug_request_use_case.DrugRequestOutputBoundary;
import drug_request_use_case.DrugRequestResponseModel;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DrugRequestPresenter implements DrugRequestOutputBoundary {
    DrugRequestPresenterOutputBoundary drugRequestPresenterOutputBoundary;

    @Override
    public DrugRequestResponseModel prepareSuccessView(DrugRequestResponseModel responseModel) {
        LocalDateTime responseDate = LocalDateTime.parse(responseModel.getCreationTime());
        responseModel.setCreationTime(responseDate.format(DateTimeFormatter.ofPattern("hh:mm:ss")));

//        this.drugRequestPresenterOutputBoundary = responseModel;

//        drugRequestPresenterOutputBoundary = new DrugRequestPresenterOutputBoundary(){
//        };
//        new DrugRequestPresenter();
//        return drugRequestPresenterOutputBoundary.drugRequestSubmitted(DrugRequestResponseModel);
        drugRequestPresenterOutputBoundary.practiceDrugRequestSubmitted();
//        drugRequestPresenterOutputBoundary

        return responseModel;
//        return drugRequestPresenterOutputBoundary.drugRequestSubmitted();
//        throw new?
    }

//    public DrugRequestPresenter(DrugRequestPresenterOutputBoundary drugRequestPresenterOutputBoundary){
//        this.drugRequestPresenterOutputBoundary=drugRequestPresenterOutputBoundary;
//    }
//    public void

//    DrugRequestPresenter(DrugRequestPresenterOutputBoundary presenterOutputBoundaryView){
//        drugRequestPresenterOutputBoundary = presenterOutputBoundaryView;
//    }
//    @Override
//    public void drugRequestSubmitted(){
//        drugRequestPresenterOutputBoundary.drugRequestSubmitted();
//    }


    @Override
    public DrugRequestResponseModel prepareFailView(String error) {
        throw new DrugRequestFailed(error);
    }
}
