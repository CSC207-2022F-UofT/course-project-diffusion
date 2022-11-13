package drug_request_use_case;

import drug_request_entity.CommonDrugRequestGenerator;
import drug_request_entity.DrugRequest;
import drug_request_entity.DrugRequestGenerator;

import java.time.LocalDateTime;

public class DrugRequestInteractor implements DrugRequestInputBoundary {
    //consider making the below final
    final DrugRequestDsGateway drugRequestDsGateway;
    final DrugRequestOutputBoundary drugRequestOutputBoundary;
    final DrugRequestGenerator drugRequestGenerator;

    public DrugRequestInteractor(DrugRequestDsGateway drugRequestDsGateway, DrugRequestOutputBoundary drugRequestOutputBoundary,
                                 DrugRequestGenerator drugRequestGenerator) {
        this.drugRequestDsGateway = drugRequestDsGateway;
        this.drugRequestOutputBoundary = drugRequestOutputBoundary;
        this.drugRequestGenerator = drugRequestGenerator;
    }

    @Override
    public DrugRequestResponseModel create(DrugRequestInvokeModel drugRequestInvokeModel) {
//        if (drugRequestInvokeModel.getDrugBottle() > 99){
//            return drugRequestPresenter.prepareFailView("Order Failed. Bottle quantity exceeds maximum of 99");
//        }

        DrugRequest drugRequest = drugRequestGenerator.create(drugRequestInvokeModel.getDrugName(),
                drugRequestInvokeModel.getDrugBottle());
        if (!drugRequest.drugBottleIsValid()) {
            return drugRequestOutputBoundary.prepareFailView("Bottles ordered must be 1 and 100 (inclusive)");
        } else if (!drugRequest.drugNameIsValid()) {
            return drugRequestOutputBoundary.prepareFailView("Drug name must be alphabetic characters only.");
        }

        LocalDateTime drugRequestDate = LocalDateTime.now();

        DrugRequestDsInvokeModel drugRequestDsModel = new DrugRequestDsInvokeModel(drugRequest.getDrugName(),
                drugRequest.getDrugBottle(), drugRequestDate);
        /*
        Implement the saving feature below
         drugRequestDsGateway.saveDrugRequest(drugRequestDsModel);
         */

        DrugRequestResponseModel drugRequestResponseModel = new DrugRequestResponseModel(drugRequest.getDrugName(),
                drugRequestDate.toString());
        return drugRequestOutputBoundary.prepareSuccessView(drugRequestResponseModel);
    }
}
