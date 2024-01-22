package array

class LeetCode_645 {

    fun findErrorNums(nums: IntArray): IntArray {
        val n = nums.size

        var totalNum = n * (n + 1) / 2
        var arrayNum = 0

        val numberSet = hashSetOf<Int>()

        nums.forEach { num ->
            if (numberSet.add(num)) {
                totalNum -= num
            } else {
                arrayNum += num
            }
        }

        return intArrayOf(arrayNum, totalNum)
    }
}

fun main() {
    // Input
    val nums = intArrayOf(1, 2, 2, 4)
    // Output
    LeetCode_645().findErrorNums(nums).run {
        println(this.joinToString())
        intArrayOf(2, 3).contentEquals(this)
    }
}
