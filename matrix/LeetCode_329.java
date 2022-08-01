package matrix;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode_329 {
    public static void main(String[] args) {
        LeetCode_329 leetcode = new LeetCode_329();
        int[][] matrix = {{9, 9, 4}, {6, 6, 8}, {2, 1, 1}};
        System.out.println(leetcode.longestIncreasingPath(matrix));
        System.out.println(leetcode.longestIncreasingPathBFS(matrix));
    }

    /**
     * @param matrix m x n integer matrix
     * @return length of the longest increasing path in matrix
     *
     * Solution - DFS + Memorization
     * Time Complexity : O(mn)
     * Space Complexity : O(mn)
     *
     * Search the matrix with DFS + Memorization
     * If there is a visitable row, search with DFS and compare the results with the current length to find the longest path at the current starting point.
     * After the searching, insert the current value at memorization array to returned immediately at the next navigation.
     */
    public int longestIncreasingPath(int[][] matrix) {
        int maxLength = 0;

        int[][] visited = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (visited[i][j] == 0) {
                    maxLength = Math.max(maxLength, dfs(matrix, visited, i, j));
                }
            }
        }

        return maxLength;
    }

    private int dfs(int[][] matrix, int[][] visited, int x, int y) {
        if (visited[x][y] != 0) {
            return visited[x][y];
        }

        int count = 1;
        for (int[] direction : DIRECTIONS) {
            int nextX = x + direction[0];
            int nextY = y + direction[1];

            if (isCorrectDirection(matrix, nextX, nextY) && isNextNodeBiggerThanCurrentNode(matrix, x, y, nextX, nextY)) {
                count = Math.max(count, dfs(matrix, visited, nextX, nextY) + 1);
            }
        }

        visited[x][y] = count;
        return count;
    }

    /**
     * @param matrix m x n integer matrix
     * @return length of the longest increasing path in matrix
     *
     * Solution - BFS
     * Time Complexity : O(mn^2)
     * Space Complexity : O(mn)
     *
     * Search the matrix with BFS.
     * Add all visitable row to the queue and increasing the count.
     */
    public int longestIncreasingPathBFS(int[][] matrix) {
        int maxLength = 1;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                maxLength = Math.max(maxLength, bfs(matrix, i, j));
            }
        }

        return maxLength;
    }

    private int bfs(int[][] matrix, int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});

        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            count++;

            for (int i = 0; i < size; i++) {
                int[] currentNode = queue.poll();

                for (int[] direction : DIRECTIONS) {
                    int nextX = currentNode[0] + direction[0];
                    int nextY = currentNode[1] + direction[1];

                    if (isCorrectDirection(matrix, nextX, nextY) && isNextNodeBiggerThanCurrentNode(matrix, currentNode[0], currentNode[1], nextX, nextY)) {
                        queue.add(new int[]{nextX, nextY});
                    }
                }
            }
        }

        return count;
    }

    static final int[][] DIRECTIONS = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private static boolean isNextNodeBiggerThanCurrentNode(int[][] matrix, int currentX, int currentY, int nextX, int nextY) {
        return matrix[currentX][currentY] < matrix[nextX][nextY];
    }

    private static boolean isCorrectDirection(int[][] matrix, int x, int y) {
        return !(x < 0 || y < 0 || x >= matrix.length || y >= matrix[x].length);
    }
}
