package drug_request_use_case;

public interface DrugRequestDsGateway {
    boolean drugNameExists(String identifier);
    void saveDrugRequest(DrugRequestDsInvokeModel drugRequestDsInvokeModel);
}
