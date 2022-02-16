package leetcode.math;

public class leetcode_441 {
    public static void main(String[] args) {
        leetcode_441 lc = new leetcode_441();
        System.out.println(arrangeCoins(121));
    }

    public static int arrangeCoins(int n) {
        return (int) (Math.sqrt(2 * (long) n + 0.25) - 0.5);
    }

    public static int arrangeCoins2(int n) {
        int i = 1;
        while (true) {
            if (i >= n - i) return i;
            n -= i++;
        }
    }
}
