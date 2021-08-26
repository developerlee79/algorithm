package Algorithm.sort;

import java.util.Arrays;

public class QuickSort {
    static int[] arr = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50};

    public static void main(String[] args) {
        QuickSort sort = new QuickSort();
        sort.sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    void sort(int[] arr, int m, int n) {
        if (m >= n) return;

        int i = m + 1;
        int j = n;
        int tmp;

        while (i <= j) {
            while (arr[i] <= arr[m]) {
                i++;
            }

            while (arr[j] >= arr[m] && j > m) {
                j--;
            }

            if (i > j) {
                tmp = arr[j];
                arr[j] = arr[m];
                arr[m] = tmp;
            } else {
                tmp = arr[j];
                arr[j] = arr[i];
                arr[i] = tmp;
            }
        }

        sort(arr, m, j - 1);
        sort(arr, j + 1, n);
    }
}
