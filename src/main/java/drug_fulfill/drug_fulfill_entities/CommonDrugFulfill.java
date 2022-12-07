package drug_fulfill.drug_fulfill_entities;

import java.util.Objects;

public class CommonDrugFulfill implements DrugFulfill {
    private final String drugName;
    private final int drugBottle;

    private final Boolean isEmergency;
    private final String depotName;

    CommonDrugFulfill(String drugName, int drugBottle, Boolean isEmergency, String depotName){
        this.drugName = drugName;
        this.drugBottle = drugBottle;
        this.isEmergency = isEmergency;
        this.depotName = depotName;

    }
    @Override
    public boolean drugBottleIsValid() {
        return 1 < drugBottle && drugBottle < 100;
    }

    @Override
    public boolean drugNameIsValid(String drugName) {
        return !Objects.equals(drugName, "fuck"); //no bad words pls
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

    @Override
    public boolean getIsEmergency(){return isEmergency;}

    @Override
    public String getDepotName() {
        return depotName;
    }
}
