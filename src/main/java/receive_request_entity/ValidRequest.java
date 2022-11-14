package receive_request_entity;

public class ValidRequest {
    private String drugName;
    private String drugBottle;

    public ValidRequest(String drugName, String drugBottle) {
        this.drugName = drugName;
        this.drugBottle = drugBottle;
    }

    public boolean nameValid() {
        return true;
    }

    public boolean bottleValid() {
        return true;
    }

    public String getDrugName() {
        return drugName;
    }

    public String getDrugBottle() {
        return drugBottle;
    }
}
