package leetcode.array;

import java.util.Arrays;

public class leetcode_1 {
    public static void main(String[] args) {
        leetcode_1 lc = new leetcode_1();

        int[] nums = {3, 2, 4};
        System.out.println(Arrays.toString(lc.twoSum(nums, 6)));
    }

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }

        return result;
    }
}
