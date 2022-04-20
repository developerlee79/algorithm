package bit_manipulation;

public class leetcode_231 {
    public static void main(String[] args) {
        leetcode_231 leetcode = new leetcode_231();
        System.out.println(leetcode.isPowerOfTwo(16));
    }

    // Solution - Bit manipulation
    // Time Complexity : O(1)
    // Space Complexity : O(1)
    // Binary code of N power of 2 is likes Ob1 + 0xN
    // Therefore, Power(2, N) == 1 << N
    // And Power(2, N) - 1 is likes 0b1 + 1xN
    // Therefore, Power(2, N) & (Power(2, N) - 1) == 0
    // 2 is constant, so remove 2 than (N & N - 1) == 0
    //
    // Example
    // 8(Power(2, 3))     = Ob1000
    // 7(Power(2, 3) - 1) = Ob0111
    // Apply And(&)       = Ob0000 == 0
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & n - 1) == 0;
    }
}
