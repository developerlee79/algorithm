package matrix

class LeetCode_417 {

    /**
     * Solution - DFS
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     *
     * @param heights m x n rectangular island that borders both the Pacific Ocean and Atlantic Ocean
     * @return 2D list of grid coordinates result where result[i] = [ri, ci] denotes that rain water can flow from cell (ri, ci) to both the Pacific and Atlantic oceans
     */
    fun pacificAtlantic(heights: Array<IntArray>): List<List<Int>> {
        val n = heights.size
        val m = heights[0].size

        val pacific = Array(n) { BooleanArray(m) }
        val atlantic = Array(n) { BooleanArray(m) }

        for (col in 0 until m) {
            search(heights, 0, col, heights[0][col], pacific)
            search(heights, n - 1, col, heights[n - 1][col], atlantic)
        }

        for (row in 0 until n) {
            search(heights, row, 0, heights[row][0], pacific)
            search(heights, row, m - 1, heights[row][m - 1], atlantic)
        }

        val result = mutableListOf<List<Int>>()

        for (i in heights.indices) {
            for (j in heights[i].indices) {
                if (pacific[i][j].and(atlantic[i][j])) {
                    result.add(listOf(i, j))
                }
            }
        }

        return result
    }

    private fun search(heights: Array<IntArray>, x: Int, y: Int, prev: Int, flowable: Array<BooleanArray>) {
        if (x < 0 || y < 0 || x >= heights.size || y >= heights[x].size || flowable[x][y]) {
            return
        }

        val currentValue = heights[x][y]

        if (prev > currentValue) {
            return
        }

        flowable[x][y] = true

        search(heights, x + 1, y, currentValue, flowable)
        search(heights, x - 1, y, currentValue, flowable)
        search(heights, x, y + 1, currentValue, flowable)
        search(heights, x, y - 1, currentValue, flowable)
    }
}

fun main() {
    val heights = arrayOf(
        intArrayOf(1, 2, 2, 3, 5),
        intArrayOf(3, 2, 3, 4, 4),
        intArrayOf(2, 4, 5, 3, 1),
        intArrayOf(6, 7, 1, 4, 5),
        intArrayOf(5, 1, 1, 2, 4)
    )
    println(LeetCode_417().pacificAtlantic(heights))
}
