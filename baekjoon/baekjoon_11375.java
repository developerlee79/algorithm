import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class baekjoon_11375 {
    private static int arr[];
    private static int n;
    private static int m;
    private static boolean vst[];
    private static ArrayList<Integer> node[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        node = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) node[i] = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            while (t-- > 0) {
                int s = i + 1;
                int e = Integer.parseInt(st.nextToken());
                node[s].add(e);
            }
        }
        int answer = 0;
        arr = new int[m + 1];
        for (int i = 1; i <= n; i++) {
            vst = new boolean[m + 1];
            if (getDfs(i)) {
                answer++;
            }

        }
        System.out.println(answer);
    }

    private static boolean getDfs(int x) {
        for (int i = 0; i < node[x].size(); i++) {
            int now = node[x].get(i);
            if (!vst[now]) {
                vst[now] = true;
                if (arr[now] == 0 || getDfs(arr[now])) {
                    arr[now] = x;
                    return true;
                }
            }
        }
        return false;
    }
}
