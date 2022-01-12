package baekjoon.math;

import java.util.Scanner;

public class baekjoon_1789 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();

        long start = 1;
        long end = n;
        long result = 0;

        while (start <= end) {
            long mid = (start + end) / 2;
            if (mid * (mid + 1) / 2 <= n) {
                result = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(result);
    }
}
