package drug_fulfill.drug_fulfill_use_case;

// Use case layer

public class DrugFulfillResponseModel {

    private final String drugName;
    private int drugBottle;
    private String creationTime;
    private final Boolean isEmergency;
    private final int IDNumber;
    private final String depotName;



    public DrugFulfillResponseModel(String drugName, String creationTime, Boolean isEmergency, int ID, String depot) {
        this.drugName = drugName;
        this.creationTime = creationTime;
        this.isEmergency = isEmergency;
        this.IDNumber = ID;
        this.depotName = depot;
    }

    public String getDrugName() {
        return drugName;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public Boolean getIsEmergency() {
        return isEmergency;
    }

    public int getIDNumber(){
        return IDNumber;
    }
    public String getDepotName(){
        return depotName;
    }
    public int getDrugBottle(){
        return drugBottle;
    }
    public void setCreationTime(String creationTime){
        this.creationTime = creationTime;
    }
}
