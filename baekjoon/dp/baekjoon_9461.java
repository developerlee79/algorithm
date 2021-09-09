package baekjoon.dp;

public class baekjoon_9461 {
    public static Long[] seq = new Long[101];

    public static void main(String[] args) {
        seq[0] = 0L;
        seq[1] = 1L;
        seq[2] = 1L;
        seq[3] = 1L;

        System.out.println(padovan(2));
        System.out.println(padovan(6));
        System.out.println(padovan(12));
    }

    public static long padovan(int N) {
        return (seq[N] == null) ? seq[N] = padovan(N - 2) + padovan(N - 3) : seq[N];
    }
}
