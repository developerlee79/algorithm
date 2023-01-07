package array

class LeetCode_134 {

    fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
        var startIndex = 0

        var sumOfGas = 0
        var tank = 0

        gas.forEachIndexed { index, unit ->
            tank += unit - cost[index]
            sumOfGas += unit - cost[index]

            if (tank < 0) {
                startIndex = index + 1
                tank = 0
            }
        }

        return if (sumOfGas < 0) {
            -1
        } else {
            startIndex
        }
    }
}

fun main() {
    // Input
    val gas = intArrayOf(1, 2, 3, 4, 5)
    val cost = intArrayOf(3, 4, 5, 1, 2)
    // Output
    LeetCode_134().canCompleteCircuit(gas, cost).let {
        println(it)
        require(it == 3)
    }
}
