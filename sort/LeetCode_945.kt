package sort

class LeetCode_945 {

    fun minIncrementForUnique(nums: IntArray): Int {
        nums.sort()

        var count = 0
        var nextUnique = 0

        nums.forEach { num ->
            nextUnique = maxOf(nextUnique, num)
            count += nextUnique++ - num
        }

        return count
    }
}

fun main() {
    // Input
    val nums = intArrayOf(1, 2, 2)
    // Output
    LeetCode_945().minIncrementForUnique(nums).run {
        println(this)
        require(1 == this)
    }
}
