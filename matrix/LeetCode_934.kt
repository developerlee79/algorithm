package matrix

import java.util.LinkedList
import java.util.Queue

class LeetCode_934 {

    private val directions = arrayOf(
        intArrayOf(1, 0),
        intArrayOf(-1, 0),
        intArrayOf(0, 1),
        intArrayOf(0, -1),
    )

    fun shortestBridge(grid: Array<IntArray>): Int {
        val gridQueue: Queue<Pair<Int, Int>> = LinkedList()
        val visited = Array(grid.size) { BooleanArray(grid[0].size) }

        for (i in grid.indices) {
            for (j in grid[i].indices) {
                if (grid[i][j] == 1) {
                    addAllConnectedIsland(i, j, grid, gridQueue, visited)
                    break
                }
            }
            if (gridQueue.isNotEmpty()) {
                break
            }
        }

        var depth = 0

        while (gridQueue.isNotEmpty()) {
            val currentSize = gridQueue.size

            repeat(currentSize) {
                val currentNode = gridQueue.poll()

                directions.forEach {
                    val x = currentNode.first + it[0]
                    val y = currentNode.second + it[1]

                    if (x in grid.indices && y in grid[x].indices && !visited[x][y]) {
                        if (grid[x][y] == 1) {
                            return depth
                        }

                        gridQueue.add(Pair(x, y))
                        visited[x][y] = true
                    }
                }
            }

            depth++
        }

        return depth
    }

    private fun addAllConnectedIsland(i: Int, j: Int, grid: Array<IntArray>, queue: Queue<Pair<Int, Int>>, visited: Array<BooleanArray>) {
        if (i !in grid.indices || j !in grid[i].indices || visited[i][j] || grid[i][j] == 0) {
            return
        }

        queue.add(Pair(i, j))
        visited[i][j] = true

        addAllConnectedIsland(i + 1, j, grid, queue, visited)
        addAllConnectedIsland(i - 1, j, grid, queue, visited)
        addAllConnectedIsland(i, j + 1, grid, queue, visited)
        addAllConnectedIsland(i, j - 1, grid, queue, visited)
    }
}

fun main() {
    // Input
    val grid = arrayOf(
        intArrayOf(0, 1),
        intArrayOf(1, 0),
    )
    // Output
    LeetCode_934().shortestBridge(grid).run {
        println(this)
        require(this == 1)
    }
}
