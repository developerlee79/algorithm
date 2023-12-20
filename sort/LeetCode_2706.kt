package sort

class LeetCode_2706 {

    fun buyChoco(prices: IntArray, money: Int): Int {
        var lowest = Integer.MAX_VALUE
        var secondLowest = Integer.MAX_VALUE

        for (price in prices) {
            if (price <= lowest) {
                secondLowest = lowest
                lowest = price
            } else if (price < secondLowest) {
                secondLowest = price
            }
        }

        return if (money >= lowest + secondLowest) money - (lowest + secondLowest) else money
    }
}

fun main() {
    // Input
    val prices = intArrayOf(1, 2, 2)
    val money = 3
    // Output
    LeetCode_2706().buyChoco(prices, money).run {
        println(this)
        require(0 == this)
    }
}
