package drug_fulfill.drug_fulfill_use_case;

// Use case layer

public class DrugFulfillRequestModel {

    private String drugName;
    private int drugBottle;
    private Boolean isEmergency;
    private String depot;

    public DrugFulfillRequestModel(String name, int drugBottle, Boolean isEmergency, String depot) {
        this.drugName = name;
        this.drugBottle = drugBottle;
        this.isEmergency = isEmergency;
        this.depot = depot;
    }

    String getDrugName() {
        return drugName;
    }

    void setDrugNameName(String name) {
        this.drugName = name;
    }

    int getDrugBottle() {
        return drugBottle;
    }

    void setDrugBottle(int DrugBottle){
        this.drugBottle=DrugBottle;
    }

    void setEmergency(Boolean isEmergency) {
        this.isEmergency = isEmergency;
    }

    public Boolean getIsEmergency() {
        return isEmergency;
    }
}
