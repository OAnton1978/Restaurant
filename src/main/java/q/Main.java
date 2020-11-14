package q;

public class Main {
    public static void main(String[] args) {
        final Restaurant restaurant = new Restaurant();

        Thread waiter1 = new Thread(restaurant::getOrderR, "Официант1");    //ввод начальных данных для демонстрации
        Thread waiter2 = new Thread(restaurant::getOrderR, "Официант2");
        Thread waiter3 = new Thread(restaurant::getOrderR, "Официант3");
        Thread waiter4 = new Thread(restaurant::getOrderR, "Официант4");
        Thread waiter5 = new Thread(restaurant::getOrderR, "Официант5");

        Thread guest1 = new Thread(restaurant::takeOrderR, "Посетитель1");
        Thread guest2 = new Thread(restaurant::takeOrderR, "Посетитель2");
        Thread guest3 = new Thread(restaurant::takeOrderR, "Посетитель3");
        Thread guest4 = new Thread(restaurant::takeOrderR, "Посетитель4");
        Thread guest5 = new Thread(restaurant::takeOrderR, "Посетитель5");
        try {
            waiter1.start();
            waiter2.start();
            waiter3.start();
            waiter4.start();
            waiter5.start();
            Thread.sleep(5000);

            guest1.start();
            Thread.sleep(2000);
            guest2.start();
            guest3.start();
            Thread.sleep(4000);
            guest4.start();
            guest5.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

