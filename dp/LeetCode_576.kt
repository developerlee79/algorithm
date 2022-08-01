package dp


class LeetCode_576 {

    /**
     * Solution - 3D Array (Dynamic Programming)
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     *
     * Use a three-dimensional array to store previous moves.
     *
     * @param m height of grid
     * @param n width of grid
     * @param maxMove maximum move range
     * @param startRow starting row in matrix
     * @param startColumn starting column in matrix
     * @return number of paths to move the ball out of the grid boundary (modulo 10^9 + 7)
    */
    fun findPaths(m: Int, n: Int, maxMove: Int, startRow: Int, startColumn: Int): Int {
        if (maxMove <= 0) return 0

        val mod = 1000000007

        var count = Array(m) { IntArray(n) }
        count[startRow][startColumn] = 1

        val dirs = arrayOf(intArrayOf(-1, 0), intArrayOf(1, 0), intArrayOf(0, -1), intArrayOf(0, 1))
        var result = 0

        for (step in 0 until maxMove) {
            val temp = Array(m) { IntArray(n) }

            for (r in 0 until m) {
                for (c in 0 until n) {
                    for (d in dirs) {
                        val nr = r + d[0]
                        val nc = c + d[1]
                        if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                            result = (result + count[r][c]) % mod
                        } else {
                            temp[nr][nc] = (temp[nr][nc] + count[r][c]) % mod
                        }
                    }
                }
            }
            count = temp
        }

        return result
    }
}

fun main() {
    val m = 2
    val n = 2
    val maxMove = 2
    val startRow = 0
    val startColumn = 0
    println(LeetCode_576().findPaths(m, n, maxMove, startRow, startColumn))
}
