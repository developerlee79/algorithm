package array

class LeetCode_2971 {

    fun largestPerimeter(nums: IntArray): Long {
        var lastPerimeter = -1L
        var totalPerimeter = 0L

        nums.sort()

        nums.forEach { num ->
            if (num < totalPerimeter) {
                lastPerimeter = totalPerimeter + num
            }

            totalPerimeter += num
        }

        return lastPerimeter
    }
}

fun main() {
    // Input
    val nums = intArrayOf(5, 5, 5)
    // Output
    LeetCode_2971().largestPerimeter(nums).run {
        println(this)
        require(15L == this)
    }
}
