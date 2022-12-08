package drug_fulfill.drug_fulfill_use_case;

// Use case layer

public class DrugFulfillResponseModel {

    String drugName;
    String creationTime;

    Boolean isEmergency;


    public DrugFulfillResponseModel(String drugName, String creationTime, Boolean isEmergency) {
        this.drugName = drugName;
        this.creationTime = creationTime;
        this.isEmergency = isEmergency;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String login) {
        this.drugName = login;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }

    public Boolean getIsEmergency() {
        return isEmergency;
    }

    public void setIsEmergency(Boolean isEmergency) {
        this.isEmergency = isEmergency;
    }

}
