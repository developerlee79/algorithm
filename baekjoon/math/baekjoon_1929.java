package baekjoon.math;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class baekjoon_1929 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String numStr = br.readLine();
        int m = Integer.parseInt(numStr.split(" ")[0]), n = Integer.parseInt(numStr.split(" ")[1]), cnt = 2;
        int[] arr = new int[n + 1];
        arr[1] = 1;

        for (int i = m; i <= n; i++) {
            for (int j = 2; cnt * j <= n; j++) {
                arr[cnt * j] = 1;
            }
            cnt++;
        }

        for (int i = m; i <= n; i++) {
            if (arr[i] == 0) sb.append(i).append("\n");
        }

        System.out.println(sb);
    }
}
