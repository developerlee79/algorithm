package leetcode.array;

import java.util.*;

public class leetcode_2150 {
    public static void main(String[] args) {
        leetcode_2150 leetcode = new leetcode_2150();
        int[] nums = {10, 6, 5, 8};
        System.out.println(leetcode.findLonely(nums).toString());
    }

    // Solution using set
    // Time Complexity : O(3) (N)
    // Space Complexity : O(2) (N)
    public List<Integer> findLonely(int[] nums) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> removeSet = new HashSet<>();

        for (int i : nums) {
            if (set.contains(i)) removeSet.add(i);
            set.add(i);
        }

        for (int i : nums) {
            if (set.contains(i - 1) || set.contains(i + 1)) removeSet.add(i);
        }

        set.removeAll(removeSet);

        return new ArrayList<>(set);
    }

    // Solution using HashMap
    // Time Complexity : O(2) (N)
    // Space Complexity : O(2) (N)
    public List<Integer> findLonelyWithMap(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
        }

        List<Integer> arr = new ArrayList<>();
        for (int i : map.keySet()) {
            if (map.get(i) == 1 && !map.containsKey(i - 1) && !map.containsKey(i + 1)) {
                arr.add(i);
            }
        }

        return arr;
    }
}
