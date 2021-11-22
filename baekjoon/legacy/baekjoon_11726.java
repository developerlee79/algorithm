public class baekjoon_11726 {
    public static void main(String[] args) {
        baekjoon_11726 b = new baekjoon_11726();

        System.out.println(b.dp(5));
    }

    int[] arr = new int[1001];

    int dp(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        if (arr[n] != 0) return arr[n];

        return arr[n] = dp(n - 1) + dp(n - 2) % 10007;
    }
}
