package drug_fulfill.drug_fulfill_use_case;

public class SiteFulfillDsInvokeModel {
    private String drugName;
    private int drugBottle;
    private String siteName;

    private Boolean isEmergency;

    public SiteFulfillDsInvokeModel(String drugName, int drugBottle, String siteName, Boolean isEmergency){
        this.drugName = drugName;
        this.drugBottle = drugBottle;
        this.siteName = siteName;
        this.isEmergency = isEmergency;
    }

    String getDrugName(){
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    int getDrugBottle(){
        return drugBottle;
    }

    public void setDrugBottle(int drugBottle) {
        this.drugBottle = drugBottle;
    }

    public void setSiteName(String siteName){
        this.siteName = siteName;
    }

    String getSiteName(){
        return siteName;
    }

    public void setEmergencyToggle(Boolean isEmergency){
        this.isEmergency = isEmergency;
    }

    Boolean getIsEmergency(){
        return isEmergency;
    }
}
