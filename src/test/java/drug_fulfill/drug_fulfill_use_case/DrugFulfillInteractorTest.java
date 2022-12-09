package drug_fulfill.drug_fulfill_use_case;

import drug_fulfill.drug_fulfill_entities.CommonDrugFulfillFactory;
import drug_fulfill.drug_fulfill_interface_adapters.DrugFulfillResponseFormatter;
import drug_fulfill.drug_fulfill_frameworks_drivers.FileDepotInventory;
import drug_fulfill.drug_fulfill_frameworks_drivers.FileSiteInventory;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class DrugFulfillInteractorTest {

    @Test
    void create() {
        DrugFulfillDsGateway depotTestDatabase;
        SiteDrugFulfillDsGateway siteTestDatabase;
        try {
            depotTestDatabase = new FileDepotInventory("./depotAInventoryTestCases.csv");
            siteTestDatabase = new FileSiteInventory("./SiteInventoryTestCases.csv");
        } catch (IOException var11) {
            throw new RuntimeException("Could not create files.");
        }
        DrugFulfillResponseFormatter presenter = new DrugFulfillResponseFormatter(){
            public DrugFulfillResponseModel successView(DrugFulfillResponseModel orderResponse){
                assertTrue(depotTestDatabase.depotIsInsufficient(30,"DrugA","Depot1"));
                assertEquals("DrugA", orderResponse.getDrugName());
                assertNotNull(orderResponse.getCreationTime());
                assertEquals("Depot1", orderResponse.getDepotName());
                assertEquals("Site1", orderResponse.getSiteName());
                assertTrue(siteTestDatabase.getMadeOrders().containsKey(orderResponse.getCreationTime()));
                assertTrue(depotTestDatabase.getMadeOrders().containsKey(orderResponse.getCreationTime()));



                //assertTrue(depotTestDatabase.depotIsInsufficient(orderResponse.getDrugBottle(), orderResponse.getDrugName(), orderResponse.getDepotName()));

                return null;
            }
            public DrugFulfillResponseModel prepareFailView(String error) {
                fail("Drug Fulfill Use Case has failed");
                return null;
            }
        };
        CommonDrugFulfillFactory OrderFactory = new CommonDrugFulfillFactory();
        DrugFulfillInputBoundary interactor = new DrugFulfillInteractor(depotTestDatabase, presenter,
                OrderFactory, siteTestDatabase);

        DrugFulfillRequestModel inputData = new DrugFulfillRequestModel("DrugA", 5,
                false, "Depot1", "Site1");

        interactor.create(inputData);
    }
}