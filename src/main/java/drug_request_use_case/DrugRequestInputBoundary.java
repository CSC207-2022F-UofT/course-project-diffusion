package drug_request_use_case;

public interface DrugRequestInputBoundary {
    DrugRequestResponseModel create(DrugRequestInvokeModel drugRequestInvokeModel);
}
