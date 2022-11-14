package receive_request_use_case;

public class ReceiveRequestInputModel {
    private String drugName;
    private String drugBottle;

    public ReceiveRequestInputModel(String drugName, String drugBottle) {
        this.drugName = drugName;
        this.drugBottle = drugBottle;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public String getDrugBottle() {
        return drugBottle;
    }

    public void setDrugBottle(String drugBottle) {
        this.drugBottle = drugBottle;
    }
}
