package drug_fulfill.drug_fulfill_use_case;

// Use case layer

public class DrugFulfillResponseModel {

    private final String drugName;
    private String creationTime;
    private final Boolean isEmergency;
    private final int IDNumber;
    private final String depotName;
    private final String siteName;



    public DrugFulfillResponseModel(String drugName, String creationTime, Boolean isEmergency, int ID, String depot, String site) {
        this.drugName = drugName;
        this.creationTime = creationTime;
        this.isEmergency = isEmergency;
        this.IDNumber = ID;
        this.depotName = depot;
        this.siteName = site;
    }

    public String getDrugName() {
        return drugName;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public String getDepotName(){
        return depotName;
    }
    public void setCreationTime(String creationTime){
        this.creationTime = creationTime;
    }
    public String getSiteName(){return siteName;}
}
