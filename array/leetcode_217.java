package array;

import java.util.HashSet;
import java.util.Set;

public class leetcode_217 {
    public static void main(String[] args) {
        leetcode_217 leetcode = new leetcode_217();
        int[] nums = {1, 2, 3, 1};
        System.out.println(leetcode.containsDuplicate(nums));
    }

    /**
     * @param nums Target array likely to contain redundancy
     * @return Target array contain duplicates
     *
     * Solution - Set
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     *
     * Use hashset to validate array
     */
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> numSet = new HashSet<>();

        for (int num : nums) {
            if (numSet.contains(num)) {
                return true;
            }
            numSet.add(num);
        }

        return false;
    }
}
