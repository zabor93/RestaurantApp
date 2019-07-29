package pl.javastart.takeawayapp.order;

public enum OrderStatus {
    NEW,
    INPROGRESS,
    COMPLETE,
    TEST;

    static OrderStatus nextStatus(OrderStatus orderStatus) {
        if (orderStatus == NEW) {
            return INPROGRESS;
        } else if (orderStatus == INPROGRESS) {
            return COMPLETE;
        } else {
            throw new IllegalArgumentException("There is no status for provided value");
        }
    }


}
