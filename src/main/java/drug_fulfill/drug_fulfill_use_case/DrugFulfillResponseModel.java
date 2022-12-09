package drug_fulfill.drug_fulfill_use_case;

// Use case layer

/**
 * Output data from Drug Fulfill Interactor
 */
public class DrugFulfillResponseModel {

    private final String drugName;
    private String creationTime;
    private final String depotName;
    private final String siteName;



    public DrugFulfillResponseModel(String drugName, String creationTime, String depot, String site) {
        this.drugName = drugName;
        this.creationTime = creationTime;
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
