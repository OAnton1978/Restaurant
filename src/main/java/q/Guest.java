package q;

public class Guest extends Thread {

    private Restaurant restaurant;

    public Guest(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}

