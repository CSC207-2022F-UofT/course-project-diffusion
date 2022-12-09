package drug_fulfill.drug_fulfill_frameworks_drivers;

import drug_fulfill.drug_fulfill_entities.CommonDrugFulfillFactory;
import drug_fulfill.drug_fulfill_entities.DrugFulfillFactory;
import drug_fulfill.drug_fulfill_interface_adapters.DrugFulfillResponseFormatter;
import drug_fulfill.drug_fulfill_interface_adapters.DrugFulfillController;
import drug_fulfill.drug_fulfill_interface_adapters.DrugFulfillPresenter;
import drug_fulfill.drug_fulfill_use_case.DrugFulfillInputBoundary;
import drug_fulfill.drug_fulfill_use_case.DrugFulfillInteractor;

import java.io.IOException;


/**
 * Sets up the use case engine for the Drug Fulfill/Order Screen
 * */
public class DrugFulfillHelper {
    public DrugFulfillScreen DrugFulfillGenerator() {

        FileDepotInventory depot;
        FileSiteInventory site;
        try {
            depot = new FileDepotInventory("./DepotInventory.csv");
            site = new FileSiteInventory("./SiteInventory.csv");
        } catch (IOException var11) {
            throw new RuntimeException("Could not create files.");
        }
        DrugFulfillPresenter presenter = new DrugFulfillResponseFormatter();
        DrugFulfillFactory orderFactory = new CommonDrugFulfillFactory();
        DrugFulfillInputBoundary interactor = new DrugFulfillInteractor(depot, presenter, orderFactory, site);
        DrugFulfillController drugRequestController = new DrugFulfillController(interactor);


        return new DrugFulfillScreen(drugRequestController);
    }

}
