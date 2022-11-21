package matrix

import java.util.LinkedList
import java.util.Queue

class LeetCode_1926 {

    private val directions = arrayOf(
        intArrayOf(0, 1),
        intArrayOf(0, -1),
        intArrayOf(1, 0),
        intArrayOf(-1 ,0)
    )

    /**
     * Solution : Breadth-First Search
     * Time Complexity : O(V + E)
     * Space Complexity : O(N)
     *
     * @param maze m x n matrix maze (0-indexed) with empty cells (represented as '.') and walls (represented as '+')
     * @param entrance entrance of the maze, where entrance = [row, col] denotes the row and column of the cell you are initially standing at
     * @return Return the number of steps in the shortest path from the entrance to the nearest exit, or -1 if no such path exists
     */
    fun nearestExit(maze: Array<CharArray>, entrance: IntArray): Int {
        val rowSize = maze.size
        val colSize = maze.first().size

        val queue: Queue<IntArray> = LinkedList()
        val visited = Array(rowSize) { BooleanArray(colSize) }

        queue.add(entrance)
        visited[entrance.first()][entrance.last()] = true

        var steps = 0
        while (queue.isNotEmpty()) {
            steps++

            repeat(queue.size) {
                val currentBlock = queue.poll()

                for (direction in directions) {
                    val x = direction.first() + currentBlock.first()
                    val y = direction.last() + currentBlock.last()

                    if (x < 0 || y < 0 || x >= rowSize || y >= colSize || visited[x][y] || maze[x][y] == '+') {
                        continue
                    }

                    if (x == 0 || y == 0 || x == rowSize - 1 || y == colSize - 1) {
                        return steps
                    }

                    queue.add(intArrayOf(x, y))
                    visited[x][y] = true
                }
            }
        }

        return -1
    }
}

fun main() {
    // Input
    val maze = arrayOf(
        charArrayOf('+', '.', '+', '+', '+', '+', '+'),
        charArrayOf('+', '.', '+', '.', '.', '.', '+'),
        charArrayOf('+', '.', '+', '.', '+', '.', '+'),
        charArrayOf('+', '.', '.', '.', '.', '.', '+'),
        charArrayOf('+', '+', '+', '+', '.', '+', '.'),
    )
    val entrance = intArrayOf(0, 1)
    // Output
    val result = LeetCode_1926().nearestExit(maze, entrance)
    println(result)
    require(result == 7)
}
