package drug_fulfill.drug_fulfill_entities;

public class CommonDrugFulfill implements DrugFulfill {
    private final String drugName;
    private final int drugBottle;

    private final Boolean isEmergency;
    private final String depotName;
    private final String siteName;
    /**
     *
     * @param drugName of drug being ordered
     * @param drugBottle amount of drug being ordered
     * @param isEmergency boolean of whether the order is an emergency
     * @param depotName name of depot the order is sent from
     * @param siteName name of site the order will be sent to
     */

     CommonDrugFulfill(String drugName, int drugBottle, Boolean isEmergency, String depotName, String siteName){
        this.drugName = drugName;
        this.drugBottle = drugBottle;
        this.isEmergency = isEmergency;
        this.depotName = depotName;
        this.siteName = siteName;

    }

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

    @Override
    public String getSiteName() {
        return siteName;
    }

}
