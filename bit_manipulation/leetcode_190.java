package bit_manipulation;

public class leetcode_190 {
    public static void main(String[] args) {
        leetcode_190 leetcode = new leetcode_190();
        System.out.println(leetcode.reverseBits(43261596));
    }

    // Solution - Bit manipulation
    // Time Complexity : O(1)
    // Space Complexity : O(1)
    // Initialize result as 0 and iterative till 31 because of Integer is 32bit.
    //
    // 1. Shift result int one bit left.
    // [0000_0000_0000_0000_0000_0000_0000_0000] -> [0000_0000_0000_0000_0000_0000_0000_0000] = 0
    // 2. Add n & 1 (last bit of n is 1 == 1, 0 == 0) at result
    // [0000_0010_1001_0100_0001_1110_1001_1100] & [0000_0000_0000_0000_0000_0000_0000_0001] = 1, so result += 1
    // 3. Shift n one bit right to drop the least significant bit to
    // [0000_0010_1001_0100_0001_1110_1001_1100] -> [0000_0001_0100_1010_0000_1111_0100_1110] = 21630798
    //
    // [0000_0000_0000_0000_0000_0000_0000_0001] -> [0000_0000_0000_0000_0000_0000_0000_0010] = 2
    // [0000_0001_0100_1010_0000_1111_0100_1110] & [0000_0000_0000_0000_0000_0000_0000_0001] = 0, so result += 0
    // [0000_0001_0100_1010_0000_1111_0100_1110] -> [0000_0000_1010_0101_0000_0111_1010_0111] = 10815399
    //
    // [0000_0000_0000_0000_0000_0000_0000_0010] -> [0000_0000_0000_0000_0000_0000_0000_0100] = 4
    // [0000_0000_1010_0101_0000_0111_1010_0111] & [0000_0000_0000_0000_0000_0000_0000_0001] = 1, so result += 1
    // [0000_0000_1010_0101_0000_0111_1010_0111] -> [0000_0000_0101_0010_1000_0011_1101_0011] = 5407699
    //
    // The key point of this iteration is that cnt adds bits that n shift to the right.
    // After 32(bit) iterations, N becomes 0 and cnt has an inverted bit of n
    public int reverseBits(int n) {
        int result = 0;

        for (int i = 0; i < 32; i++) {
            result <<= 1;
            result += n & 1;
            n >>= 1;
        }

        return result;
    }
}
