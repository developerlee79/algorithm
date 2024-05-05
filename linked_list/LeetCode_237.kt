package linked_list

import util.ListNode

class LeetCode_237 {

    fun deleteNode(node: ListNode?) {
        node?.`val` = node?.next?.`val`!!
        node.next = node.next?.next
    }
}

fun main() {
    // Input
    val head = ListNode.create(4, 5, 1, 9)
    val node = 5
    // Output
    LeetCode_237().deleteNode(head).run {
        println(this)
        require(
            ListNode.create(4, 1, 9)!!.equals(this)
        )
    }
}
