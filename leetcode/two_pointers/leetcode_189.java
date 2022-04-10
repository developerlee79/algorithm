package two_pointers;

import java.util.Arrays;

public class leetcode_189 {
    public static void main(String[] args) {
        leetcode_189 leetcode = new leetcode_189();
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        leetcode.rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
    }

    // Solution - Reverse array
    // Time Complexity : O(N)
    // Space Complexity : O(1)
    // Simple idea - reverse array 3 times
    // First : start to len - k - 1 (the position where the 0th idx will be located after rotate k times)
    // Second : len - k to end
    // Third : reverse whole array
    // because when reversed array by dividing by twice, the position of the subsets be switched when reverse the whole array.
    public void rotate(int[] nums, int k) {
        k %= nums.length;

        reverse(nums, 0, nums.length - k - 1);
        reverse(nums, nums.length - k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
    }

    static void reverse(int[] arr, int x, int y) {
        while (x < y) {
            swap(arr, x++, y--);
        }
    }

    static void swap(int[] arr, int x, int y) {
        int tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
    }
}
