package linked_list

import util.ListNode

class LeetCode_328 {

    fun oddEvenList(head: ListNode?): ListNode? {
        val lastOdd = ListNode(-1)
        var oddNode = lastOdd

        val lastEven = ListNode(-1)
        var evenNode = lastEven

        var _head = head

        var index = 0
        var oddCount = 0
        var evenCount = 0

        while (_head != null) {
            if (index % 2 != 0) {
                oddNode.next = ListNode(_head.`val`)
                oddNode = oddNode.next!!
                oddCount++
            } else {
                evenNode.next = ListNode(_head.`val`)
                evenNode = evenNode.next!!
                evenCount++
            }

            _head = _head.next
            index++
        }

        return if (oddCount > evenCount) {
            oddNode.next = lastEven.next
            lastOdd.next
        } else {
            evenNode.next = lastOdd.next
            lastEven.next
        }
    }
}

fun main() {
    // Input
    val head = ListNode.create(1, 2, 3, 4, 5)
    // Output
    val result = LeetCode_328().oddEvenList(head)
    println(result)
}
