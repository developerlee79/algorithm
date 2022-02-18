package leetcode.string;

import java.util.Stack;

public class leetcode_402 {
    public static void main(String[] args) {
        leetcode_402 lc = new leetcode_402();
        System.out.println(lc.removeKdigits("1432219", 3));
    }

    public String removeKdigits(String num, int k) {
        int len = num.length();
        if (k == len)
            return "0";

        Stack<Character> stack = new Stack<>();
        for (char c : num.toCharArray()) {
            for (; k > 0 && !stack.isEmpty() && stack.peek() > c; k--) {
                stack.pop();
            }
            stack.push(c);
        }

        for (; k > 0; k--) {
            stack.pop();
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty())
            sb.append(stack.pop());
        sb.reverse();

        while (sb.length() > 1 && sb.charAt(0) == '0')
            sb.deleteCharAt(0);

        return sb.toString();
    }
}
