package sort

import java.util.*

class LeetCode_1962 {

    fun minStoneSum(piles: IntArray, k: Int): Int {
        val priorityQueue = PriorityQueue<Int> { a, b -> b - a }

        var sumOfStone = 0

        piles.forEach {
            priorityQueue.add(it)
            sumOfStone += it
        }

        repeat(k) {
            priorityQueue.poll().let {
                priorityQueue.add(it - it / 2)
                sumOfStone -= it / 2
            }
        }

        return sumOfStone
    }
}

fun main() {
    // Input
    val piles = intArrayOf(5, 4, 9)
    val k = 2
    // Output
    LeetCode_1962().minStoneSum(piles, k).let {
        println(it)
        require(it == 12)
    }
}
