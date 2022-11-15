package receive_request_entity;

public interface ValidRequestGenerator {
    static CommonValidRequest createValidRequest(String drugName, String drugBottle) {
        return new CommonValidRequest(drugName, drugBottle);
    }
}
