package dp;

import java.util.Stack;

public class LeetCode_32 {
    public static void main(String[] args) {
        LeetCode_32 leetcode = new LeetCode_32();
        String s = "((())()";
        System.out.println(leetcode.longestValidParentheses(s));
    }

    /**
     * @param s string which containing just the characters '(' and ')'
     * @return length of the longest valid (well-formed) parentheses substring
     *
     * Solution - Dynamic Programming & Stack
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     *
     * Find the answer with stack which saved index of parenthesis.
     * The DP idea is split string by unconnected (stack is empty, this is there are no '(' before) and measure the distance between them and compare with current max length.
     * The distance between them is i (current index) - peek() (saved index).
     * This is because the element at the top of the stack is the index of the first '(', assuming that it is an ordered parenthesis.
     * Because the index starts with 0, the element is initialized with -1 to prevent the i - peak from becoming odd when the first parenthesis is closed.
     * If string is unconnected (stack is empty), push the current index (because it might be a start of new parenthesis).
     */
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        int longestLength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    longestLength = Math.max(longestLength, i - stack.peek());
                }
            }
        }

        return longestLength;
    }
}
