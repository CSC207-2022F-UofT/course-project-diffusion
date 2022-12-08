package drug_fulfill.drug_fulfill_use_case;

import java.time.LocalDateTime;

// Use case layer

/**
 * Generates DsRequestModel, an order, using input data.
 */
public class SiteDrugFulfillDsRequestModel {

    private final String name;
    private int drugBottle;
    private final LocalDateTime creationTime;
    private final Boolean isEmergency;
    private final String BatchNumber;
    private final int IDNumber;
    private final String siteName;


    /**
     * @param name of drug
     * @param drugBottle amount of drug
     * @param creationTime the time this order was created
     * @param Emergency Boolean, true if this order is an emergency
     * @param site the depot this order is being sent to.
     */
    public SiteDrugFulfillDsRequestModel(String name, int drugBottle, LocalDateTime creationTime, Boolean Emergency, String site) {
        this.name = name;
        this.drugBottle = drugBottle;
        this.creationTime = creationTime;
        this.isEmergency = Emergency;
        this.BatchNumber = "XXX";
        this.IDNumber = 80085;
        this.siteName = site;

    }

    public String getName() {
        return name;
    }

    public int getBottle() {
        return drugBottle;
    }

    public void setBottle(int drugBottle) {
        this.drugBottle = drugBottle;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public Boolean getIsEmergency() { return isEmergency;
    }
    public String getBatchNumber(){ return BatchNumber;}
    public int getIDNumber(){return IDNumber;}

    public String getSiteName(){
        return siteName;
    }



}
