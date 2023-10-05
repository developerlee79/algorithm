package array

class LeetCode_229 {

    fun majorityElement(nums: IntArray): List<Int> {
        val frequencyMap = hashMapOf<Int, Int>()

        val n = nums.size

        val limit = if (n >= 3) nums.size / 3 else 0
        val resultList = mutableListOf<Int>()

        for (num in nums) {
            frequencyMap.merge(num, 1) { a, b -> a + b }

            if (frequencyMap[num]!! > limit) {
                resultList.add(num)
                frequencyMap[num] = Int.MIN_VALUE
            }
        }

        return resultList
    }
}

fun main() {
    // Input
    val nums = intArrayOf(3, 2, 3)
    // Output
    LeetCode_229().majorityElement(nums).run {
        println(this)
        require(
            listOf(3) == this
        )
    }
}
