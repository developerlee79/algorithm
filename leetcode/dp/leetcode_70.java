package leetcode.dp;

import java.util.Arrays;

public class leetcode_70 {
    public static void main(String[] args) {
        leetcode_70 lc = new leetcode_70();

        arr[1] = 1;
        arr[2] = 2;

        System.out.println(lc.climbStairs(5));
    }

    static int[] arr = new int[46];

    int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        if (arr[n] == 0) {
            for (int i = 2; i <= n; i++) {
                arr[i + 1] = climbStairs(i - 1) + climbStairs(i - 2);
            }
        }

        return arr[n];
    }
}
