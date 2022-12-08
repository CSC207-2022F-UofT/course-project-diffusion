package receive_request.receive_request_use_case;

public interface ReceiveRequestInputBoundary {
    String getName();
    String getBottle();
    void setName(String name);
    void setBottle(String bottle);
}
