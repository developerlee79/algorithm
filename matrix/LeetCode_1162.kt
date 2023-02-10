package matrix

import java.util.LinkedList
import java.util.Queue

class LeetCode_1162 {

    private class Cell(
        val x: Int,
        val y: Int,
        val count: Int = 0
    )

    private val directions = arrayOf(
        Pair(1, 0),
        Pair(0, 1),
        Pair(-1, 0),
        Pair(0, -1)
    )

    fun maxDistance(grid: Array<IntArray>): Int {
        val queue: Queue<Cell> = LinkedList()
        val visited = Array(grid.size) { BooleanArray(grid[0].size) }

        grid.forEachIndexed { i, row ->
            row.forEachIndexed { j, col ->
                if (col == 1) {
                    visited[i][j] = true
                    queue.add(Cell(i, j))
                }
            }
        }

        if (queue.isEmpty() || queue.size == grid.size * grid[0].size) {
            return -1
        }

        val n = grid.indices
        val m = grid[0].indices

        var maxInterval = -1

        while (queue.isNotEmpty()) {
            val cell = queue.poll()
            maxInterval = maxOf(maxInterval, cell.count)

            directions.forEach {
                val x = cell.x + it.first
                val y = cell.y + it.second

                if (x in n && y in m && !visited[x][y] && grid[x][y] == 0) {
                    visited[x][y] = true
                    queue.add(Cell(x, y, cell.count + 1))
                }
            }
        }

        return maxInterval
    }
}

fun main() {
    // Input
    val grid = arrayOf(
        intArrayOf(1, 0, 1),
        intArrayOf(0, 0, 0),
        intArrayOf(1, 0, 1),
    )
    // Output
    LeetCode_1162().maxDistance(grid).let {
        println(it)
        require(it == 2)
    }
}
