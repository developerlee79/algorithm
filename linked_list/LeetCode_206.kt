package linked_list

import util.ListNode

class LeetCode_206 {

    fun reverseList(head: ListNode?): ListNode? {
        if (head?.next == null) {
            return head
        }

        val reverseHead = reverseList(head.next)

        head.next!!.next = head
        head.next = null

        return reverseHead
    }
}

fun main() {
    // Input
    val head = ListNode.create(1, 2, 3, 4, 5)
    // Output
    LeetCode_206().reverseList(head).run {
        println(this)
        require(
            ListNode.create(5, 4, 3, 2, 1)!!.equals(this)
        )
    }
}
