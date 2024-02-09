package dp

class LeetCode_368 {

    fun largestDivisibleSubset(nums: IntArray): List<Int> {
        nums.sort()

        val n = nums.size

        val subsets = IntArray(n) { 1 }
        val lastElements = IntArray(n) { -1 }

        var maxIndex = 0

        nums.forEachIndexed { i, num ->
            for (j in 0 until i) {
                if (nums[i] % nums[j] == 0) {
                    if (subsets[i] < 1 + subsets[j]) {
                        subsets[i] = subsets[j] + 1
                        lastElements[i] = j
                    }
                }
            }

            if (subsets[i] > subsets[maxIndex]) {
                maxIndex = i
            }
        }

        val divisibleSubSet = mutableListOf<Int>()

        while (maxIndex != -1) {
            divisibleSubSet.add(0, nums[maxIndex])
            maxIndex = lastElements[maxIndex]
        }

        return divisibleSubSet
    }
}

fun main() {
    // Input
    val nums = intArrayOf(1, 2, 3)
    // Output
    LeetCode_368().largestDivisibleSubset(nums).run {
        println(this)
        require(
            listOf(1, 2) == this
        )
    }
}
