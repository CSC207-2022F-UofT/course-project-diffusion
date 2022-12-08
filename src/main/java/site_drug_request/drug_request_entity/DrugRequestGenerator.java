package site_drug_request.drug_request_entity;

//Reason why create method exists in DrugRequestGenerator is due to the stable abstractions principal (packages that
// are maximally stable should be maximally abstract).
//This also allows us to isolate user creation.
public interface DrugRequestGenerator {
    DrugRequest create(String DrugName, String DrugBottle);
}
