package drug_fulfill.drug_fulfill_use_case;

import drug_fulfill.drug_fulfill_entities.CommonDrugFulfillFactory;
import drug_fulfill.drug_fulfill_frameworks_drivers.DrugFulfillResponseFormatter;
import drug_fulfill.drug_fulfill_frameworks_drivers.FileDepotInventoryA;
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
            depotTestDatabase = new FileDepotInventoryA("./depotAInventoryTestCases.csv");
            siteTestDatabase = new FileSiteInventory("./SiteInventoryTestCases.csv");
        } catch (IOException var11) {
            throw new RuntimeException("Could not create files.");
        }
        DrugFulfillResponseFormatter presenter = new DrugFulfillResponseFormatter(){
            public DrugFulfillResponseModel successView(DrugFulfillResponseModel orderResponse){
                assertEquals("DrugA", orderResponse.getDrugName());
                assertNotNull(orderResponse.getCreationTime());
                assertEquals("Depot1", orderResponse.getDepotName());
                assertEquals("Site1", orderResponse.getSiteName());
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

        int initial_amounts = 20;
        int expected_amounts = initial_amounts - inputData.getDrugBottle();

        interactor.create(inputData);
    }
}