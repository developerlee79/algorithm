package leetcode.bit_manipulation;

public class leetcode_136 {
    public static void main(String[] args) {
        leetcode_136 lc = new leetcode_136();
        int[] nums = {1};
        System.out.println(lc.singleNumber(nums));
    }

    public int singleNumber(int[] nums) {
        int s = 0;
        for (int num : nums) {
            s ^= num;
        }
        return s;
    }
}
