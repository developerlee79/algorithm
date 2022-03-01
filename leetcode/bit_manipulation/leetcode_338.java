package leetcode.bit_manipulation;

import java.util.Arrays;

public class leetcode_338 {
    public static void main(String[] args) {
        leetcode_338 leetcode = new leetcode_338();
        System.out.println(Arrays.toString(leetcode.countBits(5)));
    }

    public int[] countBits(int n) {
        int[] arr = new int[n + 1];

        for (int i = 0; i <= n; i++) {

            // Solution - use bitCount method
            // Time Complexity : O(N)
            // Space Complexity : O(N)
            // Simply use bitCount method to count every number 0 to N
            arr[i] = Integer.bitCount(i);

            // Solution - recursive
            // Time Complexity : O(NlogN)
            // Space Complexity : O(N)
            arr[i] = countBitsRecursive(i);
        }

        return arr;
    }

    // if n == 0, it always 0
    // if n == 1, it always 1
    // if n = even, it always same as n / 2 bit count.
    // if n = odd, it always same as n / 2 + 1 bit count.
    public int countBitsRecursive(int n) {
       if (n == 0 || n == 1) return n;
       if (n % 2 == 0) return countBitsRecursive(n / 2);
       return countBitsRecursive(n / 2) + 1;
    }
}
