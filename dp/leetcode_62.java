package dp;

public class leetcode_62 {
    public static void main(String[] args) {
        leetcode_62 leetcode = new leetcode_62();
        int m = 23, n = 12;
        System.out.println(leetcode.uniquePaths(m, n));
    }

    public int uniquePaths(int m, int n) {
        return dp(m - 1, n - 1, new int[m][n]);
    }

    // Solution - Dynamic Programming
    // Time Complexity : O(N)
    // Space Complexity : O(N)
    // Simple DP problem.
    // The robot can only move to either down / right direction.
    // So we can just use back-tracking to tracking robot move??
    // Cool.. just write the code.. and submit it - Time Out!
    // It looks easy, but without Memorization, Time Out occurs.
    // Let's use the Memorization technique to solve the problem.
    // Start at the [m--][n--] for a readable code.
    // The robot can only move to the right and down.
    // It recursively moves to the right and down, adding 1 to the grid if it reaches the goal.
    // If there's a value in the forward column, it means there are ONLY have as many cases as that.
    // Because the value of that column is the number of cases what paths that have already progressed to goal are recursively returned and added.
    // So don't go further in that direction just use that value.
    int dp(int m, int n, int[][] grid) {
        if (m == 0 & n == 0)
            return 1;
        if (m < 0 | n < 0)
            return 0;
        if (grid[m][n] != 0)
            return grid[m][n];
        else
            return grid[m][n] = dp(m - 1, n, grid) + dp(m, n - 1, grid);
    }
}
