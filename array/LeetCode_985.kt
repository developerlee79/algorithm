package array

class LeetCode_985 {

    /**
     * Problem : Sum of Even Numbers After Queries (985)
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     *
     * Calculate sum of even in nums array before iterate.
     * when nums[i] is even, it means sum of nums might be change.
     * so, remove nums[i] value at sum and add queried value when it's even
     *
     * @param nums integer array
     * @param queries queries where queries[i] = [val i, index i]
     * @return return an integer array answer where answer[i] is the answer to the ith query
    */
    fun sumEvenAfterQueries(nums: IntArray, queries: Array<IntArray>): IntArray {
        val sumOfEvenInNums = IntArray(queries.size)

        var sumOfEven = nums.sumOf { if (it % 2 == 0) it else 0 }

        for ((i, query) in queries.withIndex()) {
            val originalValue = nums[query[1]]

            nums[query[1]] += query[0]

            if (isEven(originalValue)) {
                sumOfEven -= originalValue
            }

            if (isEven(nums[query[1]])) {
                sumOfEven += nums[query[1]]
            }

            sumOfEvenInNums[i] = sumOfEven
        }

        return sumOfEvenInNums
    }

    private fun isEven(value: Int): Boolean {
        return value % 2 == 0
    }
}

fun main() {
    val nums = intArrayOf(1, 2, 3, 4)
    val queries = arrayOf(
        intArrayOf(1, 0),
        intArrayOf(-3, 1),
        intArrayOf(-4, 0),
        intArrayOf(2, 3)
    )

    val result = LeetCode_985().sumEvenAfterQueries(nums, queries)

    assert(intArrayOf(8, 6, 2, 4).contentEquals(result))
    println(result.joinToString())
}
