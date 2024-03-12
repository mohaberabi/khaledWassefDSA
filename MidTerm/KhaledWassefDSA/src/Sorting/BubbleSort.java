package Sorting;

public class BubbleSort {


    void bubbleSortNaive(int[] arr, int n) {


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    Helpers.swapArray(arr, i, j);
                }
            }
        }
    }


    void bubbleSortBetter(int[] arr, int n) {

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    Helpers.swapArray(arr, j, j + 1);
                }
            }
        }
    }


    void bubbleSortOptimal(int[] arr, int n) {


        for (int i = 0; i < n - 1; i++) {

            boolean swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    Helpers.swapArray(arr, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }
}
