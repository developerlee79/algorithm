package baekjoon.newal;

public class baekjoon_2839 {
    public static void main(String[] args) {
        baekjoon_2839 bj = new baekjoon_2839();
        System.out.println(bj.delivery(18));
    }

    int delivery(int n) {
        if (n % 5 == 0) return n / 5;
        else if (n % 5 == 1 || n % 5 == 3) return (n / 5) + 1;
        else if (n % 5 == 2 || n % 5 == 4) return (n / 5) + 2;
        else return -1;
    }
}
