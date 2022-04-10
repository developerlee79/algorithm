package two_pointers;

import java.util.Arrays;

public class leetcode_167 {
    public static void main(String[] args) {
        leetcode_167 leetcode = new leetcode_167();
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(leetcode.twoSum(numbers, target)));
        System.out.println(Arrays.toString(leetcode.twoSumBinary(numbers, target)));
    }

    // Solution 1 - Two pointers
    // Time Complexity : O(N)
    // Space Complexity : O(1)
    public int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1, sum;

        while (true) {
            sum = numbers[i] + numbers[j];

            if (sum == target) {
                return new int[]{i + 1, j + 1};
            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }
    }

    // Solution 2 - Two pointers & Binary search
    // Time Complexity : O(logN)
    // Space Complexity : O(1)
    public int[] twoSumBinary(int[] numbers, int target) {
        int i = 0, s = i, m, e = numbers.length, sum;

        while (true) {
            if (s >= e) {
                i++;
                s = i + 1;
            }

            m = (s + e) / 2;
            sum = numbers[i] + numbers[m];

            if (sum == target) {
                return new int[]{i + 1, m + 1};
            } else if (sum < target) {
                s = m + 1;
            } else {
                e = m;
            }
        }
    }
}
