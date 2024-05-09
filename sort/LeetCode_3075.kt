package sort

class LeetCode_3075 {

    fun maximumHappinessSum(happiness: IntArray, k: Int): Long {
        happiness.sortDescending()

        var happinessSum: Long = 0

        repeat(k) {
            happinessSum += maxOf(happiness[it] - it, 0)
        }

        return happinessSum
    }
}

fun main() {
    // Input
    val happiness = intArrayOf(1, 2, 3)
    val k = 2
    // Output
    LeetCode_3075().maximumHappinessSum(happiness, k).run {
        println(this)
        require(4L == this)
    }
}
