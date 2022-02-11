package leetcode.array;

public class leetcode_1979 {
    public static void main(String[] args) {
        leetcode_1979 lc = new leetcode_1979();
        int[] nums = {7, 5, 6, 8, 3};
        System.out.println(lc.findGCD(nums));
    }

    public int findGCD(int[] nums) {
        int s = 1000, l = 0;

        for (int i : nums) {
            if (s > i) s = i;
            if (l < i) l = i;
        }

        return gcd(s, l);
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
