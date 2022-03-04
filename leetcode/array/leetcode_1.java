package leetcode.array;

import java.util.*;

public class leetcode_1 {
    public static void main(String[] args) {
        leetcode_1 lc = new leetcode_1();
        int[] nums = {2, 5, 5, 11};
        System.out.println(Arrays.toString(lc.twoSum(nums, 10)));
        System.out.println(Arrays.toString(lc.twoSumBrute(nums, 10)));
    }

    // Solution - HashMap
    // Time Complexity - O(N)
    // Space Complexity - O(N)
    // Put target - nums[i] value at hashmap.
    // If map contains nums[i], it means nums[i] + map[nums[i]] == target
    // Because target - nums[i] always has to be correct answer.
    // return value of map & current index as array.
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]))
                return new int[]{map.get(nums[i]), i};
            map.put((target - nums[i]), i);
        }

        return null;
    }

    // Solution - Brute force
    // Time Complexity - O(N^2)
    // Space Complexity - O(N)
    // iterate until found target value
    public int[] twoSumBrute(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i == j) continue;
                if (nums[i] + nums[j] == target)
                    return new int[]{i, j};
            }
        }

        return null;
    }
}
