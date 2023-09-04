package linked_list

import util.ListNode

class LeetCode_141 {

    fun hasCycle(head: ListNode?): Boolean {
        if (head?.next == null) {
            return false
        }

        var slowPointer = head
        var fastPointer = head

        while (slowPointer != null && fastPointer != null) {
            slowPointer = slowPointer.next
            fastPointer = fastPointer.next?.next

            if (slowPointer == fastPointer) {
                return true
            }
        }

        return false
    }
}

fun main() {
    // Input
    val head = ListNode.create(3, 2, 0, -4)
    // Output
    LeetCode_141().hasCycle(head).run {
        println(this)
        require(!this)
    }
}
