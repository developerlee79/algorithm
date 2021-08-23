package Algorithm;

import java.util.Arrays;

public class SelectSort {
    static int[] arr = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};

    public static void main(String[] args) {
        SelectSort sort = new SelectSort();
        sort.sort(arr, 0);
        System.out.println(Arrays.toString(arr));
    }

    static int tmp = 0;

    void sort(int[] arr, int x) {
        if (tmp == arr.length - 1) return;
        if (x >= arr.length - 1) {
            tmp = 0;
            x = 0;
        }

        if (arr[x] > arr[x + 1]) {
            int y = arr[x];
            arr[x] = arr[x + 1];
            arr[x + 1] = y;
        } else {
            tmp += 1;
        }

        x += 1;
        sort(arr, x);
    }
}
