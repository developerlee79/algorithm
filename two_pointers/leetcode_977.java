package two_pointers;

import java.util.Arrays;

public class leetcode_977 {
    public static void main(String[] args) {
        leetcode_977 leetcode = new leetcode_977();
        int[] nums = {-4, -1, 0, 3, 10};
        System.out.println(Arrays.toString(leetcode.sortedSquares(nums)));
    }

    // Solution - Two pointers
    // Time Complexity : O(N)
    // Space Complexity : O(N)
    // Start with two pointers i & j located at 0 & end of the array.
    // insert squared value of smaller of nums[i] & nums[j] in result array and in/decrease i/j pointer
    // iterative until i > j (because arr index i - j cannot be negative)
    // Example
    //  i              j                  p(4 - 0)
    // [-4, -1, 0, 3, 10]   [0, 0, 0, 0, 100]
    // abs(j) > abs(i), so add result[p] square(j) and decrease j pointer.
    //
    //  i          j                  p(3 - 0)
    // [-4, -1, 0, 3, 10]   [0, 0, 0, 16, 100]
    // abs(j) < abs(i), so add result[p] square(i) and increase i pointer.
    //
    //       i     j               p(3 - 1)
    // [-4, -1, 0, 3, 10]   [0, 0, 9, 16, 100]
    // abs(j) > abs(i), so add result[p] square(j) and decrease j pointer.
    //
    //       i  j               p(2 - 1)
    // [-4, -1, 0, 3, 10]   [0, 1, 9, 16, 100]
    // abs(j) < abs(i), so add result[p] square(i) and increase i pointer.
    //
    //          ij           p(1 - 1)
    // [-4, -1, 0, 3, 10]   [0, 1, 9, 16, 100]
    // abs(j) = abs(i), so add result[p] square(j) and decrease j pointer.
    // terminate the loop because pointer i > j
    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];

        int i = 0, j = nums.length - 1;
        while (i <= j) {
           result[j - i] = square(Math.abs(nums[i]) > Math.abs(nums[j]) ? nums[i++] : nums[j--]);
        }

        return result;
    }

    static int square(int x) {
        return x * x;
    }
}
