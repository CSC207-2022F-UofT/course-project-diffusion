package drug_request_entity;
//consider removing public
public class CommonDrugRequest implements DrugRequest{
    private final String drugName;
    private final String drugBottle;

    CommonDrugRequest(String drugName, String drugBottle){
        this.drugName = drugName;
        this.drugBottle = drugBottle;
    }

    @Override
    public boolean drugBottleIsValid() {
        return 1 < Integer.parseInt(drugBottle) && Integer.parseInt(drugBottle) < 100;
    }

    @Override
    public boolean drugNameIsValid() {
        return drugName.matches("[a-zA-Z]+");
    }
    //Looks like drugNameIsValid needs to be checked in the interactor by referencing the database. Not sure

    @Override
    public String getDrugName() {
        return drugName;
    }

    @Override
    public String getDrugBottle() {
        return drugBottle;
    }
}
