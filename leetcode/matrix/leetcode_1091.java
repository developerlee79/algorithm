package leetcode.matrix;

import java.util.*;

public class leetcode_1091 {
    public static void main(String[] args) {
        leetcode_1091 leetcode = new leetcode_1091();
        int[][] grid = {{0, 0, 0}, {1, 1, 0}, {1, 1, 0}};
        System.out.println(leetcode.shortestPathBinaryMatrix(grid));
    }

    /**
     * @param grid Binary matrix
     * @return Length of the shortest clear path (all visited cell of path are 0) in the matrix
     *
     * Solution - BFS
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     *
     * Search the matrix with a BFS.
     * Advance in any of the eight directions (not the end of the matrix and the value != 1) and mark the value.
     * Increase the count by 1 each time you move the matrix.
     * Returns the count when the destination is reached.
     */
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid == null || grid[0][0] != 0 || grid[grid.length - 1][grid[0].length - 1] != 0) {
            return -1;
        }

        Queue<int[]> pathQueue = new LinkedList<>();
        pathQueue.add(new int[]{0, 0, 0});

        while (!pathQueue.isEmpty()) {
            int[] cell = pathQueue.poll();

            if (cell[0] == grid.length - 1 && cell[1] == grid[0].length - 1) {
                return cell[2] + 1;
            }

            for (int[] dir : direction) {
                int x = cell[0] + dir[0];
                int y = cell[1] + dir[1];

                if (isCollectDirection(x, y, grid))
                    continue;

                grid[x][y] = 1;
                pathQueue.add(new int[]{x, y, cell[2] + 1});
            }
        }

        return -1;
    }

    int[][] direction = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, -1}, {-1, 1}, {-1, -1}, {1, 1}};

    private boolean isCollectDirection(int x, int y, int[][] grid) {
        return (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] != 0);
    }
}
