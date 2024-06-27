package sortingalgorithms;

import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SortingPerformance {

    public SortingAlgorithm findFastestSortingAlgorithm(Collection<SortingAlgorithm> algorithms,
                                                        int[] arr) throws InterruptedException {
        Map<SortingAlgorithm, Long> results = new HashMap<>();
        List<Thread> threads = new ArrayList<>();
        Lock lock = new ReentrantLock();

        for (SortingAlgorithm algorithm : algorithms) {
            Thread thread = new Thread(() -> {
                int[] copy = arr.clone();
                long startTime = System.nanoTime();
                algorithm.sort(copy);
                long endTime = System.nanoTime();
                long duration = endTime - startTime;

                double durationInSeconds = duration / 1_000_000_000.0;
                System.out.println(algorithm.getClass().getSimpleName() + " took " + durationInSeconds + " seconds.");

                lock.lock();
                try {
                    results.put(algorithm, duration);
                } finally {
                    lock.unlock();
                }
            });

            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        SortingAlgorithm fastestAlgorithm = null;
        long fastestTime = Long.MAX_VALUE;

        for (Map.Entry<SortingAlgorithm, Long> entry : results.entrySet()) {
            if (entry.getValue() < fastestTime) {
                fastestTime = entry.getValue();
                fastestAlgorithm = entry.getKey();
            }
        }

        return fastestAlgorithm;
    }
}