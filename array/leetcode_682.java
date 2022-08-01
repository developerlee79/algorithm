package array;

import java.util.Stack;
import java.util.regex.Pattern;

public class leetcode_682 {
    public static void main(String[] args) {
        leetcode_682 leetcode = new leetcode_682();
        String[] ops = {"5", "-2", "4", "C", "D", "9", "+", "+"};
        System.out.println(leetcode.calPoints(ops));
        System.out.println(leetcode.calPointsArray(ops));
    }

    // Solution 1 - Stack
    // Time Complexity : O(N)
    // Space Complexity : O(N)
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        int cnt = 0;

        for (String s : ops) {
            if (isNumber(s)) {
                cnt += stack.push(Integer.parseInt(s));
            } else if (s.equals("C")) {
                cnt -= stack.pop();
            } else if (s.equals("D")) {
                cnt += stack.push(stack.peek() * 2);
            } else if (s.equals("+")) {
                int tmp = stack.pop(), plus = stack.peek() + tmp;
                stack.push(tmp);
                cnt += stack.push(plus);
            }
        }

        return cnt;
    }

    // Solution 2 - Array & Pointer
    // Time Complexity : O(N)
    // Space Complexity : O(N)
    public int calPointsArray(String[] ops) {
        int[] arr = new int[ops.length];
        int cnt = 0, idx = 0;

        for (String s : ops) {
            if (isNumber(s)) {
                cnt += arr[idx++] = Integer.parseInt(s);
            } else if (s.equals("C")) {
                cnt -= arr[idx-- - 1];
                arr[idx] = 0;
            } else if (s.equals("D")) {
                cnt += arr[idx] = arr[idx++ - 1] * 2;
            } else {
                cnt += arr[idx] = arr[idx - 1] + arr[idx++ - 2];
            }
        }

        return cnt;
    }

    static final Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

    static boolean isNumber(String str) {
        return pattern.matcher(str).matches();
    }
}
