package dp;

public class LeetCode_474 {
    public static void main(String[] args) {
        LeetCode_474 leetcode = new LeetCode_474();
        String[] strs = {"10", "0001", "111001", "1", "0"};
        int m = 5, n = 3;
        System.out.println(leetcode.findMaxForm(strs, m, n));
    }

    /**
     * @param strs array of binary strings
     * @param m minimum number of '0' to be included in the strs
     * @param n minimum number of '1' to be included in the strs
     * @return size of the largest subset of strs such that there at more m 0 & n 1 in the subset
     *
     * Solution - Dynamic programming
     * Time Complexity : O(str * mn)
     * Space Complexity : O(mn)
     *
     * Use dynamic programming with matrices representing the number of bits in a subset.
     * Use a two-dimensional array dp[][] to verify the subset bit count dynamically.
     * The rows and columns of the array represent m and n.
     * The value of an array represents the number of cases of reachable object in when the subtracted bit count of subset(0, 1) from the current value(i, j).
     * Finds the binary count value of the subset at each iteration and updates the array in that binary count value can be entered (values from the obtained value to m/n).
     * If the current array value(i, j) is greater than value of current - bit count + 1, this subset is an unavailable at i, j.
     * Because if the (current - bit count) + 1 is smaller than current, it means specific subset that the current value contains does not contain at next value.
     * If not, replace the current array value to the available value (i - 0 count / j - 1 count) plus 1 (because the number of moveable cases has increased).
     * After all subsets check, return dp[m][n].
     */
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

        for (String str : strs) {
            int[] countedBits = countsBit(str);

            for (int i = m; i >= countedBits[0]; i--) {
                for (int j = n; j >= countedBits[1]; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - countedBits[0]][j - countedBits[1]] + 1);
                }
            }
        }

        return dp[m][n];
    }

    private static int[] countsBit(String s) {
        int[] countedBits = new int[2];

        for (char c : s.toCharArray()) {
            countedBits[c - '0']++;
        }

        return countedBits;
    }
}
