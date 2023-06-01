package matrix

import java.util.LinkedList
import java.util.Queue

class LeetCode_1091 {

    private val directions = arrayOf(
        intArrayOf(0, 1),
        intArrayOf(0, -1),
        intArrayOf(-1, 0),
        intArrayOf(-1, -1),
        intArrayOf(-1, 1),
        intArrayOf(1, -1),
        intArrayOf(1, 0),
        intArrayOf(1, 1)
    )

    fun shortestPathBinaryMatrix(grid: Array<IntArray>): Int {
        if (grid[0][0] == 1) {
            return -1
        }

        val pathQueue: Queue<Pair<Int, Int>> = LinkedList()
        pathQueue.add(Pair(0, 0))

        var depthCount = 1

        val endX = grid.lastIndex
        val endY = grid[0].lastIndex

        val visited = Array(grid.size) { BooleanArray(grid[0].size) }

        while (pathQueue.isNotEmpty()) {
            val queueSize = pathQueue.size

            repeat(queueSize) {
                val currentCell = pathQueue.poll()

                if (currentCell.first == endX && currentCell.second == endY) {
                    return depthCount
                }

                for (direction in directions) {
                    val nowX = currentCell.first + direction[0]
                    val nowY = currentCell.second + direction[1]

                    if (nowX > endX || nowY > endY || nowX < 0 || nowY < 0 || visited[nowX][nowY] || grid[nowX][nowY] == 1) {
                        continue
                    }

                    visited[nowX][nowY] = true
                    pathQueue.add(Pair(nowX, nowY))
                }
            }

            depthCount++
        }

        return -1
    }
}

fun main() {
    // Input
    val grid = arrayOf(
        intArrayOf(0, 0, 0),
        intArrayOf(1, 1, 0),
        intArrayOf(1, 1, 0)
    )
    // Output
    LeetCode_1091().shortestPathBinaryMatrix(grid).run {
        println(this)
        require(4 == this)
    }
}
