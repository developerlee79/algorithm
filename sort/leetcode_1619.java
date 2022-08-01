package sort;

import java.util.Arrays;

public class leetcode_1619 {
    public static void main(String[] args) {
        leetcode_1619 lc = new leetcode_1619();
        int[] arr = {6, 0, 7, 0, 7, 5, 7, 8, 3, 4, 0, 7, 8, 1, 6, 8, 1, 1, 2, 4, 8, 1, 9, 5, 4, 3, 8, 5, 10, 8, 6, 6, 1, 0, 6, 10, 8, 2, 3, 4};
        System.out.println(lc.trimMean(arr));
    }

    public double trimMean(int[] arr) {
        Arrays.sort(arr);
        double sum = 0;
        int len = arr.length;
        for (int i = len / 20; i < arr.length - (len / 20); i++) {
            sum += arr[i];
        }

        return sum / (double) (len * 9 / 10);
    }
}
