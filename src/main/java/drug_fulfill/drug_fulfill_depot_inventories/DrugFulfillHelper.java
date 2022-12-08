package drug_fulfill.drug_fulfill_depot_inventories;

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


        return new DrugFulfillScreen(drugRequestController);
    }

}
