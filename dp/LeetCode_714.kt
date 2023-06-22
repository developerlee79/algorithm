package dp

class LeetCode_714 {

    fun maxProfit(prices: IntArray, fee: Int): Int {
        val n = prices.size

        val hold = IntArray(n)
        hold[0] = prices[0].unaryMinus()

        val sell = IntArray(n)

        for (i in 1 until n) {
            hold[i] = maxOf(hold[i - 1], sell[i - 1] - prices[i])
            sell[i] = maxOf(sell[i - 1], hold[i - 1] + prices[i] - fee)
        }

        return sell[n - 1]
    }
}

fun main() {
    // Input
    val prices = intArrayOf(1, 3, 2, 8, 4, 9)
    val fee = 2
    // Output
    LeetCode_714().maxProfit(prices, fee).run {
        println(this)
        require(8 == this)
    }
}
