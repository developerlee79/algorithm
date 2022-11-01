package matrix

class LeetCode_1706 {

    /**
     * Time Complexity : O(MN)
     * Space Complexity : O(N)
     *
     * Save the current position of the ball with an N-sized index storage array.
     * Check the conditions under which the ball stops at each iteration, and save it in the index storage array if it has moved to a valid position.
     *
     * @param grid 2D grid of size m x n representing a box
     * @return Return an array answer of size n where answer[i] is the column that the ball falls out of at the bottom after dropping the ball from the ith column at the top, or -1 if the ball gets stuck in the box
    */
    fun findBall(grid: Array<IntArray>): IntArray {
        val gridSize = grid.first().size

        val coordinateArray = IntArray(gridSize)

        repeat(coordinateArray.size) {i ->
            coordinateArray[i] = i
        }

        grid.forEach {
            it.forEachIndexed { index, _ ->
                val currentIndex = coordinateArray[index]

                if (currentIndex == -1) {
                    return@forEachIndexed
                }

                val nextIndex = currentIndex + it[currentIndex]

                coordinateArray[index] = if (nextIndex in it.indices && it[currentIndex] == it[nextIndex]) {
                    nextIndex
                } else {
                    -1
                }
            }
        }

        return coordinateArray
    }
}

fun main() {
    // Input
    val grid = arrayOf(
        intArrayOf(1, 1, 1, -1, -1),
        intArrayOf(1, 1, 1, -1, -1),
        intArrayOf(-1, -1, -1, 1, 1),
        intArrayOf(1, 1, 1, 1, -1),
        intArrayOf(-1, -1, -1, -1, -1)
    )
    // Output
    val result = LeetCode_1706().findBall(grid)
    println(result.joinToString())
    require(
        result.contentEquals(
            intArrayOf(1, -1, -1, -1, -1)
        )
    )
}
