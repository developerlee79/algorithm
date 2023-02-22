package search

class LeetCode_1011 {

    fun shipWithinDays(weights: IntArray, days: Int): Int {
        var maxWeight = 0
        var sumOfWeights = 0

        weights.forEach {
            maxWeight = maxOf(maxWeight, it)
            sumOfWeights += it
        }

        var minWeight = maxWeight

        while (maxWeight <= sumOfWeights) {
            val capacity = (maxWeight + sumOfWeights) / 2

            if (isPossible(weights, capacity, days)) {
                minWeight = capacity
                sumOfWeights = capacity - 1
            } else {
                maxWeight = capacity + 1
            }
        }

        return minWeight
    }

    private fun isPossible(weights: IntArray, capacity: Int, days: Int): Boolean {
        var temp = 0
        var count = days

        weights.forEach {
            if (temp + it > capacity) {
                count--
                temp = 0
            }
            temp += it
        }

        return count > 0
    }
}

fun main() {
    // Input
    val weights = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val days = 5
    // Output
    LeetCode_1011().shipWithinDays(weights, days).let {
        println(it)
        require(it == 15)
    }
}
