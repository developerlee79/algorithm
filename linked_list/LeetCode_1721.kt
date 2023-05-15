package linked_list

import util.ListNode

class LeetCode_1721 {

    fun swapNodes(head: ListNode?, k: Int): ListNode? {
        if (head == null) {
            return null
        }

        var slowNode = head
        var firstTarget = head

        repeat(k - 1) {
            firstTarget = firstTarget?.next
        }

        var fastNode = slowNode

        repeat(k) {
            fastNode = fastNode?.next
        }

        while (fastNode != null) {
            slowNode = slowNode?.next
            fastNode = fastNode?.next
        }

        val temp = firstTarget?.`val`

        firstTarget?.`val` = slowNode!!.`val`
        slowNode.`val` = temp!!

        return head
    }
}

fun main() {
    // Input
    val head = ListNode.create(1, 2, 3, 4, 5)
    val k = 2
    // Output
    LeetCode_1721().swapNodes(head, k).run {
        println(this)
        require(this == ListNode.create(1, 4, 3, 2, 5))
    }
}
