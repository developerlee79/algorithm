package baekjoon.dp;

import java.util.Scanner;

public class baekjoon_14888 {
    static int[] parameters;
    static int[] operator;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfParameter = sc.nextInt();

        parameters = new int[numberOfParameter];
        for (int i = 0; i < numberOfParameter; i++) {
            parameters[i] = sc.nextInt();
        }

        operator = new int[4];
        for (int i = 0; i < operator.length; i++) {
            operator[i] = sc.nextInt();
        }

        dp(parameters[0], 1);
        System.out.println(max);
        System.out.println(min);
    }

    static void dp(int x, int idx) {
        if (idx == parameters.length) {
            max = Math.max(max, x);
            min = Math.min(min, x);
            return;
        }

        for (int i = 0; i < operator.length; i++) {
            if (operator[i] > 0) {
                operator[i]--;
                switch (i) {
                    case 0:
                        dp(x + parameters[idx], idx + 1);
                        break;
                    case 1:
                        dp(x - parameters[idx], idx + 1);
                        break;
                    case 2:
                        dp(x * parameters[idx], idx + 1);
                        break;
                    case 3:
                        dp(x / parameters[idx], idx + 1);
                        break;
                }
                operator[i]++;
            }
        }
    }
}
