package matrix

import java.util.PriorityQueue

class LeetCode_1337 {

    fun kWeakestRows(mat: Array<IntArray>, k: Int): IntArray {
        val priorityQueue = PriorityQueue<Pair<Int, Int>>(compareBy({ it.second }, { it.first }))

        for (i in mat.indices) {
            priorityQueue.add(Pair(i, mat[i].count { it == 1 }))
        }

        val weakestRows = IntArray(k)

        repeat(k) {
            weakestRows[it] = priorityQueue.poll().first
        }

        return weakestRows
    }
}

fun main() {
    // Input
    val mat = arrayOf(
        intArrayOf(1, 1, 0, 0, 0),
        intArrayOf(1, 1, 1, 1, 0),
        intArrayOf(1, 0, 0, 0, 0),
        intArrayOf(1, 1, 0, 0, 0),
        intArrayOf(1, 1, 1, 1, 1)
    )
    val k = 3
    // Output
    LeetCode_1337().kWeakestRows(mat, k).run {
        println(this.joinToString())
        require(
            intArrayOf(2, 0, 3).contentEquals(this)
        )
    }
}
