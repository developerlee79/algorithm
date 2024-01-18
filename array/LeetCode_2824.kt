package array

class LeetCode_2824 {

    fun countPairs(nums: List<Int>, target: Int): Int {
        val sortedNums = nums.sorted()

        var count = 0

        var i = 0
        var j = nums.lastIndex

        while (i < j) {
            if (sortedNums[i] + sortedNums[j] < target) {
                count += j - i
                i++
            } else {
                j--
            }
        }

        return count
    }
}