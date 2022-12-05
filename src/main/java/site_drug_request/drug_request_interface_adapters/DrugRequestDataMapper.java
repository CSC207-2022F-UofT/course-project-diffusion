package site_drug_request.drug_request_interface_adapters;

import java.time.LocalDateTime;

public class DrugRequestDataMapper {
    String drugName;
    int drugBottle;
    LocalDateTime drugRequestCreationTime;

    public DrugRequestDataMapper(String drugName, int drugBottle, LocalDateTime drugRequestCreationTime){

        this.drugName = drugName;
        this.drugBottle = drugBottle;
        this.drugRequestCreationTime = drugRequestCreationTime;
    }

    public String getDrugName(){
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }
    public int getDrugBottle(){
        return drugBottle;
    }

    public void setDrugBottle(int drugBottle) {
        this.drugBottle = drugBottle;
    }

    public LocalDateTime getDrugRequestCreationTime() {
        return drugRequestCreationTime;
    }

    public void setDrugRequestCreationTime(LocalDateTime drugRequestCreationTime) {
        this.drugRequestCreationTime = drugRequestCreationTime;
    }
}
