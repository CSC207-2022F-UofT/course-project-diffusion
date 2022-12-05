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

public class DrugRequestFrame extends JFrame {
    public DrugRequestFrame() {
        super("Drug Request Example");

        //Before Adding components you now need an appropriate Layout manager
//        setLayout(new CardLayout());

        //Below are the parts for the use case entities engine
        DrugRequestDsGateway drugRequestDsGateway = null;
        DrugRequestOutputBoundary outputBoundary = new DrugRequestPresenter();
        DrugRequestGenerator drugRequestGenerator = new CommonDrugRequestGenerator();
        DrugRequestInputBoundary interactor = new DrugRequestInteractor(drugRequestDsGateway,
                outputBoundary, drugRequestGenerator);
        DrugRequestController drugRequestController = new DrugRequestController(interactor);

        //below is the DrugRequestScreen panel which is added to this JFrame Winfow
        DrugRequestScreen drugRequestScreen = new DrugRequestScreen(drugRequestController);
        add(drugRequestScreen);

        //below makes the program stop running when you click close
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //below is the size of the JFram
        setSize(600,500);

        //below makes the program visible
        setVisible(true);
    }
}
