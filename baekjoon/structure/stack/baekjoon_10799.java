package baekjoon.structure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class baekjoon_10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String razorString = br.readLine();

        int pipe = 0, cut = 0;
        String tmp;
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < razorString.length(); i++) {
            tmp = razorString.substring(i, i + 1);

            if (tmp.equals(")") && stack.peek().equals("(")) {
                pipe--;
                cut += pipe;
                stack.push(tmp);
            } else {
                if (tmp.equals(")")) {
                    pipe--;
                    cut++;
                } else {
                    pipe++;
                    stack.push(tmp);
                }
            }
        }

        System.out.println(cut);
    }
}
