package Algorithm.sort;

import java.util.Arrays;

public class InsertionSort {
    static int[] arr = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};

    public static void main(String[] args) {
        InsertionSort sort = new InsertionSort();
        sort.sort1(arr);
        System.out.println(Arrays.toString(arr));
    }

    void sort1(int[] arr) {
        int i, j, key;

        for (i = 1; i < arr.length; i++) {
            key = arr[i];

            for (j = i - 1; j >= 0 && arr[j] > key; j--) {
                arr[j + 1] = arr[j];
            }

            arr[j + 1] = key;
        }
    }
}
