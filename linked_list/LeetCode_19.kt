package linked_list

import util.ListNode

class LeetCode_19 {

    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        val startNode = ListNode(0, head)
        var slowerPointerNode: ListNode? = startNode
        var fasterPointerNode: ListNode? = startNode

        var n = n

        while (n-- > 0) {
            fasterPointerNode = fasterPointerNode!!.next
        }

        while (fasterPointerNode!!.next != null) {
            slowerPointerNode = slowerPointerNode!!.next
            fasterPointerNode = fasterPointerNode!!.next
        }

        slowerPointerNode!!.next = slowerPointerNode!!.next!!.next

        return startNode.next
    }
}

fun main() {
    // Input
    val head = ListNode.create(1, 2, 3, 4, 5)
    val n = 2
    // Output
    LeetCode_19().removeNthFromEnd(head, n).run {
        println(this.toString())
        require(
            ListNode.create(1, 2, 3, 5)!!.equals(this)
        )
    }
}
