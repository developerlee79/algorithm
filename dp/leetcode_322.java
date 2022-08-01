package dp;

public class leetcode_322 {
    public static void main(String[] args) {
        int[] coins = {186, 419, 83, 408};
        int amount = 6249;
        coinChange(coins, amount);
    }

    public static void coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        System.out.println(recursion(coins, amount, dp, 1));
        System.out.println(iterative(coins, amount));
    }

    static int recursion(int[] coins, int amount, int[] dp, int idx) {
        if (idx > amount) return dp[amount];

        int tmp = amount;
        for (int coin : coins) {
            if (idx - coin >= 0 && dp[idx - coin] != -1)
                tmp = Math.min(dp[idx - coin], tmp);
        }

        dp[idx] = (tmp != amount) ? tmp + 1 : -1;
        return recursion(coins, amount, dp, idx + 1);
    }

    static int iterative(int[] coins, int amount) {
        int[] dp = new int[amount + 1];

        for (int i = 1; i <= amount; i++) {
            int min = amount;
            for (int coin : coins) {
                if (i - coin >= 0 && dp[i - coin] != -1)
                    min = Math.min(dp[i - coin], min);
            }
            dp[i] = (min != amount) ? min + 1 : -1;
        }

        return dp[amount];
    }
}
