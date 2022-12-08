package site_drug_request.drug_request_use_case;

public interface DrugRequestOutputBoundary {
    DrugRequestResponseModel prepareSuccessView (DrugRequestResponseModel used);
    DrugRequestResponseModel prepareFailView (String error);
}
