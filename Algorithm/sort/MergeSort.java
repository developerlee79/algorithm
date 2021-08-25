package Algorithm.sort;

import java.util.Arrays;

public class MergeSort {
    static int[] arr = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
    static int[] sorted = new int[arr.length];

    public static void main(String[] args) {
        MergeSort sort = new MergeSort();
        sort.sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    void merge(int[] arr, int m, int middle, int n) {
        int i = m;
        int j = middle + 1;
        int k = m;

        while (i <= middle && j <= n) {
            if (arr[i] <= arr[j]) {
                sorted[k] = arr[i];
                i++;
            } else {
                sorted[k] = arr[j];
                j++;
            }
            k++;
        }

        if (i > middle) {
            for (int t = j; t <= n; t++) {
                sorted[k] = arr[t];
                k++;
            }
        } else {
            for (int t = i; t <= middle; t++) {
                sorted[k] = arr[t];
                k++;
            }
        }

        if (n + 1 - m >= 0) System.arraycopy(sorted, m, arr, m, n + 1 - m);
    }

    void sort(int[] arr, int m, int n) {
        if (m < n) {
             int middle = (m + n) / 2;
             sort(arr, m, middle);
             sort(arr, middle + 1, n);
             merge(arr, m, middle, n);
        }
    }
}
