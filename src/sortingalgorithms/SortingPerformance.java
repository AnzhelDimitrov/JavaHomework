package sortingalgorithms;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;

public class SortingPerformance {

    public SortingAlgorithm findFastestSortingAlgorithm(Collection<SortingAlgorithm> algorithms,
                                                        int[] arr) throws InterruptedException {
        Map<SortingAlgorithm, Long> results = new HashMap<>();

        for (SortingAlgorithm algorithm : algorithms) {
            Thread thread = new Thread(() -> {
                int[] copy = arr.clone();
                long startTime = System.nanoTime();
                algorithm.sort(copy);
                long endTime = System.nanoTime();
                long duration = endTime - startTime;

                synchronized (results) {
                    results.put(algorithm, duration);
                }
            });

            thread.start();

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