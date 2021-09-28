package leetcode.sort;

import java.util.Arrays;

public class leetcode_922 {
    public static void main(String[] args) {
        leetcode_922 lc = new leetcode_922();
        int[] nums = {648, 831, 560, 986, 192, 424, 997, 829, 897, 843};
        System.out.println(Arrays.toString(lc.sortArrayByParityII(nums)));
    }

    public int[] sortArrayByParityII(int[] nums) {
        int i = 0, j = 1, n = nums.length;
        while (i < n && j < n) {
            while (i < n && nums[i] % 2 == 0) {
                i += 2;
            }
            while (j < n && nums[j] % 2 == 1) {
                j += 2;
            }
            if (i < n && j < n) {
                swap(nums, i, j);
            }
        }
        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
