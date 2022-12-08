package site_drug_request.drug_request_entity;
//consider removing public
public class CommonDrugRequest implements DrugRequest{
    private final String drugName;
    private final String drugBottle;

    CommonDrugRequest(String drugName, String drugBottle){
        this.drugName = drugName;
        this.drugBottle = drugBottle;
    }


    //Between 1 and 100 bottles inclusive is how many can be ordered in a single request
    @Override
    public boolean drugBottleIsValid() {
        return 0 < Integer.parseInt(drugBottle) && Integer.parseInt(drugBottle) < 101;
    }

    //The entry for Drug Bottles must be only numeric characters between 0-9 inclusive.
    @Override
    public boolean drugBottleIsNumeric() {
//        return drugBottle.matches("[0-9]+");
        return drugBottle.matches("[0-9]+");
    }

    //Checks to see if Drug Bottle field is empty.
    @Override
    public boolean drugBottleIsEmpty(){
        return drugBottle.matches("^$");
    }

    //The drug name entered must be only alphabetic characters with no digits or spaces in between.
    @Override
    public boolean drugNameIsValid() {
        return drugName.matches("[a-zA-Z]+");
    }

    @Override
    public String getDrugName() {
        return drugName;
    }

    //Checks to see if Drug Name field is empty.
    @Override
    public boolean drugNameIsEmpty(){
        return drugName.matches("^$");
    }

    @Override
    public String getDrugBottle() {
        return drugBottle;
    }
}
