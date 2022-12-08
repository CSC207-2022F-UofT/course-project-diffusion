package drug_fulfill.drug_fulfill_depot_inventories;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import drug_fulfill.drug_fulfill_entities.CommonDrugFulfillFactory;
import drug_fulfill.drug_fulfill_entities.DrugFulfillFactory;
import drug_fulfill.drug_fulfill_frameworks_drivers.DrugFulfillResponseFormatter;
import drug_fulfill.drug_fulfill_frameworks_drivers.FileDepotInventoryA;
import drug_fulfill.drug_fulfill_interface_adapters.DrugFulfillController;
import drug_fulfill.drug_fulfill_interface_adapters.DrugFulfillPresenter;
import drug_fulfill.drug_fulfill_use_case.DrugFulfillDsGateway;
import drug_fulfill.drug_fulfill_use_case.DrugFulfillInputBoundary;
import drug_fulfill.drug_fulfill_use_case.DrugFulfillInteractor;

import java.io.IOException;


public class DrugFulfillHelper {
    public DrugFulfillScreen DrugFulfillGenerator() {
        DrugFulfillDsGateway drugFulfillDsGateway;


//        JFrame application = new JFrame("Order Example");
//        CardLayout cardLayout = new CardLayout();
//        JPanel screens = new JPanel(cardLayout);
//        application.add(screens);

        FileDepotInventoryA depot;
        try {
            depot = new FileDepotInventoryA("./depotAInventory.csv");
        } catch (IOException var11) {
            throw new RuntimeException("Could not create file.");
        }
        DrugFulfillPresenter presenter = new DrugFulfillResponseFormatter();
        DrugFulfillFactory orderFactory = new CommonDrugFulfillFactory();
        DrugFulfillInputBoundary interactor = new DrugFulfillInteractor(depot, presenter, orderFactory);
        DrugFulfillController drugRequestController = new DrugFulfillController(interactor);
        DrugFulfillScreen registerScreen = new DrugFulfillScreen(drugRequestController);
//        screens.add(registerScreensterScreen, "welcome");
//        cardLayout.show(screens, "register");
//        application.pack();
//        application.setVisible(true);
        return registerScreen;
    }

}
