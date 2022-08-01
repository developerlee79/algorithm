package matrix;

import java.util.Arrays;

public class leetcode_59 {
    public static void main(String[] args) {
        leetcode_59 leetcode = new leetcode_59();
        System.out.println(Arrays.deepToString(leetcode.generateMatrix(2)));
    }

    // Solution - Change direction
    // Time Complexity : O(N^2)
    // Space Complexity : O(N)
    // Start with two value rowDir & colDir
    int rowDir = 0, colDir = 1;
    // int count continues to increment and inserts the value into the matrix[row][col]
    // tempRow / tempCol add row / col with rowDir / colDir to check it's the end of the array or if a matrix has already passed
    // if the next route is wrong, it should be 'changeDirection'
    // 'changeDirection' use rowDir & colDir as direction indicators
    // after 'changeDirection', add rowDir & colDir at row & col to move pointer by direction
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];

        int count = 1, row = 0, col = 0;
        while (count <= n * n) {
            matrix[row][col] = count;

            int tempRow = row + rowDir;
            int tempCol = col + colDir;

            if (tempRow < 0 || tempCol < 0 || tempRow == n || tempCol == n || matrix[tempRow][tempCol] != 0) {
                changeDirection();
            }

            row += rowDir;
            col += colDir;

            count++;
        }

        return matrix;
    }

    private void changeDirection() {
        if (rowDir == 0 && colDir == 1) {
            // before direction = right -> have to go down
            colDir = 0;
            rowDir = 1;
        } else if (rowDir == 1 && colDir == 0) {
            // before direction = down -> have to go left
            colDir = -1;
            rowDir = 0;
        } else if (rowDir == 0 && colDir == -1) {
            // before direction = left -> have to go up
            colDir = 0;
            rowDir = -1;
        } else if (rowDir == -1 && colDir == 0) {
            // before direction = up -> have to go right
            colDir = 1;
            rowDir = 0;
        }
    }
}
