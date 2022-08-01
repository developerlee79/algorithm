package two_pointers;

import java.util.Arrays;

public class leetcode_905 {
    public static void main(String[] args) {
        leetcode_905 leetcode = new leetcode_905();
        int[] nums = {3, 1, 2, 4};
        System.out.println(Arrays.toString(leetcode.sortArrayByParity(nums)));
    }

    // Solution - Two Pointers
    // Time Complexity : O(N)
    // Space Complexity : O(1)
    // Simple two pointer problem.
    // Start with two pointer p1 p2.
    // P1 is odd pointer & P2 is even pointer.
    // If p2 found even integer then swap each value of two pointers and increase each pointer.
    public int[] sortArrayByParity(int[] nums) {
        if (nums.length < 2) return nums;

        int p1 = 0, p2 = 1;

        while (p1 < nums.length && p2 < nums.length) {
            if (nums[p1] % 2 == 0) {
                p1++;
            } else if (nums[p2] % 2 == 0) {
                swap(nums, p1++, p2);
            }
            p2++;
        }

        return nums;
    }

    private void swap(int[] arr, int x, int y) {
        int tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
    }
}
