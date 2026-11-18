package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CPUIntensiveThreadPool {
    private static final int NUM_CORES = Runtime.getRuntime().availableProcessors(); // Get CPU core count

    public static void main(String[] args) {
        System.out.println("Number of available cores: " + NUM_CORES);
        ExecutorService fixedPool = Executors.newFixedThreadPool(NUM_CORES); // Optimize for CPU-intensive tasks
        for (int i = 0; i < 64; i++) {
            fixedPool.execute(() -> {
                long result = performComputation();
                System.out.println(Thread.currentThread().getName() + " computed result: " + result);
            });
        }
        fixedPool.shutdown();
    }

    private static long performComputation() {
        long sum = 0;
        for (int i = 0; i < (int)1e9; i++) {
            sum += Math.sqrt(i); // Simulating heavy computation
        }
        return sum;
    }
}
