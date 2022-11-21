package drug_fulfill_use_case;

import java.time.LocalDateTime;

// Use case layer

public class DrugDsRequestModel {

    private final String name;
    private final LocalDateTime creationTime;
    private final Boolean isEmergency;
    private final String BatchNumber;
    private final int IDNumber;

    private int drugBottle;


    public DrugDsRequestModel(String name, int drugBottle, LocalDateTime creationTime, Boolean Emergency) {
        this.name = name;
        this.drugBottle = drugBottle;
        this.creationTime = creationTime;
        this.isEmergency = Emergency;
        this.BatchNumber = "XXX";
        this.IDNumber = 80085;

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




}
