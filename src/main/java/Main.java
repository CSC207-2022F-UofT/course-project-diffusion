import drug_request_entity.CommonDrugRequestGenerator;
import drug_request_entity.DrugRequestGenerator;
import drug_request_frameworks_drivers.DrugRequestScreen;
import drug_request_interface_adapters.DrugRequestController;
import drug_request_interface_adapters.DrugRequestPresenter;
import drug_request_use_case.DrugRequestDsGateway;
import drug_request_use_case.DrugRequestInputBoundary;
import drug_request_use_case.DrugRequestInteractor;
import drug_request_use_case.DrugRequestOutputBoundary;

import javax.swing.*;
import java.awt.*;

public class Main {
    ////    DrugRequestInputBoundary drugRequestInteractor = new DrugRequestInteractor(DrugRequestGenerator, DrugRequestDsGateway)
//    DrugRequestController drugRequestController = new DrugRequestController(interactor)
    public static void main(String[] args) {


        //Purpose of the below is to handle cases where it does not run, as well as cleaning up
        //the main method by outsourcing the JFrame construction to DrugRequestFrame.
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DrugRequestFrame();
            }
        });



//        STARTING FROM THIS LINE, HIGHLIGHT EVERYTHING BELOW, AND UNCOMMENT ONLY ONCE TO SEE IT WORK IN MAIN
//        Make sure the SwingUtilities section is Commented out above.
//        //building the parts which go into the case + Entities engine
//        DrugRequestDsGateway drugRequestDsGateway = null;
//        DrugRequestOutputBoundary outputBoundary = new DrugRequestPresenter();
//        DrugRequestGenerator drugRequestGenerator = new CommonDrugRequestGenerator();
//        DrugRequestInputBoundary interactor = new DrugRequestInteractor(drugRequestDsGateway,
//                outputBoundary, drugRequestGenerator);
//        DrugRequestController drugRequestController = new DrugRequestController(interactor);
//
//
//        //Uncomment the below and comment out the above to see how it works without
//        //MainFrAME
//        //Building the Program Window below
//        JFrame application = new JFrame("Drug Request Example");
//        CardLayout cardLayout = new CardLayout();
//        JPanel screens = new JPanel(cardLayout);
//        application.add(screens);
////
////        //Building the GUI, adding in the parts
//////        DrugRequestDsGateway drugRequestDsGateway;
//////        try
//////        DrugRequestGenerator drugRequestGenerator = new CommonDrugRequestGenerator();
//////        DrugRequestInputBoundary drugRequestInputBoundary = new DrugRequestInteractor(drugRequestDsGateway, drugRequestGenerator);
//////        DrugRequestController drugRequestController = new DrugRequestController(drugRequestInputBoundary);
////
////
//
//        //Below the GUI is built
//        DrugRequestScreen drugRequestScreen = new DrugRequestScreen(drugRequestController);
////
//        screens.add(drugRequestScreen);
//        application.pack();
////
////        //change size below later
//        application.setSize(600, 500);
//        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        application.setVisible(true);

    }
}