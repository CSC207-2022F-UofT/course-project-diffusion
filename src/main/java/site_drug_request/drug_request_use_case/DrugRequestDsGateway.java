package site_drug_request.drug_request_use_case;

public interface DrugRequestDsGateway {
    boolean drugNameExists(String identifier);
    void generateDrugRequest(DrugRequestDsInvokeModel drugRequestDsInvokeModel);
}
