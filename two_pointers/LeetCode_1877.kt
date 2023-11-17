package two_pointers

class LeetCode_1877 {

    fun minPairSum(nums: IntArray): Int {
        nums.sort()

        var i = 0
        var j = nums.lastIndex

        val pairSumList = mutableListOf<Int>()

        while (i < j) {
            pairSumList.add(nums[i] + nums[j])
            i++
            j--
        }

        var maximumPair = 0

        for (pairSum in pairSumList) {
            maximumPair = maxOf(maximumPair, pairSum)
        }

        return maximumPair
    }
}

fun main() {
    // Input
    val nums = intArrayOf(3, 5, 2, 3)
    // Output
    LeetCode_1877().minPairSum(nums).run {
        println(this)
        require(7 == this)
    }
}
