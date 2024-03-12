package Sorting;

public class SelectionSort {


    void secletionSortOptimal(int[] arr, int n) {

        for (int i = 0; i < n; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            Sorting.Helpers.swapArray(arr, minIndex, i);
        }
    }


    void selectionSortNaive(int[] arr, int n) {

        int[] temp = new int[n];


        for (int i = 0; i < n; i++) {
            int minIndex = 0;
            for (int j = 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            temp[i] = arr[minIndex];
            arr[minIndex] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < n; i++) {
            arr[i] = temp[i];
        }
    }
}
