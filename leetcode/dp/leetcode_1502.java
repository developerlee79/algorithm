package leetcode.dp;

import java.util.Arrays;

public class leetcode_1502 {
    public static void main(String[] args) {
        leetcode_1502 lc = new leetcode_1502();

        int[] arr = {126, 183, 259, 31, 145, 202, 221, 278, 50, 107, 164, 12, 88, -7, 240, 69};
        System.out.println(lc.canMakeArithmeticProgression(arr));
    }

    public boolean canMakeArithmeticProgression(int[] arr) {
        if (arr.length == 1) return false;
        if (arr.length == 2) return true;

        Arrays.sort(arr);

        int tmp = 0;

        for (int i = 1; i < arr.length - 1; i++) {
            tmp = arr[i] - arr[i - 1];

            if (arr[i + 1] - arr[i] != tmp) return false;
        }

        return true;
    }
}
