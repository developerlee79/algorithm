package leetcode.math;

public class leetcode_1837 {
    public static void main(String[] args) {
        leetcode_1837 leetcode = new leetcode_1837();
        int n = 79, k = 3;
        System.out.println(leetcode.sumBase(n, k));
    }

    /**
     * @param n integer to be converted
     * @param k base
     * @return sum of the digits of n after converting n from base 10 to base k
     *
     * Solution - Math formula
     * Time Complexity : O(logN)
     * Space Complexity : O(1)
     *
     * Divide number by n until it reaches zero and output the remainder in reverse for convert a decimal number into a k base number.
     * In this case, add remainder at count to count digits.
     */
    public int sumBase(int n, int k) {
        int count = 0;
        while (n > 0) {
            count += n % k;
            n /= k;
        }
        return count;
    }
}
