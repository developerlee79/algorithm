package leetcode.array;

import java.util.HashMap;
import java.util.Map;

public class leetcode_525 {
    public static void main(String[] args) {
        leetcode_525 lc = new leetcode_525();
        int[] nums = {0, 1, 0};
        System.out.println(lc.findMaxLength(nums));
    }

    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int sum = 0, max = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += (nums[i] == 0) ? -1 : 1;
            if (!map.containsKey(sum)) map.put(sum, i);
            max = Math.max(max, i - map.get(sum));
        }

        return max;
    }
}
