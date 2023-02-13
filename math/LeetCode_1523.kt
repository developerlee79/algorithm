package math

class LeetCode_1523 {

    fun countOdds(low: Int, high: Int) =
        ((high + 1) / 2) - (low / 2)
}

fun main() {
    // Input
    val low = 3
    val high = 7
    // Output
    LeetCode_1523().countOdds(low, high).let {
        println(it)
        require(it == 3)
    }
}
