package array;

import java.util.Arrays;

public class leetcode_268 {
    public static void main(String[] args) {
        leetcode_268 leetcode = new leetcode_268();
        int[] nums = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        System.out.println(leetcode.missingNumber(nums));
    }

    /**
     * @param nums Array what range [0, N] with only one missing number
     * @return Missing number
     *
     * Solution - Iteration
     * Time Complexity : O(N)
     * Space Complexity : O(1)
     *
     * Add sum of nums at Count & sum range 0 - nums.length at perfectCount
     * Subtract perfectCount - Count to find missing number
     */
    public int missingNumber(int[] nums) {
        int count = Arrays.stream(nums).sum();
        int perfectCount = 0;

        for (int i = 0; i <= nums.length; i++)
            perfectCount += i;

        return perfectCount - count;
    }
}
