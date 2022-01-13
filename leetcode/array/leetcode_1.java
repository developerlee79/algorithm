package leetcode.array;

import java.util.Arrays;

public class leetcode_1 {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        
        return new int[]{0, 0};
    }
    
    public int[] twoSum2(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                result[1] = i + 1;
                result[0] = map.get(target - nums[i]);
                return result;
            }

            if(map.containsKey(nums[i])) {
               continue;
            }

            map.put(nums[i], i + 1);
        }
        return result;
    }
}
