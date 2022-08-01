package bit_manipulation;

public class LeetCode_1342 {
    public static void main(String[] args) {
        LeetCode_1342 leetcode = new LeetCode_1342();
        int num = 14;
        System.out.println(leetcode.numberOfSteps(num));
    }

    /**
     * @param num unsigned integer
     * @return number of steps to reduce it zero
     *
     * Solution - Bit manipulation
     * Time Complexity : O(N)
     * Space Complexity : O(1)
     *
     * Using a bit operator AND (&) to simply solve the problem.
     * The end of the even binary bit is always zero.
     * Therefore, the AND (&) operation results of 1 (0001) and 'num' is 0 for even numbers and 1 for odd numbers.
     * In this problem, even numbers are always has to be divided by 2, and odd numbers are reduced by 1.
     * Because it could be even numbers are still can be even after divided, so increase count just 1
     * And Odd numbers always become even after decreasing 1, so it always includes even division operations after decreasing.
     * Therefore, increase the count by 2 with the value from the AND operation.
     * After the operation is complete, shift the confirmed bit one space right to proceed the next bit.
     * Returns count - 1 to complete the operation. (Consider if 2)
     */
    public int numberOfSteps(int num) {
        if (num == 0) {
            return 0;
        }

        int count = 0;

        while (num > 0) {
            count += (num & 1) + 1;
            num >>= 1;
        }

        return count - 1;
    }
}
