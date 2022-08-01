package math;

public class leetcode_1399 {
    public static void main(String[] args) {
        System.out.println(countLargestGroup(24));
    }

    public static int countLargestGroup(int n) {
        int[] dp = new int[37];
        int max = 0, cnt = 0;
        for (int i = 1; i <= n; i++) {
            int sum = sum(i);
            dp[sum]++;
            max = Math.max(max, dp[sum]);
        }

        for (int i = 0; i < 37; i++) {
            if (dp[i] == max) cnt++;
        }

        return cnt;
    }

    private static int sum(int n) {
        int s = 0;
        while (n > 0) {
            s = s + n % 10;
            n = n / 10;
        }
        return s;
    }
}
