package baekjoon.legacy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class baekjoon_2188 {
    public static int m, n, result[];
    public static boolean check[];
    public static ArrayList<Integer> node[];

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        node = new ArrayList[n + 1];
        result = new int[m + 1];
        for (int i = 1; i <= n; i++) {
            node[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            while (cnt-- > 0) {
                int wantHoust = Integer.parseInt(st.nextToken());
                node[i + 1].add(wantHoust);
            }
        }

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            check = new boolean[m + 1];
            if (bipartiteMatching(i)) {
                answer++;
            }
        }
        System.out.print(answer);
    }

    public static boolean bipartiteMatching(int x) {

        for (int i = 0; i < node[x].size(); i++) {
            int want = node[x].get(i);
            if (!check[want]) {
                check[want] = true;
                if (result[want] == 0 || bipartiteMatching(result[want])) {
                    result[want] = x;
                    return true;
                }
            }
        }

        return false;
    }
}
