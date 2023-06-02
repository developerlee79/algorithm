package graph

import java.util.*

class LeetCode_2101 {

    fun maximumDetonation(bombs: Array<IntArray>): Int {
        val bombQueue: Queue<Int> = LinkedList()
        var maxDetonation = 1
        val n = bombs.size

        for (i in bombs.indices) {
            val visited = BooleanArray(n)
            visited[i] = true

            var currentDetonation = 1

            bombQueue.offer(i)

            while (bombQueue.isNotEmpty()) {
                val currentBomb = bombs[bombQueue.poll()]

                for (j in bombs.indices) {
                    if (!visited[j] && isEffected(currentBomb, bombs[j])) {
                        currentDetonation++
                        visited[j] = true
                        bombQueue.offer(j)
                    }
                }
            }

            maxDetonation = maxOf(maxDetonation, currentDetonation)
        }

        return maxDetonation
    }

    private fun isEffected(detonatedBomb: IntArray, targetBomb: IntArray): Boolean {
        val x = (detonatedBomb[0] - targetBomb[0]).toLong()
        val y = (detonatedBomb[1] - targetBomb[1]).toLong()
        val radius = detonatedBomb[2].toLong()
        val distance = (x * x) + (y * y)
        return distance <= (radius * radius)
    }
}

fun main() {
    // Input
    val bombs = arrayOf(
        intArrayOf(2, 1, 3),
        intArrayOf(6, 1, 4),
    )
    // Output
    LeetCode_2101().maximumDetonation(bombs).run {
        println(this)
        require(2 == this)
    }
}
