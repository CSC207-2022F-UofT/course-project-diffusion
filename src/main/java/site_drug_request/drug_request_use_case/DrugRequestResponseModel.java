package site_drug_request.drug_request_use_case;

import java.time.LocalDateTime;

public class DrugRequestResponseModel{

    String drugName;
    String drugBottle;
    String creationTime;

    public DrugRequestResponseModel(String drugName, String drugBottle, String creationTime){
        this.drugName = drugName;
        this.creationTime = creationTime;
        this.drugBottle = drugBottle;


    }

    public String getDrugName(){
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public String getDrugBottle(){
        return drugBottle;
    }

    public void setDrugBottle(String drugBottle) {
        this.drugBottle = drugBottle;
    }

    public String getCreationTime(){
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }
}
