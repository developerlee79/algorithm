package array

class LeetCode_1913 {

    fun maxProductDifference(nums: IntArray): Int {
        var firstMax = 0
        var secondMax = 0

        var firstMin = Integer.MAX_VALUE
        var secondMin = Integer.MAX_VALUE

        for (num in nums) {
            if (num >= firstMax) {
                secondMax = firstMax
                firstMax = num
            } else if (num >= secondMax) {
                secondMax = num
            }

            if (num < firstMin) {
                secondMin = firstMin
                firstMin = num
            } else if (num < secondMin) {
                secondMin = num
            }
        }

        return (firstMax * secondMax) - (firstMin * secondMin)
    }
}

fun main() {
    // Input
    val nums = intArrayOf(5, 6, 2, 7, 4)
    // Output
    LeetCode_1913().maxProductDifference(nums).run {
        println(this)
        require(34 == this)
    }
}
