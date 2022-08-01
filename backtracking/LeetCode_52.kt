package backtracking

class LeetCode_52 {

    /**
     * Solution - Backtracking
     * Time Complexity : O(N^2)
     * Space Complexity : O(N)
     *
     * Solve the famous N-Queens puzzle using backtracking.
     * Use the boolean array which means chessboard to remember where you visited.
     * Now let's talk about the backtracking function.
     * If we have reached the end of the board without failing on any valid checks, we have found one complete board state.
     * Add it to the count and explore other possible boards.
     * When bool board doesn't check, it means it's possible place a queen - so place the queen and valid it.
     * When valid fun, Go up from the current the row and find if any queens exist.
     * After that, check left & right diagonal for queen.
     * The reason why only search the upside is that we search the chessboard sequentially, so there is no Queen below Queen now.
     * If it is the correct queens position, increase the count.
     *
     * @param n number of queens
     * @return number of distinct solutions to the n-queens puzzle
     */
    fun totalNQueens(n: Int): Int {
        val generatedArray = Array(n) { BooleanArray(n) }
        return backtracking(generatedArray, 0)
    }

    private fun backtracking(board: Array<BooleanArray>, queens: Int): Int {
        if (queens == board.size) {
            return 1
        }

        var count = 0
        for (i in 0 until board[queens].size) {
            if (!board[queens][i]) {
                if (isValid(board, queens, i)) {
                    board[queens][i] = true
                    count += backtracking(board, queens + 1)
                    board[queens][i] = false
                }
            }
        }

        return count
    }

    private fun isValid(board: Array<BooleanArray>, row: Int, col: Int): Boolean {
        for (i in row - 1 downTo 0) {
            if (board[i][col]) {
                return false
            }
        }

        var rowNum = row - 1
        var colNum = col - 1
        while (rowNum >= 0 && colNum >= 0) {
            if (board[rowNum--][colNum--]) {
                return false
            }
        }

        rowNum = row - 1
        colNum = col + 1
        while (colNum < board[0].size && rowNum >= 0) {
            if (board[rowNum--][colNum++]) {
                return false
            }
        }

        return true
    }
}

fun main() {
    val leetCode = LeetCode_52()
    val n = 4
    println(leetCode.totalNQueens(n))
}