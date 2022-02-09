package leetcode.array;

public class leetcode_1437 {
    public static void main(String[] args) {
        leetcode_1437 lc = new leetcode_1437();
        int[] nums = {1, 0, 0, 0, 1, 0, 0, 1};
        System.out.println(lc.kLengthApart(nums, 2));
    }

    public boolean kLengthApart(int[] nums, int k) {
        int cnt = k;

        for (int i : nums) {
            if (i == 0) cnt++;
            else if (i == 1) {
                if (cnt < k) return false;
                cnt = 0;
            }
        }

        return true;
    }
}
