package baekjoon.structure;

import java.util.Scanner;
import java.util.Stack;

public class baekjoon_2504 {
    static String str;
    static int answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        str = sc.next();
        Stack<Integer> stack = new Stack<>();
        int tmp = 1;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                stack.add(2);
                tmp *= 2;
            } else if (str.charAt(i) == '[') {
                stack.add(3);
                tmp *= 3;
            } else {
                if (stack.size() == 0) {
                    answer = 0;
                    break;
                }

                if (str.charAt(i) != ']' && str.charAt(i) != ')') {
                    answer = 0;
                    break;
                }

                if ((str.charAt(i) == ']' && stack.peek() == 2) || (str.charAt(i) == ')' && stack.peek() == 3)) {
                    answer = 0;
                    break;
                }

                int cur = 2;

                if (str.charAt(i) == ']')
                    cur = 3;

                if (stack.size() == 0 || (str.charAt(i - 1) == '(' && cur == 2) || (str.charAt(i - 1) == '[' && cur == 3)) {
                    answer += tmp;
                }

                stack.pop();
                tmp /= cur;
            }
        }

        if (stack.size() != 0) answer = 0;
        System.out.println(answer);
    }
}
