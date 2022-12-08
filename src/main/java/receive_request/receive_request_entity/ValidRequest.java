package receive_request.receive_request_entity;

import java.io.FileNotFoundException;

public interface ValidRequest {
    boolean checkInventory() throws FileNotFoundException;
    String getName();
    String getBottle();
}