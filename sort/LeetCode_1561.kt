package sort

class LeetCode_1561 {

    fun maxCoins(piles: IntArray): Int {
        piles.sortDescending()

        var earnedCoin = 0
        var me = 1

        repeat(piles.size / 3) {
            earnedCoin += piles[me]
            me += 2
        }

        return earnedCoin
    }
}

fun main() {
    // Input
    val piles = intArrayOf(2, 4, 1, 2, 7, 8)
    // Output
    LeetCode_1561().maxCoins(piles).run {
        println(this)
        require(9 == this)
    }
}
