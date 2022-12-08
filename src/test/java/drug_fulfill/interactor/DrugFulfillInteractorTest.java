//package drug_fulfill.interactor;
//
//import drug_fulfill.drug_fulfill_entities.CommonDrugFulfillFactory;
//import drug_fulfill.drug_fulfill_entities.DrugFulfill;
//import drug_fulfill.drug_fulfill_entities.DrugFulfillFactory;
//import drug_fulfill.drug_fulfill_frameworks_drivers.DrugFulfillResponseFormatter;
//import drug_fulfill.drug_fulfill_frameworks_drivers.FileDepotInventoryA;
//import drug_fulfill.drug_fulfill_interface_adapters.DrugFulfillPresenter;
//import drug_fulfill.drug_fulfill_use_case.*;
//import drug_fulfill.drug_fulfill_use_case.DrugFulfillInvokeModel;
//import org.junit.jupiter.api.Test;
//import user_registration.entity.CommonUserRegistrationFactory;
//import user_registration.frameworks_and_drivers.database_generator.UserRegistrationInMemory;
//import user_registration.interface_adapters.UserRegistrationPresenter;
//import user_registration.ports.UserRegistrationGenerator;
//import user_registration.use_case.database_generator.UserRegistrationDsGateway;
//import user_registration.use_case.input.UserRegistrationInputBoundary;
//import user_registration.use_case.input.UserRegistrationInputData;
//import user_registration.use_case.output.UserRegistrationOutputData;
//
//import java.io.IOException;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//
//class DrugFulfillInteractorTest {
//    /**
//     * Testing the User Registration Use Case
//     */
//    @Test
//    void createInputObject() {
//        DrugFulfillDsGateway depotTestDatabase;
//        try {
//            depotTestDatabase = new FileDepotInventoryA("./depotAInventoryTestCases.csv");
//        } catch (IOException var11) {
//            throw new RuntimeException("Could not create file.");
//        }
//        //DrugFulfillDsGateway some = new FileDepotInventoryA();
//
//
//        DrugFulfillResponseFormatter FulfillResponseFormatter = new DrugFulfillResponseFormatter(){
//            public DrugFulfillDsRequestModel successView(UserRegistrationOutputData user){
//                assertEquals("Fyodor", user.getFirstName());
//                assertNotNull(user.getCreationTime());
//                assertTrue(depotTestDatabase.wtfsomethignexists("Karamazov"));
//                return null;
//            }
//
//            public orderResponseModel prepareFailView(String error){
//                fail("User Registration User Case has failed");
//                return null;
//            }
//        };
//
//        DrugFulfillFactory DrugFulfillOrder = new CommonDrugFulfillFactory();
//        DrugFulfillInputBoundary interactor = new DrugFulfillInteractor(depotTestDatabase, presenter,
//                DrugFulfillOrder);
//
//        DrugFulfillRequestModel inputDrugOrder = new DrugFulfillRequestModel("DrugA", 10,
//                false, "Depot1");
//
//
//        interactor.create(inputDrugOrder);
//    }
//}
////his output boundary is my presenter
////his "presenter" is my response formatter.
////i think his registration output data is my orderResponseModel. either that or its my orderRequest model.
