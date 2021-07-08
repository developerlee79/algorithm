import java.util.Arrays;

public class leetcode_repeated_subarray {
    public static void main(String[] args) {
        leetcode_repeated_subarray s = new leetcode_repeated_subarray();

        int[] num1 = {1, 2, 3, 2, 1};
        int[] num2 = {3, 2, 1, 4, 7};

        System.out.println(s.findLength(num1, num2));
    }

    public int findLength(int[] num1, int[] num2) {
        int[][] dp = new int[num1.length + 1][num2.length + 1];

        int max = 0;

        for (int i = 1; i <= num1.length; ++i) {
            for (int j = 1; j <= num2.length; ++j) {
                if (num1[i - 1] == num2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max;
    }
}
