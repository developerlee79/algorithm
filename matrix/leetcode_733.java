package matrix;

import java.util.Arrays;

public class leetcode_733 {
    public static void main(String[] args) {
        leetcode_733 leetcode = new leetcode_733();
        int[][] image = {{0, 0, 0}, {0, 1, 0}};
        int sr = 1, sc = 1, newColor = 2;
        System.out.println(Arrays.deepToString(leetcode.floodFill(image, sr, sc, newColor)));
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        boolean[][] visited = new boolean[image.length][image[0].length];
        dfs(image, sr, sc, image[sr][sc], newColor, visited);
        return image;
    }

    // Solution - DFS
    // Time Complexity : O(MN)
    // Space Complexity : O(MN)
    // Simple depth search.
    // start with matrix[x][y] which is start point.
    // repeat paint -> check visited -> 4-directionally recursive
    // Escape : pixel that already visited / pixel that doesn't match the color / pointer over the matrix
    private void dfs(int[][] matrix, int x, int y, int color, int newColor, boolean[][] visited) {
        if (x >= matrix.length || y >= matrix[0].length || x < 0 || y < 0 || visited[x][y] || matrix[x][y] != color) {
            return;
        }

        matrix[x][y] = newColor;
        visited[x][y] = true;

        dfs(matrix, x + 1, y, color, newColor, visited);
        dfs(matrix, x - 1, y, color, newColor, visited);
        dfs(matrix, x, y + 1, color, newColor, visited);
        dfs(matrix, x, y - 1, color, newColor, visited);
    }
}
