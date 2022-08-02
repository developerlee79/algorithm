package matrix

class LeetCode_36 {
    /**
     * Solution - Set
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     *
     * Use set to record values for horizontal, vertical, and sudoku columns, and return false if they do not comply with sudoku rules.
     *
     * @param board 9x9 sudoku board
     * @return Return Value Of This Function
    */
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        val set = mutableSetOf<String>()

        for (row in board.indices) {
            for (col in board[row].indices) {
                val value = board[row][col]

                if (value != '.') {
                    val block = (row / 3 * 3) + (col / 3)

                    if (invalidBoard(set, value, row, col, block)) {
                        return false
                    }

                    set.add("r$row$value")
                    set.add("c$col$value")
                    set.add("b$block$value")
                }
            }
        }

        return true
    }

    private fun invalidBoard(set: Set<String>, value: Char, row: Int, col: Int, block: Int): Boolean {
        return set.contains("r$row$value") || set.contains("c$col$value") || set.contains("b$block$value")
    }
}

fun main() {
    val board = arrayOf(
        charArrayOf('5', '3', '.', '.', '7', '.', '.', '.', '.'),
        charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
        charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
        charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
        charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
        charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
        charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
        charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
        charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9'),
    )
    println(LeetCode_36().isValidSudoku(board))
}
