package drug_request_entity;
//consider removing public
public class CommonDrugRequest implements DrugRequest{
    private final String drugName;
    private final int drugBottle;

    CommonDrugRequest(String drugName, int drugBottle){
        this.drugName = drugName;
        this.drugBottle = drugBottle;
    }

    @Override
    public boolean drugBottleIsValid() {
        return 1 < drugBottle && drugBottle < 100;
    }

    @Override
    public boolean drugNameIsValid() {
        return false;
    }
    //Looks like drugNameIsValid needs to be checked in the interactor by referencing the database. Not sure

    @Override
    public String getDrugName() {
        return drugName;
    }

    @Override
    public int getDrugBottle() {
        return drugBottle;
    }
}
