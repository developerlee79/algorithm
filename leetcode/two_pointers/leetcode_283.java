package two_pointers;

import java.util.Arrays;

public class leetcode_283 {
    public static void main(String[] args) {
        leetcode_283 leetcode = new leetcode_283();
        int[] nums = {0, 1, 0, 3, 12};
        leetcode.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    // Solution - Two pointers
    // Time Complexity : O(N)
    // Space Complexity : O(1)
    // Start with two pointers value of 0
    // while i pointer searching array, j pointer save index of zero-value index.
    // when i pointer found non-zero element, swap i & j and increase j pointer.
    //
    // Example
    //
    //  ij                   ij                j  i                 j  i                  j  i
    // [0, 1, 0, 3, 12]  [1, 0, 0, 3, 12]  [1, 0, 0, 3, 12]  [1, 3, 0, 0, 12]  [1, 3, 12, 0, 0]
    public void moveZeroes(int[] nums) {
        for (int i = 0, j = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                swap(nums, i, j++);
            }
        }
    }

    static void swap(int[] arr, int x, int y) {
        int tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
    }
}
