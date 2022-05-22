package string;

public class LeetCode_647 {
    public static void main(String[] args) {
        LeetCode_647 leetcode = new LeetCode_647();
        String s = "abc";
        System.out.println(leetcode.countSubstrings(s));
    }

    /**
     * @param s target string
     * @return number of palindrome strings
     *
     * Solution - Dynamic programming
     * Time Complexity : O(N)
     * Space Complexity : O(1)
     *
     * Find the total number by making sure it is a palindrome string for i, i + 1 target in every iteration.
     */
    public int countSubstrings(String s) {
        if (s.length() == 0) {
            return 0;
        }

        int result = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            result += isPalindrome(chars, i, i);
            result += isPalindrome(chars, i, i + 1);
        }

        return result;
    }

    private int isPalindrome(char[] chars, int index, int next) {
        int count = 0;

        while (index >= 0 && next < chars.length && chars[index--] == chars[next++]) {
            count++;
        }

        return count;
    }
}
