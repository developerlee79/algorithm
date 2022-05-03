package leetcode.two_pointers;

public class leetcode_581 {
    public static void main(String[] args) {
        leetcode_581 leetcode = new leetcode_581();
        int[] nums = {2, 6, 4, 8, 10, 9, 15};
        System.out.println(leetcode.findUnsortedSubarray(nums));
    }

    // Solution - Two pointers
    // Time Complexity : O(N)
    // Space Complexity : O(1)
    // Start with two index pointers what initialize by 0 & 1
    // The variables max and min are initialized by assuming the worst-case scenario.
    // Which the leftmost value is the largest and the rightmost value is the smallest - Entire array replacement.
    // Array is iterated in both directions and if nums[i] / [j] is greater or less than the current max/min value, set index value at result pointer.
    // If nums[i] / [j] is greater or less then current max / min, it means current value is sorted value - so change max / min to i / j.
    //
    // Example
    //
    // max                 min
    // [2, 6, 4, 8, 10, 9, 15]
    // p1  p2
    //
    //    max          min
    // [2, 6, 4, 8, 10, 9, 15]
    // p1  p2
    //
    //    max          min
    // [2, 6, 4, 8, 10, 9, 15]
    //        p1    p2
    //
    //       max    min
    // [2, 6, 4, 8, 10, 9, 15]
    //        p1    p2
    //
    //         min/max
    // [2, 6, 4, 8, 10, 9, 15]
    //        p1    p2
    //
    //       min    max
    // [2, 6, 4, 8, 10, 9, 15]
    //    p2            p1
    //
    // min                 max
    // [2, 6, 4, 8, 10, 9, 15]
    //     p2           p1
    //
    // 5(p1) - 1(p2) + 1 = [5]
    public int findUnsortedSubarray(int[] nums) {
        int max = nums[0], min = nums[nums.length - 1];

        int p1 = 0, p2 = 1;
        for (int i = 0, j = nums.length - 1; i < nums.length; i++, j--) {
            if (max > nums[i])
                p1 = i;
            else
                max = nums[i];

            if (min < nums[j])
                p2 = j;
            else
                min = nums[j];
        }

        return p1 - p2 + 1;
    }
}
