package two_pointers

class LeetCode_15 {

    /**
     * Solution - Two Pointers
     * Time Complexity : O(NlogN)
     * Space Complexity : O(N)
     *
     * Use two pointer technique to find 3Sum subset.
     * Starts with an array sorted for convenient.
     * Search the array with two pointers and find the 3Sum.
     * Because it is an ordered array, if the value is large or small, simply increase/decrease the value of the pointer.
     *
     * @param nums integer array
     * @return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0
     */
    fun threeSum(nums: IntArray): List<List<Int>> {
        val resultList: MutableList<List<Int>> = mutableListOf()
        val size = nums.size
        nums.sort()

        if (size < 3 || nums[0] > 0 || nums[size - 1] < 0) {
            return resultList
        }

        for (i in 0 until size - 2) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue
            }

            var leftPointer = i + 1
            var rightPointer = size - 1
            while (leftPointer < rightPointer) {
                val sum = nums[i] + nums[leftPointer] + nums[rightPointer]

                if (sum == 0) {
                    resultList.add(listOf(nums[i], nums[leftPointer], nums[rightPointer]))

                    while (leftPointer < rightPointer && nums[leftPointer] == nums[leftPointer + 1]) {
                        leftPointer++
                    }

                    while (leftPointer < rightPointer && nums[rightPointer] == nums[rightPointer - 1]) {
                        rightPointer--
                    }
                    leftPointer++
                    rightPointer--
                } else if (sum > 0) {
                    rightPointer--
                } else {
                    leftPointer++
                }
            }
        }

        return resultList
    }
}

fun main() {
    val nums = intArrayOf(-1, 0, 1, 2, -1, -4)
    println(LeetCode_15().threeSum(nums))
}
