package baekjoon.math;

import java.util.ArrayList;
import java.util.Scanner;

public class baekjoon_1292 {
    public static void main(String[] args) {
        baekjoon_1292 bkj = new baekjoon_1292();
        bkj.easyToSolve();
    }

    void easyToSolve() {
        ArrayList<Integer> arr = new ArrayList<>();

        int num = 1;
        int count = 0;
        for (int i = 0; i < 1000; i++) {
            arr.add(num);
            count++;
            if (num == count) {
                num++;
                count = 0;
            }
        }

        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int sum = 0;
        for (int i = num1 - 1; i <= num2 - 1; i++) {
            sum += arr.get(i);
        }
        System.out.println(sum);
    }
}
