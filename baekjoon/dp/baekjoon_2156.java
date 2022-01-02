package baekjoon.dp;

import java.util.Scanner;

public class baekjoon_2156 {
    static int[] input;
    static long[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        input = new int[n + 1];
        dp = new long[n + 1][2];

        for (int i = 1; i <= n; i++) input[i] = sc.nextInt();
        dp[n] = goTo(n);
        System.out.println(Math.max(dp[n][0], dp[n][1]));
    }

    public static long[] goTo(int n) {
        if (n == 1) return new long[]{0, input[1]};
        else if (n == 2) return new long[]{input[1], input[1] + input[2]};

        dp[n - 1] = goTo(n - 1);
        long[] current = new long[2];
        current[0] = Math.max(dp[n - 1][0], dp[n - 1][1]);
        current[1] = input[n] + Math.max(dp[n - 2][0] + input[n - 1], dp[n - 1][0]);

        return current;
    }
}
