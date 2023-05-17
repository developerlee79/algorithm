package linked_list

import util.ListNode
import java.util.Deque
import java.util.LinkedList
import java.util.Stack

class LeetCode_2130 {

    private fun Deque<Int>.pollEach() = this.pollFirst() + this.pollLast()

    fun pairSum(head: ListNode?): Int {
        val deQueue: Deque<Int> = LinkedList()

        var head = head

        while (head != null) {
            deQueue.add(head.`val`)
            head = head.next
        }

        var maxSum = 0

        while (deQueue.isNotEmpty()) {
            maxSum = maxOf(maxSum, deQueue.pollEach())
        }

        return maxSum
    }

    fun pairSumStack(head: ListNode?): Int {
        val stack = Stack<Int>()

        var slowHead = head
        var fastHead = head

        while (slowHead != null && fastHead?.next != null) {
            stack.add(slowHead.`val`)
            slowHead = slowHead.next
            fastHead = fastHead.next?.next
        }

        var maxSum = 0

        while (slowHead != null) {
            maxSum = maxOf(maxSum, stack.pop() + slowHead.`val`)
            slowHead = slowHead.next
        }

        return maxSum
    }
}

fun main() {
    // Input
    val head = ListNode.create(5, 4, 2, 1)
    // Output
    LeetCode_2130().pairSum(head).run {
        println(this)
        require(6 == this)
    }
}
