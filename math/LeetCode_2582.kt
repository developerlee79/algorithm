package math

class LeetCode_2582 {

    fun passThePillow(n: Int, time: Int): Int {
        val pattern = 2 * (n - 1)
        val left = time % pattern
        return if (left >= n) pattern - left + 1 else left + 1
    }
}

fun main() {
    // Input
    val n = 4
    val time = 5
    // Output
    LeetCode_2582().passThePillow(n, time).run {
        println(this)
        require(2 == this)
    }
}
