package array

class LeetCode_2366 {

    fun minimumReplacement(nums: IntArray): Long {
        var replaceCount = 0L

        var lastValue = nums.last()

        var i = nums.lastIndex - 1

        while (i >= 0) {
            if (nums[i] > lastValue) {
                var currentDivide = nums[i] / lastValue

                if (nums[i] % lastValue > 0) {
                    currentDivide++
                }

                lastValue = nums[i] / currentDivide
                replaceCount += currentDivide - 1
            } else {
                lastValue = nums[i]
            }

            i--
        }

        return replaceCount
    }
}

fun main() {
    // Input
    val nums = intArrayOf(3, 9, 3)
    // Output
    LeetCode_2366().minimumReplacement(nums).run {
        println(this)
        require(2L == this)
    }
}
