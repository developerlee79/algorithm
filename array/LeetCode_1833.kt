package array

class LeetCode_1833 {

    fun maxIceCream(costs: IntArray, coins: Int): Int {
        costs.sort()

        var index = 0
        var coins = coins

        while (index in costs.indices && coins - costs[index] >= 0) {
            coins -= costs[index++]
        }

        return index
    }
}

fun main() {
    // Input
    val costs = intArrayOf(1, 3, 2, 4, 1)
    val coins = 7
    // Output
    LeetCode_1833().maxIceCream(costs, coins).let {
        println(it)
        require(it == 4)
    }
}
