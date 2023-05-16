package linked_list

import util.ListNode

class LeetCode_24 {

    fun swapPairs(head: ListNode?): ListNode? {
        if (head == null) {
            return null
        }

        val headIndex = ListNode(-1)

        var clonedHead = head

        headIndex.next = clonedHead

        var idx = headIndex

        while (clonedHead?.next != null) {
            val tmp = clonedHead
            clonedHead = clonedHead.next
            tmp.next = clonedHead!!.next
            clonedHead.next = tmp

            idx.next = clonedHead

            clonedHead = tmp.next
            idx = idx.next!!.next!!
        }

        return headIndex.next
    }
}

fun main() {
    // Input
    val head = ListNode.create(1, 2, 3, 4)
    // Output
    LeetCode_24().swapPairs(head).run {
        println(this)
        println(this?.equals(ListNode.create(2, 1, 4, 3)))
    }
}
