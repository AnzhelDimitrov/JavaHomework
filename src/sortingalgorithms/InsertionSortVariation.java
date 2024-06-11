package sortingalgorithms;

public class InsertionSortVariation implements SortingAlgorithm {
    public void sort(int[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] < arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }
}


