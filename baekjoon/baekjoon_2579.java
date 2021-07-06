package baekjoon;

public class baekjoon_2579 {
    static int[] score;
    static Integer[] dp;

    public static void main(String[] args) {
        baekjoon_2579 test = new baekjoon_2579();

        int N = 6;

        dp = new Integer[N + 1];
        score = new int[]{6, 10, 20, 15, 25, 10, 20};

        dp[0] = score[0];
        dp[1] = score[1];

        if (N >= 2) {
            dp[2] = score[1] + score[2];
        }

        System.out.println(getStairPoint(N));
    }

    static int getStairPoint(int N) {
        if (dp[N] == null) {
            dp[N] = Math.max(getStairPoint(N - 2), getStairPoint(N - 3) + score[N - 1]) + score[N];
        }

        return dp[N];
    }
}
