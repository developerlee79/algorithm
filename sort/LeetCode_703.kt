package sort

import java.util.PriorityQueue

class LeetCode_703 {

    class KthLargest(
        k: Int,
        nums: IntArray
    ) {

        private val priorityQueue: PriorityQueue<Int>
        private val k: Int

        init {
            this.priorityQueue = PriorityQueue(k)
            this.k = k

            nums.forEach {
                limitedAdd(it)
            }
        }

        fun add(`val`: Int): Int {
            limitedAdd(`val`)
            return priorityQueue.peek()
        }

        private fun limitedAdd(value: Int) {
            priorityQueue.add(value)

            if (priorityQueue.size > k) {
                priorityQueue.poll()
            }
        }
    }
}

fun main() {
    // Input
    val k = 3
    val initElements = intArrayOf(4, 5, 8, 2)
    val kthLargest = LeetCode_703.KthLargest(k, initElements)
    // Output
    assert(4 == kthLargest.add(3))
    assert(5 == kthLargest.add(5))
    assert(5 == kthLargest.add(10))
    assert(8 == kthLargest.add(9))
    assert(8 == kthLargest.add(4))
}
