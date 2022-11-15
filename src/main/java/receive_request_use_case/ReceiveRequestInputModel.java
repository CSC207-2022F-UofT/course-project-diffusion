package receive_request_use_case;

public class ReceiveRequestInputModel {
    private String drugName;
    private String drugBottle;

    public ReceiveRequestInputModel(String drugName, String drugBottle) {
        this.drugName = drugName;
        this.drugBottle = drugBottle;
    }

    public String getName() {
        return drugName;
    }

    public String getBottle() {
        return drugBottle;
    }

    public void setName(String drugName) {
        this.drugName = drugName;
    }

    public void setBottle(String drugBottle) {
        this.drugBottle = drugBottle;
    }
}
