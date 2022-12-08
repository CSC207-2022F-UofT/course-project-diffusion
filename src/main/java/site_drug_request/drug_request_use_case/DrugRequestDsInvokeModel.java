package site_drug_request.drug_request_use_case;

import java.time.LocalDateTime;

public class DrugRequestDsInvokeModel {
    //consider if it's necessary to use Final or not, is drugName expected to be modified
    private final  String drugName;
    private final String drugBottle;
    private final LocalDateTime drugRequestCreationTime;
    private final String siteName;
    private final String accountID;

    public DrugRequestDsInvokeModel(String drugName, String drugBottle, LocalDateTime drugRequestCreationTime,
                                    String siteName, String accountID){
        this.drugName = drugName;
        this.drugBottle = drugBottle;
        this.drugRequestCreationTime = drugRequestCreationTime;
        this.siteName = siteName;
        this.accountID = accountID;
    }

    public String getDrugName(){
        return drugName;
    }

    public String getDrugBottle(){
        return drugBottle;
    }

    public LocalDateTime getDrugRequestCreationTime() {
        return drugRequestCreationTime;
    }
    public String getSiteName() {
        return siteName;
    }
    public String getAccountID() {
        return accountID;
    }
}
