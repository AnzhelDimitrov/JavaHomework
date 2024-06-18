package sortingalgorithms;

import java.util.Arrays;

public class MergeSort implements SortingAlgorithm, Runnable {
    private int[] arr;

    public MergeSort() {
    }


    public MergeSort(int[] arr) {
        this.arr = arr;
    }

    @Override
    public void run() {
        sort(arr);
    }

    @Override
    public void sort(int[] arr) {
        if (arr.length <= 1) {
            return;
        }

        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);

        MergeSort leftSort = new MergeSort(left);
        MergeSort rightSort = new MergeSort(right);

        Thread leftThread = new Thread(leftSort);
        Thread rightThread = new Thread(rightSort);

        leftThread.start();
        rightThread.start();

        try {
            leftThread.join();
            rightThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }

        merge(arr, left, right);
    }

    private void merge(int[] result, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }

        while (i < left.length) {
            result[k++] = left[i++];
        }
        while (j < right.length) {
            result[k++] = right[j++];
        }
    }
}