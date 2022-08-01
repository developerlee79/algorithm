package string;

import java.util.Stack;

public class leetcode_1209 {
    public static void main(String[] args) {
        leetcode_1209 leetcode = new leetcode_1209();
        String s = "pbbcggttciiippooaais";
        int k = 2;
        System.out.println(leetcode.removeDuplicates(s, k));
    }

    // Solution - Stack
    // Time Complexity : O(N)
    // Space Complexity : O(N)
    // Use int[] type Stack for save [char : adjacent occurrence count].
    // Searching string and if char at top of stack equal to current char then increase the occurrence count.
    // Or else push new array [i, 1] at stack.
    // Now if the top element's occurrence count is equals to k then pop element.
    // Then iterate whole stack and build result string.
    public String removeDuplicates(String s, int k) {
        Stack<int[]> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (stack.size() > 0 && s.charAt(stack.peek()[0]) == s.charAt(i))
                stack.peek()[1]++;
            else
                stack.push(new int[]{i, 1});

            if (stack.peek()[1] == k)
                stack.pop();
        }

        StringBuilder sb = new StringBuilder();

        while (stack.size() > 0)
            sb.append(String.valueOf(s.charAt(stack.peek()[0])).repeat(Math.max(0, stack.pop()[1])));

        return sb.reverse().toString();
    }
}
