package baekjoon.legacy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class baekjoon_5052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int t = Integer.parseInt(br.readLine());
            String[] arr = new String[t];
            int sw = 0;
            for (int j = 0; j < t; j++) {
                arr[j] = br.readLine();
            }

            Arrays.sort(arr, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.compareTo(o2);
                }
            });

            for (int j = 1; j < t; j++) {
                if (arr[j].startsWith(arr[j - 1])) {
                    sw = 1;
                    break;
                }
            }
            System.out.println(sw == 0 ? "YES" : "NO");
        }
    }
}
