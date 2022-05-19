package baekjoon.legacy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class baekjoon_6549 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            if (n == 0) break;

            int[] height = new int[n];
            Stack<Integer> stack = new Stack<>();
            long max = 0;
            for (int i = 0; i < n; i++) {
                height[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < n; i++) {
                while (!stack.isEmpty() && height[stack.peek()] > height[i]) {
                    int idx = stack.pop();
                    int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                    max = Math.max(max, (long) width * height[idx]);
                }
                stack.push(i);
            }

            while (!stack.isEmpty()) {
                int idx = stack.pop();
                int width = stack.isEmpty() ? n : n - stack.peek() - 1;
                max = Math.max(max, (long) width * height[idx]);
            }

            System.out.println(max);
        }
    }
}
