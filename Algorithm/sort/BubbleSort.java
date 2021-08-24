package Algorithm;

import java.util.Arrays;

public class BubbleSort {
    static int[] arr = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};

    public static void main(String[] args) {
        BubbleSort sort = new BubbleSort();
        sort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    void sort(int[] arr) {
        boolean swap = true;

        int tmp = 0;
        int cnt = 0;

        while (swap) {
            if (cnt >= arr.length - 1)
                cnt = 0;

            if (arr[cnt] > arr[cnt + 1]) {
                tmp = arr[cnt];
                arr[cnt] = arr[cnt + 1];
                arr[cnt + 1] = tmp;
            }

            if (arr[cnt] < arr[cnt + 1] || arr[cnt] == arr[cnt+1])
                tmp++;

            cnt++;

            if (tmp == arr.length - 1)
                swap = false;
        }

    }
}
