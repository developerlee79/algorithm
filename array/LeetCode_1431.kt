package array

class LeetCode_1431 {

    fun kidsWithCandies(candies: IntArray, extraCandies: Int): List<Boolean> {
        val maxCandy = candies.maxOf { it }
        return candies.map { it + extraCandies >= maxCandy }.toList()
    }
}

fun main() {
    // Input
    val candies = intArrayOf(2, 3, 5, 1, 3)
    val extraCandies = 3
    // Output
    LeetCode_1431().kidsWithCandies(candies, extraCandies).let {
        println(it)
        require(listOf(true, true, true, false, true) == it)
    }
}
