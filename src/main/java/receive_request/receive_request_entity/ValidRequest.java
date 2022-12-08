package receive_request.receive_request_entity;

public interface ValidRequest {
    boolean nameValid();
    boolean bottleValid();
    boolean checkInventory();
    String getName();
    String getBottle();
}