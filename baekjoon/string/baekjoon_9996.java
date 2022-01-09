package baekjoon.string;

import java.util.Scanner;

public class baekjoon_9996 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfFile = sc.nextInt();
        String pattern = sc.next();

        for (int i = 0; i < numberOfFile; i++) {
            String tmp = sc.next();

            if (tmp.length() < pattern.length() - 1) {
                System.out.println("NE");
            } else {
                System.out.println(tmp.startsWith(pattern.split("\\*")[0]) && tmp.endsWith(pattern.split("\\*")[1]) ? "DA" : "NE");
            }
        }
    }
}