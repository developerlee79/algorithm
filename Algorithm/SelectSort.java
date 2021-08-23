package Algorithm;

import java.util.Arrays;

public class SelectSort {
    static int[] arr = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};

    public static void main(String[] args) {
        SelectSort sort = new SelectSort();
        sort.sort(arr, 0);
        System.out.println(Arrays.toString(arr));
    }

    static int cnt = 0;

    void sort(int[] arr, int idx) {
        if (cnt == arr.length - 1) return;
        if (idx == arr.length - 1) {
            cnt = 0;
            idx = 0;
        }

        if (arr[idx] > arr[idx + 1]) {
            swap(arr, idx);
        } else {
            cnt++;
        }

        idx++;
        sort(arr, idx);
    }

    void swap(int[] arr, int a) {
        int tmp = arr[a];
        arr[a] = arr[a + 1];
        arr[a + 1] = tmp;
    }
}
