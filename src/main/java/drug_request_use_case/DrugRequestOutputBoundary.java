package drug_request_use_case;

import drug_request_interface_adapters.DrugRequestViewModel;

public interface DrugRequestOutputBoundary {
    DrugRequestResponseModel prepareSuccessView (DrugRequestResponseModel used);
    DrugRequestResponseModel prepareFailView (String error);
}
