package matrix

import java.util.*

class LeetCode_1329 {

    /**
     * Solution - Priority Queue + Map
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     *
     * @param mat matrix
     * @return return the sort each matrix diagonal in ascending ordered matrix
    */
    fun diagonalSort(mat: Array<IntArray>): Array<IntArray> {
        val m: Int = mat.size
        val n: Int = mat[0].size
        val priorityQueueHashMap = HashMap<Int, PriorityQueue<Int>>()

        for (i in 0 until m) {
            for (j in 0 until n) {
                priorityQueueHashMap.putIfAbsent(i - j, PriorityQueue())
                priorityQueueHashMap[i - j]!!.add(mat[i][j])
            }
        }

        for (i in 0 until m) {
            for (j in 0 until n) {
                mat[i][j] = priorityQueueHashMap[i - j]!!.poll()
            }
        }

        return mat
    }
}

fun main() {
    val mat = arrayOf(
        intArrayOf(3, 3, 1, 1),
        intArrayOf(2, 2, 1, 2),
        intArrayOf(1, 1, 1, 2)
    )
    println(LeetCode_1329().diagonalSort(mat).contentDeepToString())
}
