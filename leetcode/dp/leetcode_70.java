package leetcode.dp;

public class leetcode_70 {
    public static void main(String[] args) {
        leetcode_70 lc = new leetcode_70();
        System.out.println(lc.climbStairs(45));
    }

    // Max value of this algorithm is 45
    static int[] arr = new int[46];

    // If n is 1 or 2 (minimum value), return n
    // If arr[n] == 0 (not memorization), perform n * ((n-1) + (n-2) in all cases from 2 to n and insert the value at arr[i](2 to n)
    // (skip process if arr[n] is memorization at next roof)
    // After all the steps are performed, arr[n], return the last value at which all the results have been performed.
    int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        if (arr[n] == 0) {
            for (int i = 2; i <= n; i++) {
                arr[i] = climbStairs(i - 1) + climbStairs(i - 2);
            }
        }

        return arr[n];
    }
}
