package array

class LeetCode_1232 {

    private var xSlope: Int = 0
    private var ySlope: Int = 0

    /**
     * Solution - Compare
     * Time Complexity : O(N)
     * Space Complexity : O(1)
     *
     * Solve the problem with simple math.
     * Set x and y to the reference slope.
     * If x multiplied by reference y in two coordinates is not equal to y multiplied by reference x, that is, if the reference coordinates and the ratio are different, return false because they are not straight.
     * Check all coordinates and return true if there is no abnormality.
     *
     * @param coordinates coordinates
     * @return Is these coordinates make a straight line in the XY plane?
     */
    fun checkStraightLine(coordinates: Array<IntArray>): Boolean {
        xSlope = coordinates[1][0] - coordinates[0][0]
        ySlope = coordinates[1][1] - coordinates[0][1]

        for (i in 1 until coordinates.size - 1) {
            if (!isLined(coordinates[i], coordinates[i + 1])) {
                return false
            }
        }

        return true
    }

    private fun isLined(firstCoordinate: IntArray, secondCoordinate: IntArray): Boolean {
        return xSlope * (secondCoordinate[1] - firstCoordinate[1]) == ySlope * (secondCoordinate[0] - firstCoordinate[0])
    }
}

fun main() {
    val coordinates = arrayOf(intArrayOf(1, 2), intArrayOf(2, 3), intArrayOf(3, 4), intArrayOf(4, 5), intArrayOf(5, 6), intArrayOf(6, 7))
    val leetCode = LeetCode_1232()
    println(leetCode.checkStraightLine(coordinates))
}