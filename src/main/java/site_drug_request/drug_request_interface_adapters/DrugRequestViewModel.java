package site_drug_request.drug_request_interface_adapters;


public class DrugRequestViewModel {
    String drugName;
    String drugBottle;
    String creationTime;
    public DrugRequestViewModel(String drugName, String drugBottle, String creationTime){
        this.drugName = drugName;
        this.drugBottle = drugBottle;
        this.creationTime = creationTime;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public String getDrugBottle() {
        return drugBottle;
    }

    public void setDrugBottle(String drugBottle) {
        this.drugBottle = drugBottle;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }

}
