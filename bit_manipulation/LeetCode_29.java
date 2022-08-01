package bit_manipulation;

public class LeetCode_29 {
    public static void main(String[] args) {
        LeetCode_29 leetcode = new LeetCode_29();
        int dividend = 10, divisor = 3;
        System.out.println(leetcode.divide(dividend, divisor));
    }

    /**
     * @param dividend dividend
     * @param divisor  divisor
     * @return quotient after dividing dividend by divisor
     *
     * Solution - Bit manipulation
     * Time Complexity : O(N)
     * Space Complexity : O(1)
     *
     * Implement a division operation by find the number of times a divisor can completely subtract by entire dividend.
     * 1. Exponentially increase the divisor until before it surpass the dividend then subtract with it
     * 2. Add up the divisor and find the remainder
     * 3. Repeat the same until it brings to 0
     * Use left & right shift to replace multiplication and division.
     */
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        boolean negative = dividend < 0 ^ divisor < 0;

        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        int quotient = 0, subQuotient;
        while (dividend - divisor >= 0) {
            for (subQuotient = 0; dividend - (divisor << subQuotient << 1) >= 0;) {
                subQuotient++;
            }

            quotient += 1 << subQuotient;
            dividend -= divisor << subQuotient;
        }

        return negative ? -quotient : quotient;
    }

}
