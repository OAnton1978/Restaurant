package q;

public class Restaurant {

    Waiter waiter = new Waiter(this);
    Guest guest = new Guest(this);

    public void takeOrderR() {
        synchronized (guest) {
            synchronized (waiter) {
                waiter.notify();
            }
            try {
                System.out.println(Thread.currentThread().getName() + " в ресторане");
                guest.wait();
                System.out.println(Thread.currentThread().getName() + " приступил к еде");
                System.out.println(Thread.currentThread().getName() + " вышел из ресторана");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void getOrderR() {                              //тут официант
        synchronized (waiter) {
            try {
                System.out.println(Thread.currentThread().getName() + " на работе!");
                waiter.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        synchronized (guest) {
            try {
                Thread.sleep(3000);
                System.out.println(Thread.currentThread().getName() + " Принял заказ");
                System.out.println("Повар готовит блюдо");
                System.out.println("Повар закончил готовить");
                System.out.println(Thread.currentThread().getName() + " несет заказ");
                guest.notify();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}






