package drug_request_interface_adapters;

import drug_request_frameworks_drivers.DrugRequestFailed;
import drug_request_frameworks_drivers.DrugRequestScreen;
import drug_request_use_case.DrugRequestOutputBoundary;
import drug_request_use_case.DrugRequestResponseModel;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class DrugRequestPresenter implements DrugRequestOutputBoundary {
    DrugRequestPresenterOutputBoundary drugRequestPresenterOutputBoundary;
//    public DrugRequestPresenter(){;
//    }
@Override
    public DrugRequestResponseModel prepareSuccessView(DrugRequestResponseModel responseModel) {
        LocalDateTime responseDate = LocalDateTime.parse(responseModel.getCreationTime());
        responseModel.setCreationTime(responseDate.format(DateTimeFormatter.ofPattern("hh:mm:ss")));

//        this.drugRequestPresenterOutputBoundary = responseModel;

//        drugRequestPresenterOutputBoundary = new DrugRequestPresenterOutputBoundary(){
//        };

//        DrugRequestResponseModel drugRequestViewmodel = new DrugRequestViewmodel(responseModel.getDrugName(), responseModel.getDrugBottle(),
//                responseModel.getCreationTime());


//        return drugRequestPresenterOutputBoundary.viewPresenter(responseModel.getDrugName(),
//                responseModel.getDrugBottle(), responseModel.getCreationTime());
//         drugRequestPresenterOutputBoundary.practiceDrugRequestSubmitted();

//         return drugRequestPresenterOutputBoundary.viewPresenter(responseModel);

//        return drugRequestPresenterOutputBoundary.actionPerformed();
//        System.out.println(responseModel.getDrugName());
//        Objects.requireNonNull(responseModel, "Object must not be nuLL");
//        DrugRequestResponseModel responseModel1 = new DrugRequestResponseModel("drug name",
//                "drug bottle", "time");
//        Objects.requireNonNull(responseModel1, "Object must not be nuLL");
        drugRequestPresenterOutputBoundary.viewPresenter(responseModel);

//        BELOWWORKS
//        drugRequestPresenterOutputBoundary.drugRequestSubmitted();

//        drugRequestPresenterOutputBoundary.viewPresenter(responseModel1.getDrugName(), responseModel1.getDrugBottle(), responseModel1.getCreationTime());
//        System.out.println(responseModel.getDrugName());
        return responseModel;
//        System.out.println("PRESENTER METHOD CALLED");

    }
//    public DrugRequestVieMmodel vmcreator(String drugname, String drugbottle, String creationtime){
//        DrugRequestViewmodel drugRequestViewmodel = new DrugRequestViewmodel(drugname, drugbottle, creationtime);
//        return drugRequestViewmodel;
//    }

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

    public void setView(DrugRequestPresenterOutputBoundary view){
    this.drugRequestPresenterOutputBoundary = view;
    }


    @Override
    public DrugRequestResponseModel prepareFailView(String error) {
        throw new DrugRequestFailed(error);
    }
}
