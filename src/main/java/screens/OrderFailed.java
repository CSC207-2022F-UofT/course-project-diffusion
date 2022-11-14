package screens;

public class OrderFailed extends RuntimeException {
    public OrderFailed(String error) {
        super(error);
    }
}
