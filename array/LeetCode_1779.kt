package array

import kotlin.math.abs

class LeetCode_1779 {

    /**
     * Solution - Iteration
     * Time Complexity : O(N)
     * Space Complexity : O(1)
     *
     * Compare Manhattan distances in every iteration.
     *
     * @param x abscissa on a Cartesian grid
     * @param y ordinate on a Cartesian grid
     * @param points 2D array which each points[i] = [ai, bi] represents that a point exists at (ai, bi)
     * @return index (0-indexed) of the valid point with the smallest Manhattan distances from your current location
    */
    fun nearestValidPoint(x: Int, y: Int, points: Array<IntArray>): Int {
        var nearestPoint = Integer.MAX_VALUE
        var nearestIndex = -1

        for (i in points.indices) {
            if (x == points[i][0] || y == points[i][1]) {
                val manhattanDistance = abs(x - points[i][0]) + abs(y - points[i][1])

                if (manhattanDistance < nearestPoint) {
                    nearestIndex = i
                    nearestPoint = manhattanDistance
                }
            }
        }

        return nearestIndex
    }
}

fun main() {
    val x = 3
    val y = 4
    val points = arrayOf(
        intArrayOf(1, 2),
        intArrayOf(3, 1),
        intArrayOf(2, 4),
        intArrayOf(2, 3),
        intArrayOf(4, 4)
    )
    println(LeetCode_1779().nearestValidPoint(x, y, points))
}
