package leetcode;

public class leetcode_70 {
    public static void main(String[] args) {
        leetcode_70 lc = new leetcode_70();
        System.out.println(lc.climbStairs(3));
    }

    int climbStairs(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;

        int osb = 2;
        int tsb = 1;
        int result = 0;

        for (int i = 2; i < n; i++) {
            result = osb + tsb;
            tsb = osb;
            osb = result;
        }

        return result;
    }
}
