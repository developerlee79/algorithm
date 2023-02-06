package array

class LeetCode_1470 {

    fun shuffle(nums: IntArray, n: Int): IntArray {
        val shuffledArray = IntArray(nums.size)

        var i = 0

        repeat(nums.size) {
            shuffledArray[it] = if (it % 2 == 0) {
                nums[i]
            } else {
                nums[n + i++]
            }
        }

        return shuffledArray
    }
}

fun main() {
    // Input
    val nums = intArrayOf(2, 5, 1, 3, 4, 7)
    val n = 3
    // Output
    LeetCode_1470().shuffle(nums, n).let {
        println(it.joinToString())
        require(intArrayOf(2, 3, 5, 4, 1, 7).contentEquals(it))
    }
}
