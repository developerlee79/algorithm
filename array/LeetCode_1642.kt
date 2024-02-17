package array

import java.util.PriorityQueue

class LeetCode_1642 {

    fun furthestBuilding(heights: IntArray, bricks: Int, ladders: Int): Int {
        val buildingHeightQueue = PriorityQueue<Int>()
        var leftBricks = bricks

        var count = 0

        for (i in 0 until heights.size - 1) {
            if (heights[i] >= heights[i + 1]) {
                count++
                continue
            }

            val requireBricks = heights[i + 1] - heights[i]

            buildingHeightQueue.add(requireBricks)

            if (buildingHeightQueue.size > ladders) {
                val lowestHeight = buildingHeightQueue.poll()

                if (leftBricks < lowestHeight) {
                    break
                }

                leftBricks -= lowestHeight
                count++
            }
        }

        return count + buildingHeightQueue.size
    }
}

fun main() {
    // Input
    val heights = intArrayOf(4, 12, 2, 7, 3, 18, 20, 3, 19)
    val bricks = 10
    val ladders = 2
    // Output
    LeetCode_1642().furthestBuilding(heights, bricks, ladders).run {
        println(this)
        require(7 == this)
    }
}
