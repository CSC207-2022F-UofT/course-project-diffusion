package drug_request_entity;

public class CommonDrugRequestGenerator implements DrugRequestGenerator{

    @Override
    public DrugRequest create(String drugName, String drugBottle) {
        return new CommonDrugRequest(drugName, drugBottle);
    }
}
