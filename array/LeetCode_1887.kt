package array

class LeetCode_1887 {

    fun reductionOperations(nums: IntArray): Int {
        nums.sort()

        var operations = 0
        var lastValue = nums[0]
        var add = 0

        for (i in 1 until nums.size) {
            if (nums[i] == lastValue) {
                operations += add
                continue
            }

            lastValue = nums[i]
            operations += ++add
        }

        return operations
    }
}

fun main() {
    // Input
    val nums = intArrayOf(5, 1, 3)
    // Output
    LeetCode_1887().reductionOperations(nums).run {
        println(this)
        require(3 == this)
    }
}
