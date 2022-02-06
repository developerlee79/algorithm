package baekjoon.pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class baekjoon_2003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().split(" ")[1]);
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int cnt = 0, s = 0, e = 0, sum = 0;

        while (true) {
            if (sum >= n) {
                sum -= arr[s++];
            } else if (e >= arr.length) {
                break;
            } else {
                sum += arr[e++];
            }

            if (sum == n) cnt++;
        }

        System.out.println(cnt);
    }
}
