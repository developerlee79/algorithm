package array

class LeetCode_2341 {

    fun numberOfPairs(nums: IntArray): IntArray {
        val numSet = hashSetOf<Int>()

        var pairCount = 0
        nums.forEach {
            if (!numSet.add(it)) {
                numSet.remove(it)
                pairCount++
            }
        }

        return intArrayOf(pairCount, numSet.size)
    }
}

fun main() {
    // Input
    val nums = intArrayOf(1, 3, 2, 1, 3, 2, 2)
    // Output
    val result = LeetCode_2341().numberOfPairs(nums)
    println(result.joinToString())
    require(
        intArrayOf(3, 1).contentEquals(result)
    )
}
