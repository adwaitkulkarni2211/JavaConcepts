package multithreading;

public class RestaurantSimulation {
    static class WaiterThread extends Thread {
        private final Object lock;

        public WaiterThread(Object lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            synchronized (lock) {
                try {
                    System.out.println("Waiter: Waiting for the food to be ready... ⏳");
                    lock.wait(); // Waiter enters WAITING state
                    System.out.println("Waiter: Food is ready! Delivering to the customer. 🍽️");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    static class ChefThread extends Thread {
        private final Object lock;

        public ChefThread(Object lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(2000); // Simulate food preparation time
                synchronized (lock) {
                    System.out.println("Chef: Food is ready! Notifying the waiter. 🔔");
                    lock.notify(); // Wake up the waiting waiter thread
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void main(String[] args) {
        Object lock = new Object();
        Thread waiter = new WaiterThread(lock);
        Thread chef = new ChefThread(lock);

        waiter.start();
        chef.start();
    }
}
