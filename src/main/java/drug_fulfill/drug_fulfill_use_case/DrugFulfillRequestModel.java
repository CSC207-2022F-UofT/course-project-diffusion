package drug_fulfill.drug_fulfill_use_case;

// Use case layer

/**
 * Input Data from controller
 */
public class DrugFulfillRequestModel {

    private final String drugName;
    private int drugBottle;
    private final Boolean isEmergency;
    private final String depot;
    private final String site;

    /**
     * @param name name of the Drug in the order
     * @param drugBottle amount of drugs in the order
     * @param isEmergency Whether the drug order is an emergency
     * @param depot the depot the order is coming from
     * @param site the site the order is going to
     */
    public DrugFulfillRequestModel(String name, int drugBottle, Boolean isEmergency, String depot, String site) {
        this.drugName = name;
        this.drugBottle = drugBottle;
        this.isEmergency = isEmergency;
        this.depot = depot;
        this.site = site;
    }

    String getDrugName() {
        return drugName;
    }

    int getDrugBottle() {
        return drugBottle;
    }

    void setDrugBottle(int DrugBottle){
        this.drugBottle=DrugBottle;
    }

    public Boolean getIsEmergency() {
        return isEmergency;
    }
    String getDepot(){
        return depot;
    }
    String getSite(){return site;}
}
