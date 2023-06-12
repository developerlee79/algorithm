package array

class LeetCode_228 {

    fun summaryRanges(nums: IntArray): List<String> {
        val resultList = mutableListOf<String>()

        if (nums.isEmpty()) {
            return resultList
        }

        var i = 0
        while (i < nums.size) {
            val numberStringBuilder = StringBuilder()
            numberStringBuilder.append(nums[i])

            val currentIndex = i

            while (i < nums.lastIndex && nums[i] + 1 == nums[i + 1]) {
                i++
            }

            if (currentIndex < i) {
                numberStringBuilder
                    .append("->")
                    .append(nums[i])
            }

            resultList.add(numberStringBuilder.toString())

            i++
        }

        return resultList
    }
}

fun main() {
    // Input
    val nums = intArrayOf(0, 1, 2, 4, 5, 7)
    // Output
    LeetCode_228().summaryRanges(nums).run {
        println(this)
        require(
            listOf("0->2", "4->5", "7") == this
        )
    }
}
