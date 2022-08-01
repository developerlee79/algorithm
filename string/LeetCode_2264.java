package string;

public class LeetCode_2264 {
    public static void main(String[] args) {
        LeetCode_2264 leetcode = new LeetCode_2264();
        String num = "6777133339";
        System.out.println(leetcode.largestGoodInteger(num));
    }

    /**
     * @param num string what representing a large integer
     * @return substring of num with length 3 and consists of only one unique digit
     *
     * Solution - Iteration and compare
     * Time Complexity : O(N)
     * Space Complexity : O(1)
     *
     * Find the Good Integer by comparing each iteration to see if all strings of length 3 are the same char.
     */
    public String largestGoodInteger(String num) {
        int goodInteger = -1;

        char[] chars = num.toCharArray();
        for (int i = 2; i < chars.length; i++) {
            if (chars[i - 2] == chars[i - 1] && chars[i - 1] == chars[i]) {
                goodInteger = Math.max(goodInteger, chars[i] - '0');
            }
        }

        if (goodInteger == -1) {
            return "";
        }

        return "" + goodInteger + goodInteger + goodInteger;
    }
}
