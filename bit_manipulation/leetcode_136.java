package bit_manipulation;

public class leetcode_136 {
    public static void main(String[] args) {
        leetcode_136 leetcode = new leetcode_136();
        int[] nums = {4, 1, 2, 1, 2};
        System.out.println(leetcode.singleNumber(nums));
    }

    // Solution - Bit manipulation
    // Time Complexity : O(N)
    // Space Complexity : O(1)
    // Use caret operator to compare each value of array
    // ^(caret) operator is XOR operator.
    // It means if an array has the same value, the binary number corresponding to that value means that it is always 0.
    // Therefore, if there is only one number without a pair, the bit of that number is unconditionally maintained until the end.
    //
    // Example with binary
    // [0100, 0001, 0010, 0001, 0010], singleNum = [0000]
    // [0100, 0101, 0111, 0110, 0100] -> so singleNum is [0100] = 4
    public int singleNumber(int[] nums) {
        int singleNum = 0;

        for (int num : nums) {
            singleNum ^= num;
        }

        return singleNum;
    }
}
