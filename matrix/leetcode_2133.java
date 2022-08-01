package matrix;

public class leetcode_2133 {
    public static void main(String[] args) {
        leetcode_2133 leetcode = new leetcode_2133();
        int[][] matrix = {{1, 2, 3}, {3, 1, 2}, {2, 3, 1}};
        System.out.println(leetcode.checkValid(matrix));
    }

    // Solution - Brute force + memorization
    // Time Complexity : O(N)
    // Space Complexity : O(N)
    // Initialize boolean array rows and cols in every row iterative(i loop)
    // In the j loop, check rows[i][j] & cols[j][i] and checked that it appears - it's gonna be like this
    // Example(valid matrix) - first i loop
    // 1 2 3   i = 0, j = 0 | rows[1] = false, cols[1] = false -> Toggled to true
    // 3 1 2   i = 0, j = 1 | rows[2] = false, cols[3] = false -> Toggled to true
    // 2 3 1   i = 0, j = 2 | rows[3] = false, cols[2] = false -> Toggled to true, loop end
    // Example(illegal matrix) - first i loop
    // 2 2 3   i = 0, j = 0 | rows[2] = false, cols[2] = false -> Toggled to true
    // 2 1 2   i = 0, j = 1 | rows[2] = true -> return false
    // if there's no duplicate row/column until loop ends, this matrix is valid matrix.
    public boolean checkValid(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            boolean[] rows = new boolean[n + 1];
            boolean[] cols = new boolean[n + 1];

            for (int j = 0; j < n; j++) {
                if (rows[matrix[i][j]] || cols[matrix[j][i]])
                    return false;
                rows[matrix[i][j]] = cols[matrix[j][i]] = true;
            }
        }

        return true;
    }
}
