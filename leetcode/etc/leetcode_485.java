package leetcode.etc;

public class leetcode_485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int cnt = 0;
        int tmp = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                cnt++;
            } else {
                if (tmp < cnt) {
                    tmp = cnt;
                }
                cnt = 0;
            }
        }

        if (tmp < cnt) {
            tmp = cnt;
        }

        return tmp;
    }
}
