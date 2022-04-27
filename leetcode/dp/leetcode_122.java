package leetcode.dp;

public class leetcode_122 {
    public static void main(String[] args) {
        leetcode_122 leetcode = new leetcode_122();
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(leetcode.maxProfit(prices));
    }

    // Solution - Greedy
    // Time Complexity : O(N)
    // Space Complexity : O(1)
    // Classic greedy problem.
    // Start with index 1 and compare the stock value of the previous day(arr[i - 1]) with the stock value of the stock today(arr[i]).
    // If the stock price of today is greater than the stock price of yesterday(arr[i - 1]),
    // It means you get a profit from selling the stock you bought yesterday.
    // If you can't sell with the "attractive price"(the value of stock you bought yesterday is higher than today) until the end,
    // You will end the iteration without buying and selling any stock.
    public int maxProfit(int[] prices) {
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }

        return profit;
    }
}
