package two_pointers

import kotlin.math.abs

class LeetCode_16 {

    /**
     * Solution - Two Pointers
     * Time Complexity : O(N^2)
     * Space Complexity : O(N)
     *
     * As like Two Sum problem, we can use three pointers (actually two) i, left, right to solve the problem.
     *
     * @param nums integer array
     * @param target integer
     * @return sum of the three integers which closest to target
    */
    fun threeSumClosest(nums: IntArray, target: Int): Int {
        val length = nums.size
        var result = nums[0] + nums[1] + nums[length - 1]

        nums.sort()

        for (i in 0 until length - 2) {
            var left = i + 1
            var right = length - 1

            while (left < right) {
                val sum = nums[i] + nums[left] + nums[right]

                if (abs(target - sum) < abs(target - result))
                    result = sum
                else if (sum < target)
                    left++
                else
                    right--
            }
        }

        return result
    }
}

fun main() {
    val nums = intArrayOf(-1, 2, 1, -4)
    val target = 1
    println(LeetCode_16().threeSumClosest(nums, target))
}
