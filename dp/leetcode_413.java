package dp;

public class leetcode_413 {
    public static void main(String[] args) {
        leetcode_413 leetcode = new leetcode_413();
        int[] nums = {1, 2, 3, 8, 9, 10};
        System.out.println(leetcode.numberOfArithmeticSlices(nums));
    }

    // Solution - Sliding Window
    // Time Complexity = O(N)
    // Space Complexity = O(N)
    // When N > 2, result = N(start at 1) += N + 1
    // Each time the window expands, the number of cases of the previous length + the newly added length is added.
    // If it is not continuous, n starts again from 1.
    public int numberOfArithmeticSlices(int[] nums) {
        int[] dp = new int[nums.length];

        int cnt = 0;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                dp[i] = dp[i - 1] + 1;
                cnt += dp[i];
            }
        }

        return cnt;
    }
}
