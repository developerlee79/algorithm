package matrix

import java.util.LinkedList
import java.util.Queue

class LeetCode_542 {

    private val directions = arrayOf(
        intArrayOf(1, 0),
        intArrayOf(0, 1),
        intArrayOf(-1, 0),
        intArrayOf(0, -1),
    )

    fun updateMatrix(mat: Array<IntArray>): Array<IntArray> {
        val n = mat.size
        val m = mat[0].size

        val queue: Queue<Pair<Int, Int>> = LinkedList()
        val resultArray = Array(n) { IntArray(m) }

        val maxValue = (n - 1) + (m - 1)

        for (i in mat.indices) {
            for (j in mat[i].indices) {
                if (mat[i][j] == 0) {
                    queue.add(Pair(i, j))
                } else {
                    resultArray[i][j] = maxValue
                }
            }
        }

        while (queue.isNotEmpty()) {
            val currentCell = queue.poll()

            directions.forEach { direction ->
                val x = currentCell.first + direction[0]
                val y = currentCell.second + direction[1]

                val distanceOfCurrentCell = resultArray[currentCell.first][currentCell.second]

                if (isInRange(x, n) && isInRange(y, m) && resultArray[x][y] > distanceOfCurrentCell + 1) {
                    queue.add(Pair(x, y))
                    resultArray[x][y] = distanceOfCurrentCell + 1
                }
            }
        }

        return resultArray
    }

    private fun isInRange(target: Int, max: Int) = target in 0 until max

}

fun main() {
    // Input
    val mat = arrayOf(
        intArrayOf(0, 0, 0),
        intArrayOf(0, 1, 0),
        intArrayOf(0, 0, 0),
    )
    // Output
    LeetCode_542().updateMatrix(mat).run {
        println(this.contentDeepToString())
        require(
            arrayOf(
                intArrayOf(0, 0, 0),
                intArrayOf(0, 1, 0),
                intArrayOf(0, 0, 0),
            ).contentDeepEquals(this)
        )
    }
}
