package two_pointers;

import java.util.Stack;

public class leetcode_680 {
    public static void main(String[] args) {
        leetcode_680 leetcode = new leetcode_680();
        System.out.println(leetcode.validPalindrome("abca"));
    }

    // Solution 1 - Brute force
    // Time Complexity : O(N)
    // Space Complexity : O(N)
    //
    public boolean validPalindrome(String s) {
        if (recursive(s)) return true;

        for (int i = 0; i < s.length(); i++) {
            StringBuilder sb = new StringBuilder(s);
            sb.deleteCharAt(i);
            if (recursive(sb.toString())) return true;
        }

        return false;
    }

    static boolean recursive(String s) {
        Stack<Character> stack = new Stack<>();

        char[] chars = s.toCharArray();

        int i = 0;
        for (; i < chars.length / 2; i++)
            stack.push(chars[i]);

        while (!stack.isEmpty()) {
            if (!stack.pop().equals(chars[i])) return false;
        }

        return true;
    }

    // Solution 2 - Two pointers
    // Time Complexity : O(N)
    // Space Complexity : O(1)
    //
    public boolean validPalindromePointers(String s) {
        int i = 0, j = s.length() - 1;

        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return isPalindrome(s, i + 1, j) || isPalindrome(s, i, j - 1);
            }
            i++;
            j--;
        }

        return true;
    }

    /* Check is s[i...j] is palindrome. */
    private boolean isPalindrome(String s, int i, int j) {

        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
}
