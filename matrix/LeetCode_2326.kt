package matrix

import util.ListNode

class LeetCode_2326 {

    private val directions = arrayOf(
        intArrayOf(0, 1),
        intArrayOf(1, 0),
        intArrayOf(0, -1),
        intArrayOf(-1, 0),
    )

    fun spiralMatrix(m: Int, n: Int, head: ListNode?): Array<IntArray> {
        val matrix = Array(m) { IntArray(n) { -1 } }

        var head = head

        var i = 0
        var j = 0
        var directionIndex = 0

        while (head != null) {
            val currentValue = head.`val`

            matrix[i][j] = currentValue

            val currentDirection = directions[directionIndex]
            val nextI = i + currentDirection[0]
            val nextJ = j + currentDirection[1]

            if (nextI !in 0 until m || nextJ !in 0 until n || matrix[nextI][nextJ] != -1) {
                directionIndex = changeDirection(directionIndex)
            }

            i += directions[directionIndex][0]
            j += directions[directionIndex][1]

            head = head.next
        }

        return matrix
    }

    private fun changeDirection(directionIndex: Int): Int {
        return if (directionIndex + 1 < directions.size) directionIndex + 1 else 0
    }
}

fun main() {
    // Input
    val m = 3
    val n = 5
    val head = ListNode.create(3, 0, 2, 6, 8, 1, 7, 9, 4, 2, 5, 5, 0)
    // Output
    LeetCode_2326().spiralMatrix(m, n, head).run {
        println(this.contentDeepToString())
        require(
            arrayOf(
                intArrayOf(3, 0, 2, 6, 8),
                intArrayOf(5, 0, -1, -1, 1),
                intArrayOf(5, 2, 4, 9, 7)
            ).contentDeepEquals(this)
        )
    }
}
