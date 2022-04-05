package graph;

public class leetcode_463 {
    public static void main(String[] args) {
        leetcode_463 leetcode = new leetcode_463();
        int[][] grid = {{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
        System.out.println(leetcode.islandPerimeter(grid));
    }

    // Solution - Count edge (Brute-force)
    // Time Complexity - O(N)
    // Space Complexity - O(1)
    // Count every 'valid' edge of island.
    // if this row or above row is 0(empty), top edge is 'valid' edge
    // if this row or left row is 0(empty), left edge is 'valid' edge
    // if this is the last line or beneath row is 0(empty), bottom edge is 'valid' edge
    // if this is the last column or right row is 0(empty), right edge is 'valid' edge
    public int islandPerimeter(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int num = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    if (i == 0 || grid[i - 1][j] == 0) num++;         // Count above
                    if (j == 0 || grid[i][j - 1] == 0) num++;         // Count left
                    if (i == rows - 1 || grid[i + 1][j] == 0) num++;  // Count beneath
                    if (j == cols - 1 || grid[i][j + 1] == 0) num++;  // Count right
                }
            }
        }

        return num;
    }
}
