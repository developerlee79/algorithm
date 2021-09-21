package Algorithm.sort;

import java.util.Arrays;

public class CountingSort {
    public static void main(String[] args) {
        CountingSort sort = new CountingSort();

        int[] arr = {1, 3, 2, 4, 1, 5, 1, 3};
        sort.sort(arr);

        System.out.println(Arrays.toString(arr));
    }

    void sort(int[] arr) {
        int[] tmpArr = new int[5];

        for (int i : arr) {
            tmpArr[i - 1] += 1;
        }

        int tmp = 0;
        
        for (int i = 0; i < tmpArr.length; i++) {
            if (tmpArr[i] == 0) continue;

            for (int j = 0; j < tmpArr[i]; j++) {
                arr[j + tmp] = i + 1;
            }

            tmp += tmpArr[i];
        }
    }
}
