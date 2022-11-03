import drug_request_entity.DrugRequestGenerator;
import drug_request_frameworks_drivers.DrugRequestScreen;
import drug_request_interface_adapters.DrugRequestController;
import drug_request_use_case.DrugRequestDsGateway;
import drug_request_use_case.DrugRequestInputBoundary;
import drug_request_use_case.DrugRequestInteractor;

public class Main {
//    DrugRequestInputBoundary drugRequestInteractor = new DrugRequestInteractor(DrugRequestGenerator, DrugRequestDsGateway)
    DrugRequestController drugRequestController = new DrugRequestController(interactor)
    public static void main(String[] args) {
        DrugRequestScreen drugRequestScreen = new DrugRequestScreen(drugRequest)
    }
}
