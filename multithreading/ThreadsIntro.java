package multithreading;

public class ThreadsIntro {
    // extending the Thread class
    static class MyThread extends Thread {
        // Override the run method to define thread behavior
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.println("Thread " + Thread.currentThread().getId() + " is running: " + i);
                try {
                    Thread.sleep(500); // Pause execution for 500 milliseconds
                } catch (InterruptedException e) {
                    System.out.println("Thread interrupted");
                }
            }
        }
    }

    // extending the Runnable class
    static class MyRunnable implements Runnable {
        // Implement the run method from Runnable interface
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.println("Runnable " + Thread.currentThread().getId() + " is running: " + i);
                try {
                    Thread.sleep(500); // Pause execution for 500 milliseconds
                } catch (InterruptedException e) {
                    System.out.println("Thread interrupted");
                }
            }
        }
    }

    public static void main(String[] args) {
        MyThread thread1 = new MyThread(); // Create thread instance
        MyThread thread2 = new MyThread();

        thread1.start(); // Start the thread
        thread2.start();

        MyRunnable runnable = new MyRunnable(); // Create runnable instance

        Thread thread3 = new Thread(runnable); // Create thread with runnable
        Thread thread4 = new Thread(runnable);

        thread3.start(); // Start the first thread
        thread4.start(); // Start the second thread
    }
}
