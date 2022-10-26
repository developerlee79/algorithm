package dp

class LeetCode_2304 {

    /**
     * Solution : Dynamic Programming
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     *
     * Save the shortest path of cell at distance table.
     * The shortest path from this cell = min(distance table[i + 1]) + move cost to that (min) cell + value of current cell.
     * The smallest value of top cells - it's the min path cost.
     *
     * @param grid 0-indexed m x n integer matrix consisting of distinct integers from 0 to m * n - 1
     * @param moveCost 0-indexed 2D array moveCost of size (m * n) x n, where moveCost[i][j] is the cost of moving from a cell with value i to a cell in column j of the next row
     * @return minimum cost of a path that starts from any cell in the first row and ends at any cell in the last row
    */
    fun minPathCost(grid: Array<IntArray>, moveCost: Array<IntArray>): Int {
        val distanceTable = Array(grid.size) { IntArray(grid[0].size) }

        distanceTable.last().forEachIndexed { index, _ ->
            distanceTable.last()[index] = grid.last()[index]
        }

        for (i in grid.lastIndex - 1 downTo 0) {
            for (j in grid[i].indices) {
                var shortestPath = Integer.MAX_VALUE

                val valueOfCurrentCell = grid[i][j]
                val moveCostToNextCell = moveCost[valueOfCurrentCell]

                for (k in moveCostToNextCell.indices) {
                    shortestPath = minOf(shortestPath, valueOfCurrentCell + distanceTable[i + 1][k] + moveCostToNextCell[k])
                }

                distanceTable[i][j] = shortestPath
            }
        }

        return distanceTable.first().minOf { it }
    }
}

fun main() {
    // Input
    val grid = arrayOf(
        intArrayOf(5, 3),
        intArrayOf(4, 0),
        intArrayOf(2, 1),
    )
    val moveCost = arrayOf(
        intArrayOf(9, 8),
        intArrayOf(1, 5),
        intArrayOf(10, 12),
        intArrayOf(18, 6),
        intArrayOf(2, 4),
        intArrayOf(14, 3),
    )
    // Output
    val result = LeetCode_2304().minPathCost(grid, moveCost)
    println(result)
    require(result == 17)
}
