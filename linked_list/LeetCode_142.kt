package linked_list

import util.ListNode

class LeetCode_142 {

    fun detectCycle(head: ListNode?): ListNode? {
        if (head?.next == null) {
            return null
        }

        var slowPointer = head
        var fasterPointer = head

        while (fasterPointer?.next != null) {
            slowPointer = slowPointer?.next
            fasterPointer = fasterPointer.next!!.next

            if (slowPointer == fasterPointer) {
                var entry = head

                while (slowPointer != entry) {
                    slowPointer = slowPointer?.next
                    entry = entry?.next
                }

                return entry
            }
        }

        return null
    }
}

fun main() {
    // Input
    val head =  ListNode.create(3, 2, 0)
    val pos = 1
    // Output
    println(LeetCode_142().detectCycle(head).toString())
}
