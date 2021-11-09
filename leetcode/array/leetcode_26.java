package leetcode.array;

public class leetcode_26 {
    public static void main(String[] args) {
        leetcode_26 lc = new leetcode_26();
        int[] nums = {1, 1, 2};
        System.out.println(lc.removeDuplicates(nums));
    }

    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int n : nums)
            if (i == 0 || n > nums[i - 1])
                nums[i++] = n;
        return i;
    }
}
