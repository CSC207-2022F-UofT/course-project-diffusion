package receive_request.receive_request_entity;

import drug_search.use_case.DrugRequestDBEntry;

public interface ValidRequestGenerator {
    /**
     * Create a validRequest object
     *
     * @param drugName is the name of the drug
     * @param drugBottle is the quantity
     */
    static CommonValidRequest createValidRequest(String drugName, String drugBottle) {
        return new CommonValidRequest(drugName, drugBottle);
    }
}