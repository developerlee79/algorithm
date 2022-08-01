package math;

public class leetcode_69 {
    public static void main(String[] args) {
        leetcode_69 lc = new leetcode_69();
        System.out.println(lc.mySqrt(8));
    }

    public int mySqrt(int x) {
        long r = x;
        while (r * r > x)
            r = (r + x / r) / 2;
        return (int) r;
    }
}
