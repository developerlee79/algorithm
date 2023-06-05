package array

class LeetCode_1232 {

    fun checkStraightLine(coordinates: Array<IntArray>): Boolean {
        val xSlope = coordinates[1][0] - coordinates[0][0]
        val ySlope = coordinates[1][1] - coordinates[0][1]

        for (i in 1 until coordinates.size - 1) {
            if (!isLined(coordinates[i], coordinates[i + 1], xSlope, ySlope)) {
                return false
            }
        }

        return true
    }

    private fun isLined(firstCoordinate: IntArray, secondCoordinate: IntArray, xSlope: Int, ySlope: Int): Boolean {
        return xSlope * (secondCoordinate[1] - firstCoordinate[1]) == ySlope * (secondCoordinate[0] - firstCoordinate[0])
    }
}

fun main() {
    val coordinates = arrayOf(
        intArrayOf(1, 2),
        intArrayOf(2, 3),
        intArrayOf(3, 4),
        intArrayOf(4, 5),
        intArrayOf(5, 6),
        intArrayOf(6, 7),
    )
    LeetCode_1232().checkStraightLine(coordinates).run {
        println(this)
        require(this)
    }
}