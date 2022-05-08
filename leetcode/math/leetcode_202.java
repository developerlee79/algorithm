package leetcode.math;

import java.util.HashSet;
import java.util.Set;

public class leetcode_202 {
    public static void main(String[] args) {
        leetcode_202 leetcode = new leetcode_202();
        int n = 2;
        System.out.println(leetcode.isHappy(n));
        System.out.println(leetcode.isHappySet(n));
    }

    // Solution 1 - Math
    // Time Complexity : O(logN)
    // Space Complexity : O(logN)
    // Square the digits of N and add them to the SUM.
    // If there are no remaining digits of N, change the value of N to SUM.
    // Repeat until N is less than or equal to 10.
    // Return true if 1 and 7 (the number that can be the Happy Number), or false.
    public boolean isHappy(int n) {
        while (n > 9) {
            int sum = 0;

            while (n > 0) {
                int r = n % 10;
                sum += r * r;
                n /= 10;
            }

            n = sum;
        }

        return n == 1 || n == 7;
    }

    // Solution 2 - Hash set
    // Time Complexity : O(logN)
    // Space Complexity : O(logN)
    public boolean isHappySet(int n) {
        Set<Integer> happySet = new HashSet<>();

        while (n != 1) {
            char[] chars = String.valueOf(n).toCharArray();

            int cnt = 0;
            for (char c : chars) {
                int ch = Character.digit(c, 10);
                cnt += ch * ch;
            }

            n = cnt;

            if (happySet.contains(n))
                return false;

            happySet.add(n);
        }

        return true;
    }
}
