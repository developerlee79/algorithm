package two_pointers;

import java.util.Arrays;

public class leetcode_80 {
    public static void main(String[] args) {
        leetcode_80 lc = new leetcode_80();
        int[] nums = {1, 1, 1, 2, 2, 3};
        System.out.println(lc.removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }

    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int n : nums)
            if (i < 2 || n > nums[i - 2])
                nums[i++] = n;
        return i;
    }
}
