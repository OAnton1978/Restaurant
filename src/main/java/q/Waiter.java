package q;

public class Waiter extends Thread {

    private Restaurant restaurant;

    public Waiter(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
