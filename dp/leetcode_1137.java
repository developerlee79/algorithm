package dp;

public class leetcode_1137 {

    static int[] tribonacciArr = new int[38];

    public static void main(String[] args) {
        leetcode_1137 lc = new leetcode_1137();
        System.out.println(lc.tribonacci(4));
    }

    public int tribonacci(int n) {
        if (n == 0) return 0;
        if (n <= 2) return 1;

        if (tribonacciArr[n] == 0) {
            tribonacciArr[n] = tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);
        }

        return tribonacciArr[n];
    }
}
