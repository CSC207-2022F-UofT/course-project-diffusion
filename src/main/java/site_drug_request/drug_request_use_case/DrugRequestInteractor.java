package site_drug_request.drug_request_use_case;

import receive_request.receive_request_interface_adapters.ReceiveRequestController;
import site_drug_request.drug_request_entity.DrugRequest;
import site_drug_request.drug_request_entity.DrugRequestGenerator;

import java.io.FileNotFoundException;
import java.time.LocalDateTime;

public class DrugRequestInteractor implements DrugRequestInputBoundary {
    //consider making the below final
    final DrugRequestDsGateway drugRequestDsGateway;
    final DrugRequestOutputBoundary drugRequestOutputBoundary;
    final DrugRequestGenerator drugRequestGenerator;
    final ReceiveRequestControllerI receiveRequestController;

    public DrugRequestInteractor(DrugRequestDsGateway drugRequestDsGateway, DrugRequestOutputBoundary drugRequestOutputBoundary,
                                 DrugRequestGenerator drugRequestGenerator, ReceiveRequestController receiveRequestController) {
        this.drugRequestDsGateway = drugRequestDsGateway;
        this.drugRequestOutputBoundary = drugRequestOutputBoundary;
        this.drugRequestGenerator = drugRequestGenerator;
        this.receiveRequestController = receiveRequestController;
    }

    @Override
    public DrugRequestResponseModel create(DrugRequestInvokeModel drugRequestInvokeModel) throws FileNotFoundException {
//        if (drugRequestInvokeModel.getDrugBottle() > 99){
//            return drugRequestPresenter.prepareFailView("Order Failed. Bottle quantity exceeds maximum of 99");
//        }

        DrugRequest drugRequest = drugRequestGenerator.create(drugRequestInvokeModel.getDrugName(),
                drugRequestInvokeModel.getDrugBottle());
        boolean nameExist = receiveRequestController.checkInventory(drugRequest.getDrugName(), drugRequest.getDrugBottle()).getNameExist();
        boolean sufficientInventory = receiveRequestController.checkInventory(drugRequest.getDrugName(), drugRequest.getDrugBottle()).getSuffientQauntity();
        if (drugRequest.drugNameIsEmpty()) {
            return drugRequestOutputBoundary.prepareFailView("Drug Name not entered.");
        } else if (!drugRequest.drugNameIsValid()) {
            return drugRequestOutputBoundary.prepareFailView("Drug name must be alphabetic characters only.");
        } else if (drugRequest.drugBottleIsEmpty()) {
            return drugRequestOutputBoundary.prepareFailView("Drug Bottle quantity not entered.");
        } else if (!drugRequest.drugBottleIsNumeric()) {
            return drugRequestOutputBoundary.prepareFailView("Drug Bottles must be numeric characters only");

        } else if (!drugRequest.drugBottleIsValid()) {
            return drugRequestOutputBoundary.prepareFailView("Drug Bottles ordered must be between 1 and 100 (inclusive)");
//        else if (drugRequestDsGateway.drugNameExists(drugRequest.getDrugName())) {
//            return drugRequestOutputBoundary.prepareFailView("Drug name already exists");
        } else if (!nameExist) {
            return drugRequestOutputBoundary.prepareFailView("Drug not found");
        } else if (!sufficientInventory) {
            return drugRequestOutputBoundary.prepareFailView("Insufficient inventory");
        }

        LocalDateTime drugRequestDate = LocalDateTime.now();

        DrugRequestDsInvokeModel drugRequestDsModel = new DrugRequestDsInvokeModel(drugRequest.getDrugName(),
                drugRequest.getDrugBottle(), drugRequestDate);
        drugRequestDsGateway.generateDrugRequest(drugRequestDsModel);
        /*
        Implement the saving feature below
         drugRequestDsGateway.saveDrugRequest(drugRequestDsModel);
         */

        DrugRequestResponseModel drugRequestResponseModel = new DrugRequestResponseModel(drugRequest.getDrugName(),
                drugRequest.getDrugBottle(), drugRequestDate.toString());
//                (drugRequest.getDrugName(),
//                drugRequestDate.toString(), drugRequest.getDrugBottle());
        return drugRequestOutputBoundary.prepareSuccessView(drugRequestResponseModel);
//        return DrugRequestScreen.drugRequestSubmitted();


    }
}
