package array

class LeetCode_169 {

    fun majorityElement(nums: IntArray): Int {
        val frequencyMap = hashMapOf<Int, Int>()
        val target = nums.size / 2

        nums.forEach { num ->
            if (frequencyMap.merge(num, 1) { a, b -> a + b }!! > target) {
                return num
            }
        }

        return -1
    }
}

fun main() {
    // Input
    val nums = intArrayOf(3, 2, 3)
    // Output
    LeetCode_169().majorityElement(nums).run {
        println(this)
        require(3 == this)
    }
}
