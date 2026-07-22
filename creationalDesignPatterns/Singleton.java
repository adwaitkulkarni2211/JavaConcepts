package creationalDesignPatterns;

public class Singleton {
    public class BadLogger {    // this logger can be instantiated anywhere in the program any number of times
        public void log(String message) {
            System.out.println("Log: " + message);
        }
    }

    public class SingletonLogger {
        // 1. Private static variable to hold the single instance
        private static SingletonLogger instance;

        // 2. Private constructor to prevent instantiation
        private SingletonLogger() {}

        // 3. Public method to provide access to the instance
        public SingletonLogger getInstance() {
            if (instance == null) {
                instance = new SingletonLogger(); // Create a new instance only if it doesn't exist
            }
            return instance; // Return the existing instance
        }
        public void log(String message) {
            System.out.println("Log: " + message);
        }
    }

    public class ThreadSafeLogger {
        private static volatile ThreadSafeLogger instance; // volatile keyword ensures visibility across threads

        private ThreadSafeLogger() {
        } // Private constructor to prevent instantiation

        public ThreadSafeLogger getInstance() {
            if (instance == null) { // First check (no synchronization needed here)
                synchronized (
                        ThreadSafeLogger.class) { // Synchronize only when creating the instance
                    if (instance == null) { // Second check (inside synchronized block)
                        instance = new ThreadSafeLogger(); // Create the instance if it's still null
                    }
                }
            }
            return instance; // Return the single instance
        }
    }
}
