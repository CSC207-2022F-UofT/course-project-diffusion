package site_drug_request;

import receive_request.recceive_request_frameworks_drivers.ReceiveRequestDatabaseAccessor;
import receive_request.receive_request_interface_adapters.ReceiveRequestController;
import receive_request.receive_request_interface_adapters.ReceiveRequestPresenter;
import receive_request.receive_request_use_case.ReceiveRequestInputBoundary;
import receive_request.receive_request_use_case.ReceiveRequestInteractor;
import site_drug_request.drug_request_entity.CommonDrugRequestGenerator;
import site_drug_request.drug_request_entity.DrugRequestGenerator;
import site_drug_request.drug_request_frameworks_drivers.DrugRequestRecorder;
import site_drug_request.drug_request_frameworks_drivers.DrugRequestScreen;
import site_drug_request.drug_request_interface_adapters.DrugRequestController;
import site_drug_request.drug_request_interface_adapters.DrugRequestPresenter;
import site_drug_request.drug_request_use_case.DrugRequestDsGateway;
import site_drug_request.drug_request_use_case.DrugRequestInputBoundary;
import site_drug_request.drug_request_use_case.DrugRequestInteractor;

import javax.swing.*;
import java.io.IOException;

public class DrugRequestFrame extends JFrame {
    public DrugRequestFrame() {
        super("Drug Request Example");

        //Before Adding components you now need an appropriate Layout manager
//        setLayout(new CardLayout());

        //Below are the parts for the use case entities engine
        DrugRequestDsGateway drugRequestDsGateway;
        try{
            drugRequestDsGateway = new DrugRequestRecorder("./Test16.csv");

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


        ReceiveRequestPresenter receiveOutputBoundary = new ReceiveRequestPresenter();
        ReceiveRequestDatabaseAccessor receiveDatabaseAccessor = new ReceiveRequestDatabaseAccessor();
        ReceiveRequestInputBoundary receiveInteractor = new ReceiveRequestInteractor(receiveOutputBoundary, receiveDatabaseAccessor);
        ReceiveRequestController receiveController = new ReceiveRequestController(receiveInteractor);
//
        //below is the DrugRequestScreen panel which is added to this JFrame Winfow
        DrugRequestScreen drugRequestScreen = new DrugRequestScreen(drugRequestController);
//        DrugRequestPresenterOutputBoundary drugRequestPresenterOutputBoundary = drugRequestScreen;

        outputBoundary.setView(drugRequestScreen);

        add(drugRequestScreen);

        //below makes the program stop running when you click close
        setDefaultCloseOperation(EXIT_ON_CLOSE);
//
        //below is the size of the JFram
        setSize(600,500);

        //below makes the program visible
        setVisible(true);
    }
}
