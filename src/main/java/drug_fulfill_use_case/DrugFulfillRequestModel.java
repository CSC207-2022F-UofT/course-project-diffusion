package drug_fulfill_use_case;

// Use case layer

public class DrugFulfillRequestModel {

    private String drugName;
    private int drugBottle;
    private Boolean isEmergency;

    public DrugFulfillRequestModel(String name, int drugBottle, Boolean isEmergency) {
        this.drugName = name;
        this.drugBottle = drugBottle;
        this.isEmergency = isEmergency;
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
