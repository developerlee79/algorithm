package backtracking

class LeetCode_79 {

    /**
     * Solution : Backtracking
     * Time Complexity : O(NlogN)
     * Space Complexity : O(N)
     *
     * @param board m x n grid of characters
     * @param word string
     * @return return true if word exists in the grid
    */
    fun exist(board: Array<CharArray>, word: String): Boolean {
        val visited = Array(board.size) { BooleanArray(board.first().size) }

        board.forEachIndexed { rowIndex, rows ->
            rows.forEachIndexed rowEach@{ colIndex, c ->
                if (word.first() == c && search(board, word, 0, rowIndex, colIndex, visited)) {
                    return true
                }
            }
        }

        return false
    }

    private fun search(
        board: Array<CharArray>,
        word: String,
        charIndex: Int,
        row: Int,
        col: Int,
        visited: Array<BooleanArray>
    ): Boolean =
        if (charIndex == word.length) {
            true
        } else if (row < 0 || col < 0 || row >= board.size || col >= board[row].size || visited[row][col] || board[row][col] != word[charIndex]) {
            false
        } else {
            visited[row][col] = true
            (search(board, word, charIndex + 1, row - 1, col, visited)
                    or search(board, word, charIndex + 1, row + 1, col, visited)
                    or search(board, word, charIndex + 1, row, col - 1, visited)
                    or search(board, word, charIndex + 1, row, col + 1, visited))
                .also { if (!it) visited[row][col] = false }
        }
}

fun main() {
    // Input
    val board = arrayOf(
        charArrayOf('A', 'B', 'C', 'E'),
        charArrayOf('S', 'F', 'C', 'S'),
        charArrayOf('A', 'D', 'E', 'E'),
    )
    val word = "ABCCED"
    // Output
    val result = LeetCode_79().exist(board, word)
    println(result)
    require(result)
}
