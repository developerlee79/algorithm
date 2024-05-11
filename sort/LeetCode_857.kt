package sort

import java.util.PriorityQueue

class LeetCode_857 {

    fun mincostToHireWorkers(quality: IntArray, wage: IntArray, k: Int): Double {
        val ratios = constructSortedRatioArray(quality, wage)

        val workerQueue = PriorityQueue<Int>(compareByDescending { it })

        var maxRate = 0.0
        var qualitySum = 0

        repeat(k) {
            val (ratio, index) = ratios[it]

            maxRate = maxOf(maxRate, ratio)

            qualitySum += quality[index]

            workerQueue.add(quality[index])
        }

        val n = quality.size
        var minCost = maxRate * qualitySum

        for (i in k until n) {
            val (ratio, index) = ratios[i]

            maxRate = maxOf(maxRate, ratio)

            qualitySum -= workerQueue.poll()
            qualitySum += quality[index]

            workerQueue.add(quality[index])

            minCost = minOf(minCost, maxRate * qualitySum)
        }

        return minCost
    }

    private fun constructSortedRatioArray(
        quality: IntArray,
        wage: IntArray,
    ): List<Pair<Double, Int>> {
        val ratio = mutableListOf<Pair<Double, Int>>()

        for (i in quality.indices) {
            ratio.add(Pair(wage[i].toDouble() / quality[i], i))
        }

        ratio.sortBy { it.first }

        return ratio
    }
}

fun main() {
    // Input
    val quality = intArrayOf(10, 20, 5)
    val wage = intArrayOf(70, 50, 30)
    val k = 2
    // Output
    LeetCode_857().mincostToHireWorkers(quality, wage, k).run {
        println(this)
        require(105.00000 == this)
    }
}
