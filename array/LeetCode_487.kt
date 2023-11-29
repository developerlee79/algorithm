package array

class LeetCode_487 {

    fun findMaxConsecutiveOnes(nums: IntArray): Int {
        var maxConsecutive = 0

        var zeroIndex = -1
        var count = 0

        nums.forEachIndexed { i, num ->
            if (num == 0) {
                count = zeroIndex + 1
                zeroIndex = i
            }

            maxConsecutive = maxOf(maxConsecutive, i - count + 1)
        }

        return maxConsecutive
    }

}

fun main() {
    // Input
    val nums = intArrayOf(1, 0, 1, 1, 0)
    // Output
    LeetCode_487().findMaxConsecutiveOnes(nums).run {
        println(this)
        require(4 == this)
    }
}
