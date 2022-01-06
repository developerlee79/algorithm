package leetcode.array;

public class leetcode_121 {
    public static void main(String[] args) {
        leetcode_121 lc = new leetcode_121();
        int[] arr = {7, 1, 5, 3, 6, 4};
        System.out.println(lc.maxProfit(arr));
    }

    public int maxProfit(int[] prices) {
        int maxCur = 0, maxSoFar = 0;
        for (int i = 1; i < prices.length; i++) {
            maxCur = Math.max(0, maxCur + (prices[i] - prices[i - 1]));
            maxSoFar = Math.max(maxCur, maxSoFar);
        }
        return maxSoFar;
    }
}
