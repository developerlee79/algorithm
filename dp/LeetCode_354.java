package dp;

import java.util.Arrays;

public class LeetCode_354 {
    public static void main(String[] args) {
        LeetCode_354 leetcode = new LeetCode_354();
        int[][] envelopes = {{2, 100}, {3, 200}, {4, 300}, {5, 500}, {5, 400}, {5, 250}, {6, 370}, {6, 360}, {7, 380}};
        System.out.println(leetcode.maxEnvelopes(envelopes));
    }

    /**
     * @param envelopes 2D array of width and height of an envelope
     * @return maximum number of envelopes put one inside the other (Russian doll)
     *
     * Solution - Binary search & Dynamic programming
     * Time Complexity : O(NlogN)
     * Space Complexity : O(N)
     *
     * Sort arrays and solve problems with binary search and memorization.
     * Implement binary search with variable left and right (count)
     * If the left is greater or equal to right, next envelope is smaller than or equal to the current envelope.
     * Because there is binary search inside the loop to change left / right value to middle index.
     * So current envelope cannot put in next envelope - end the loop.
     * In the first iteration, next envelope is always bigger than current.
     * So loop is not executed, and the height of the current envelope is stored at dp array and count is increased.
     * After that, divide the count by 2 to obtain the middle value.
     * Because envelopes is a sorted array, you only need to perform a binary search on the array with before the current index (count) and compare it with the envelope of the current iteration to find the bigger value.
     * If the envelope of the current iteration is greater than dp[mid] - that is, the height value stored at the last count - increases the left because it means the mid envelope can be placed in the current iteration envelope.
     * If not, it means the current middle envelope cannot be put into envelope, so reduce right.
     * If the left becomes greater than or equal to right, that is, if the left is an envelope that can be put in the current iteration envelope, terminate the iteration and put the envelope's value in the left index in the dp array.
     * If the left equals the count - that is, if you can put the previous envelope - then increase the count.
     */
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (first, second) ->
                (first[0] == second[0]) ? Integer.compare(second[1], first[1]) : Integer.compare(first[0], second[0])
        );

        int[] dp = new int[envelopes.length];
        int count = 0;
        for (int[] envelope : envelopes) {
            int left = 0, right = count;

            while (left < right) {
                int mid = left + (right - left) / 2;

                if (dp[mid] < envelope[1]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            dp[left] = envelope[1];

            if (left == count) {
                count++;
            }
        }

        return count;
    }
}
