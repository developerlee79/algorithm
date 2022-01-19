package baekjoon.structure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int cnt = Integer.parseInt(br.readLine());
        int[] stack = new int[cnt];
        int tmp = 0;

        for (int i = 0; i < cnt; i++) {
            String str = br.readLine();
            if (str.contains("push")) {
                stack[tmp] = Integer.parseInt(str.split(" ")[1]);
                tmp++;
            } else if (str.equals("top")) {
                sb.append(tmp > 0 ? stack[tmp - 1] : -1).append("\n");
            } else if (str.equals("size")) {
                sb.append(tmp).append("\n");
            } else if (str.equals("empty")) {
                sb.append(tmp == 0 ? 1 : 0).append("\n");
            } else if (str.equals("pop")) {
                if (tmp > 0) {
                    sb.append(stack[tmp - 1]).append("\n");
                    stack[tmp - 1] = 0;
                    tmp--;
                } else {
                    sb.append(-1).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}
