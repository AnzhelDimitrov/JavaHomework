package sortingalgorithms;

public class SelectionSort implements SortingAlgorithm {
    public void sort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minNumIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minNumIndex]) {
                    minNumIndex = j;
                }
            }
            int temp = arr[minNumIndex];
            arr[minNumIndex] = arr[i];
            arr[i] = temp;
        }
    }
}
