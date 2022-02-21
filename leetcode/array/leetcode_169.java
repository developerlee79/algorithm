package leetcode.array;

import java.util.Arrays;

public class leetcode_169 {
    public static void main(String[] args) {
        leetcode_169 lc = new leetcode_169();
        int[] nums = {32, 41, 21, 29, 7, 53, 97, 76, 71, 53, 53, 53, 72, 53, 53, 14, 22, 53,
                67, 53, 53, 53, 54, 98, 53, 46, 53, 53, 62, 53, 76, 20, 60, 53, 31, 53, 53,
                53, 95, 27, 53, 53, 53, 53, 36, 59, 40, 53, 53, 64, 53, 53, 53, 21, 53, 51,
                53, 53, 2, 53, 53, 53, 53, 53, 50, 53, 53, 53, 23, 88, 3, 53, 61, 19, 53, 68,
                53, 35, 42, 53, 53, 48, 34, 54, 53, 75, 53, 53, 50, 44, 92, 41, 71, 53, 53,
                82, 53, 53, 14, 53};
        System.out.println(lc.majorityElement(nums));
    }

    // Time Complexity : O(nlogn)
    // Space Complexity : O(1)
    // Every object in nums[] always appears more than n / 2.
    // the object what we find is always more than other object at nums[].
    // so, It always be at middle of nums[] when we sorted the array.
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
