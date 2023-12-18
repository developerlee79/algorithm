package matrix

class LeetCode_296 {

    fun minTotalDistance(grid: Array<IntArray>): Int {
        val n = grid.size
        val m = grid[0].size

        val xCoordinates = mutableListOf<Int>()
        val yCoordinates = mutableListOf<Int>()

        for (i in 0 until n) {
            for (j in 0 until m) {
                if (grid[i][j] == 1) {
                    xCoordinates.add(i)
                    yCoordinates.add(j)
                }
            }
        }

        return findMedian(xCoordinates) + findMedian(yCoordinates)
    }

    private fun findMedian(coordinates: List<Int>): Int {
        val coordinates = coordinates.sorted()

        var i = 0
        var j = coordinates.lastIndex
        var sumOfMedian = 0

        while (i < j) {
            sumOfMedian += coordinates[j--] - coordinates[i++]
        }

        return sumOfMedian
    }
}

fun main() {
    // Input
    val grid = arrayOf(
        intArrayOf(1, 0, 0, 0, 1),
        intArrayOf(0, 0, 0, 0, 0),
        intArrayOf(0, 0, 1, 0, 0),
    )
    // Output
    LeetCode_296().minTotalDistance(grid).run {
        println(this)
        require(6 == this)
    }
}
