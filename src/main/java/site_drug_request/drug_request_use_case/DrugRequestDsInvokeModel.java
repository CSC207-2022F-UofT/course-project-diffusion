package site_drug_request.drug_request_use_case;

import java.time.LocalDateTime;

public class DrugRequestDsInvokeModel {
    //consider if it's necessary to use Final or not, is drugName expected to be modified
    private  String drugName;
    private String drugBottle;
    private final LocalDateTime drugRequestCreationTime;

    public DrugRequestDsInvokeModel(String drugName, String drugBottle, LocalDateTime drugRequestCreationTime){
        this.drugName = drugName;
        this.drugBottle = drugBottle;
        this.drugRequestCreationTime = drugRequestCreationTime;
    }

    public String getDrugName(){
        return drugName;
    }

    public String getDrugBottle(){
        return drugBottle;
    }

    public void setDrugName(String drugName){
        this.drugName = drugName;
    }

    public void setDrugBottle(String drugBottle){
        this.drugBottle = drugBottle;
    }

    public LocalDateTime getDrugRequestCreationTime() {
        return drugRequestCreationTime;
    }
}
