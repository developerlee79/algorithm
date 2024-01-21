package dp

class LeetCode_198 {

    fun rob(nums: IntArray): Int {
        var rob = 0
        var skip = 0

        nums.forEach { num ->
            val currentSkip = maxOf(rob, skip)
            rob = skip + num
            skip = currentSkip
        }

        return maxOf(rob, skip)
    }
}

fun main() {
    // Input
    val nums = intArrayOf(1, 2, 3, 1)
    // Output
    LeetCode_198().rob(nums).run {
        println(this)
        require(4 == this)
    }
}
