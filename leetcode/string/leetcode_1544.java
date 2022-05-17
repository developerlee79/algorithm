package leetcode.string;

import java.util.Stack;

public class leetcode_1544 {
    public static void main(String[] args) {
        leetcode_1544 leetcode = new leetcode_1544();
        String s = "leEeetcode";
        System.out.println(leetcode.makeGood(s));
    }

    /**
     * @param s String of lower and upper case English letters
     * @return Good string (after removed lower-UPPER or vice-versa in given string)
     *
     * Solution - Stack
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     *
     * Validate current character and previous character (peek from stack) is "bad string" and if it is, popped previous char to exclude "bad string"
     * Or else, push current character into stack to prepare next loop.
     * When the loop is over, return string inside a stack.
     */
    public String makeGood(String s) {
        Stack<Character> greatStringStack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (!greatStringStack.isEmpty() && isBadString(c, greatStringStack.peek())) {
                greatStringStack.pop();
            } else {
                greatStringStack.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : greatStringStack) {
            sb.append(c);
        }

        return sb.toString();
    }

    private static boolean isBadString(char firstChar, char secondChar) {
        return Math.abs(firstChar - secondChar) == 32;
    }
}
