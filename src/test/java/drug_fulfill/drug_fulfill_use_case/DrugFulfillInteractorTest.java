package drug_fulfill.drug_fulfill_use_case;

import drug_fulfill.drug_fulfill_entities.CommonDrugFulfillFactory;
import drug_fulfill.drug_fulfill_entities.DrugFulfillFactory;
import drug_fulfill.drug_fulfill_frameworks_drivers.DrugFulfillResponseFormatter;
import drug_fulfill.drug_fulfill_frameworks_drivers.FileDepotInventoryA;
import org.junit.jupiter.api.Test;
import user_registration.entity.CommonUserRegistrationFactory;
import user_registration.ports.UserRegistrationGenerator;
import user_registration.use_case.input.UserRegistrationInputBoundary;
import user_registration.use_case.input.UserRegistrationInputData;
import user_registration.use_case.interactor.UserRegistrationInteractor;
import user_registration.use_case.output.UserRegistrationOutputData;

import java.io.IOException;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class DrugFulfillInteractorTest {

    @Test
    void create() {
        DrugFulfillDsGateway depotTestDatabase;
        try {
            depotTestDatabase = new FileDepotInventoryA("./depotAInventoryTestCases.csv");
        } catch (IOException var11) {
            throw new RuntimeException("Could not create file.");
        }
        DrugFulfillResponseFormatter presenter = new DrugFulfillResponseFormatter(){
            public DrugFulfillResponseModel successView(DrugFulfillResponseModel orderResponse){
                assertEquals("DrugA", orderResponse.getDrugName());
                assertNotNull(orderResponse.getCreationTime());
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
                OrderFactory);

        DrugFulfillRequestModel inputData = new DrugFulfillRequestModel("DrugA", 5,
                false, "Depot1");


        interactor.create(inputData);
    }
}