package sortingalgorithms;

import java.util.Collection;

public class SortingPerformance {
    public SortingAlgorithm findFastestSortingAlgorithm(Collection<SortingAlgorithm> algorithms, int[] arr) {
        SortingAlgorithm fastestAlgorithm = null;
        long fastestTime = Long.MAX_VALUE;

        for (SortingAlgorithm algorithm : algorithms) {
            int[] copy = arr.clone();
            long startTime = System.nanoTime();
            algorithm.sort(copy);
            long endTime = System.nanoTime();

            long duration = endTime - startTime;
            if (duration < fastestTime) {
                fastestTime = duration;
                fastestAlgorithm = algorithm;
            }
        }
        return fastestAlgorithm;
    }
}
