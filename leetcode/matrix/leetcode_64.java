package leetcode.matrix;

public class leetcode_64 {
    public static void main(String[] args) {
        leetcode_64 lc = new leetcode_64();
        int[][] grid = {{1, 2, 3}, {4, 5, 6}};
        System.out.println(lc.minPathSum(grid));
    }

    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        return getMin(grid, dp, 0, 0);
    }

    static int getMin(int[][] grid, int[][] dp, int x, int y) {
        if (dp[x][y] != 0) {
            return dp[x][y];
        } else if (grid.length == x + 1 && grid[x].length == y + 1) {
            return dp[x][y] + grid[x][y];
        } else if (grid.length <= x + 1 && grid[x].length > y + 1) {
            return dp[x][y] = grid[x][y] + getMin(grid, dp, x, y + 1);
        } else if (grid.length > x + 1 && grid[x].length <= y + 1) {
            return dp[x][y] = grid[x][y] + getMin(grid, dp, x + 1, y);
        } else {
            return dp[x][y] = grid[x][y] + Math.min(getMin(grid, dp, x + 1, y), getMin(grid, dp, x, y + 1));
        }
    }
}
