package array

class LeetCode_2966 {

    fun divideArray(nums: IntArray, k: Int): Array<IntArray> {
        val n = nums.size
        nums.sort()

        val resultArray = mutableListOf<IntArray>()

        var i = 0

        while (i < n) {
            val firstValue = nums[i++]

            val divideArray = IntArray(3)
            divideArray[0] = firstValue

            for (j in 1..2) {
                if (nums[i] - firstValue > k) {
                    return emptyArray()
                }

                divideArray[j] = nums[i++]
            }

            resultArray.add(divideArray)
        }

        return resultArray.toTypedArray()
    }
}

fun main() {
    // Input
    val nums = intArrayOf(1, 3, 4, 8, 7, 9, 3, 5, 1)
    val k = 2
    // Output
    LeetCode_2966().divideArray(nums, k).run {
        println(this.contentDeepToString())
        require(
            arrayOf(
                intArrayOf(1, 1, 3),
                intArrayOf(3, 4, 5),
                intArrayOf(7, 8, 9),
            ).contentDeepEquals(this)
        )
    }
}
