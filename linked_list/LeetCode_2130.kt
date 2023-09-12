package linked_list

import util.ListNode

class LeetCode_2130 {

    fun pairSum(head: ListNode?): Int {
        val nodeDeque = ArrayDeque<Int>()

        var head = head

        while (head != null) {
            nodeDeque.add(head.`val`)
            head = head.next
        }

        var maxSum = 0

        while (nodeDeque.isNotEmpty()) {
            maxSum = maxOf(maxSum, nodeDeque.removeFirst() + nodeDeque.removeLast())
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
