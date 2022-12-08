package site_drug_request.drug_request_frameworks_drivers;

import receive_request.recceive_request_frameworks_drivers.ReceiveRequestDatabaseAccessor;
import receive_request.receive_request_interface_adapters.ReceiveRequestController;
import receive_request.receive_request_interface_adapters.ReceiveRequestPresenter;
import receive_request.receive_request_use_case.ReceiveRequestInputBoundary;
import receive_request.receive_request_use_case.ReceiveRequestInteractor;
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
            drugRequestDsGateway = new DrugRequestRecorder("./Test19.csv");

        } catch (IOException e) {
            throw new RuntimeException("Can't create file.");
        }

//        DrugRequestPresenterOutputBoundary drugRequestPresenterOutputBoundary = new DrugRequestViewmodel();
////        DrugRequestScreen drugRequestScreen = new DrugRequestScreen(drugRequestPresenterOutputBoundary);

        ReceiveRequestDatabaseAccessor receiveDatabaseAccessor = new ReceiveRequestDatabaseAccessor();
        ReceiveRequestPresenter receiveOutputBoundary = new ReceiveRequestPresenter();
        ReceiveRequestInputBoundary receiveInteractor = new ReceiveRequestInteractor(receiveOutputBoundary, receiveDatabaseAccessor);
        ReceiveRequestController receiveController = new ReceiveRequestController(receiveInteractor);

        DrugRequestPresenter outputBoundary = new DrugRequestPresenter();
        DrugRequestGenerator drugRequestGenerator = new CommonDrugRequestGenerator();
        DrugRequestInputBoundary interactor = new DrugRequestInteractor(drugRequestDsGateway,
                outputBoundary, drugRequestGenerator, receiveController);




        DrugRequestController drugRequestController = new DrugRequestController(interactor);
//
        //below is the DrugRequestScreen panel which is added to this JFrame Winfow
        DrugRequestScreen drugRequestScreen = new DrugRequestScreen(drugRequestController);
//        DrugRequestPresenterOutputBoundary drugRequestPresenterOutputBoundary = drugRequestScreen;

        outputBoundary.setView(drugRequestScreen);

        return drugRequestScreen;
    }
}
