package string;

import java.util.Stack;

public class leetcode_20 {
    public static void main(String[] args) {
        leetcode_20 lc = new leetcode_20();

        System.out.println(lc.isValid("()()"));
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty(); 
    }
}
