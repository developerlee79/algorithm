package math

class LeetCode_223 {

    fun computeArea(ax1: Int, ay1: Int, ax2: Int, ay2: Int, bx1: Int, by1: Int, bx2: Int, by2: Int): Int {
        val areaA = (ax2 - ax1) * (ay2 - ay1)
        val areaB = (bx2 - bx1) * (by2 - by1)

        val left = ax1.coerceAtLeast(bx1)
        val right = ax2.coerceAtMost(bx2)
        val bottom = ay1.coerceAtLeast(by1)
        val top = ay2.coerceAtMost(by2)

        return (areaA + areaB).minus(
            if (right > left && top > bottom)
                (right - left) * (top - bottom)
            else 0
        )
    }
}

fun main() {
    // Input
    val rectangleA = arrayOf(
        Pair(-3, 0), // ax1, ay1
        Pair(3, 4),  // ax2, ay2
    )
    val rectangleB = arrayOf(
        Pair(0, -1), // bx1, by1
        Pair(9, 2),  // bx2, by2
    )
    // Output
    val result = LeetCode_223().computeArea(
        ax1 = rectangleA.first().first,
        ay1 = rectangleA.first().second,

        ax2 = rectangleA.last().first,
        ay2 = rectangleA.last().second,

        bx1 = rectangleB.first().first,
        by1 = rectangleB.first().second,

        bx2 = rectangleB.last().first,
        by2 = rectangleB.last().second
    )
    println(result)
    require(result == 45)
}
