package array

import java.util.PriorityQueue

class LeetCode_659 {

    /**
     * Solution - Priority Queue & Hash Map
     * Time Complexity : O(logN)
     * Space Complexity : O(N)
     *
     * @param nums integer array
     * @return true if you can split nums according to the above conditions, or false otherwise
     */
    fun isPossible(nums: IntArray): Boolean {
        if (nums.size < 3) {
            return false
        }

        val numMap = mutableMapOf<Int, Int>()
        nums.forEach { numMap.merge(it, 1) { a, b -> a + b } }

        val numQueue = PriorityQueue<Int>(numMap.size)
        numMap.keys.forEach { numQueue.add(it) }

        while (numQueue.isNotEmpty()) {
            var min = numQueue.peek()
            var count = 0

            while (true) {
                if (!numMap.containsKey(min)) {
                    if (count < 3) {
                        return false
                    }
                    break
                }

                numMap[min] = numMap[min]!!.minus(1)
                count++

                if (numMap[min] == 0) {
                    if (min != numQueue.poll()) {
                        return false
                    }
                }

                if (numMap.containsKey(min + 1) && numMap[min]!! + 1 > numMap[min + 1]!!) {
                    if (count < 3) {
                        return false
                    }
                    break
                }

                min++
            }
        }

        return true
    }
}

fun main() {
    val nums = intArrayOf(1, 2, 3, 3, 4, 5)
    println(LeetCode_659().isPossible(nums))
}
