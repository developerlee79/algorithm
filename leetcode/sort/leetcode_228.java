package leetcode.sort;

import java.util.*;

public class leetcode_228 {
    public static void main(String[] args) {
        leetcode_228 leetcode = new leetcode_228();
        int[] nums = {0, 2, 3, 4, 6, 8, 9};
        System.out.println(leetcode.summaryRanges(nums).toString());
        System.out.println(leetcode.summaryRanges2(nums).toString());
    }

    // Solution - deque
    // Time Complexity : O(N)
    // Space Complexity : O(N)
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new LinkedList<>();
        Deque<Integer> deque = new ArrayDeque<>();

        for (int num : nums) {
            if (!deque.isEmpty() && deque.getFirst() + 1 < num) {
                list.add((deque.size() == 1) ? String.valueOf(deque.getLast()) : deque.getLast() + "->" + deque.getFirst());
                deque.clear();
            }
            deque.push(num);
        }

        if (!deque.isEmpty()) {
            list.add((deque.size() == 1) ? String.valueOf(deque.getLast()) : deque.getLast() + "->" + deque.getFirst());
        }

        return list;
    }

    // Solution - sweeping
    // Time Complexity : O(N)
    // Space Complexity : O(1)
    public List<String> summaryRanges2(int[] nums) {
        List<String> list = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            int start = nums[i];

            while (i + 1 < nums.length && nums[i] + 1 == nums[i + 1])
                i++;

            list.add(start != nums[i] ? start + "->" + nums[i] : String.valueOf(start));
        }

        return list;
    }
}
