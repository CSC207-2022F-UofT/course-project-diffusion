package site_drug_request.drug_request_frameworks_drivers;

import site_drug_request.drug_request_entity.CommonDrugRequestGenerator;
import site_drug_request.drug_request_entity.DrugRequestGenerator;
import site_drug_request.drug_request_interface_adapters.DrugRequestController;
import site_drug_request.drug_request_interface_adapters.DrugRequestPresenter;
import site_drug_request.drug_request_use_case.DrugRequestDsGateway;
import site_drug_request.drug_request_use_case.DrugRequestInputBoundary;
import site_drug_request.drug_request_use_case.DrugRequestInteractor;

import java.io.IOException;

public class DrugRequestHelper {
    public DrugRequestScreen DrugRequestGenerator() {
        DrugRequestDsGateway drugRequestDsGateway;
        try{
            drugRequestDsGateway = new DrugRequestRecorder("./Test18.csv");

        } catch (IOException e) {
            throw new RuntimeException("Can't create file.");
        }

//        DrugRequestPresenterOutputBoundary drugRequestPresenterOutputBoundary = new DrugRequestViewmodel();
////        DrugRequestScreen drugRequestScreen = new DrugRequestScreen(drugRequestPresenterOutputBoundary);


        DrugRequestPresenter outputBoundary = new DrugRequestPresenter();
        DrugRequestGenerator drugRequestGenerator = new CommonDrugRequestGenerator();
        DrugRequestInputBoundary interactor = new DrugRequestInteractor(drugRequestDsGateway,
                outputBoundary, drugRequestGenerator);
        DrugRequestController drugRequestController = new DrugRequestController(interactor);
//
        //below is the DrugRequestScreen panel which is added to this JFrame Winfow
        DrugRequestScreen drugRequestScreen = new DrugRequestScreen(drugRequestController);
//        DrugRequestPresenterOutputBoundary drugRequestPresenterOutputBoundary = drugRequestScreen;

        outputBoundary.setView(drugRequestScreen);

        return drugRequestScreen;
    }
}
