public class baekjoon_11727 {
    public static void main(String[] args) {
        baekjoon_11727 b = new baekjoon_11727();

        System.out.println(b.dp(8));
    }

    int[] arr = new int[1001]; 

    int dp(int n) {
        if (n == 1) return 1;
        if (n == 2) return 3 ;
        if (arr[n] != 0) return arr[n];

        return arr[n] = dp(n-1) + 2 * dp(n-2) % 10007;
    }
}
