package linked_list

import util.ListNode

class LeetCode_2095 {

    /**
     * Solution : Two Pointers
     * Time Complexity : O(N)
     * Space Complexity : O(1)
     *
     * Find middle node with faster & slower pointer and delete it.
     *
     * @param head head of list node
     * @return return the head of the modified linked list
    */
    fun deleteMiddle(head: ListNode?): ListNode? {
        if (head?.next == null) {
            return null
        }

        var fasterNode: ListNode? = head
        var slowerNode: ListNode? = head
        var beforeMiddle: ListNode? = null

        while (fasterNode?.next != null) {
            fasterNode = fasterNode.next?.next
            beforeMiddle = slowerNode
            slowerNode = slowerNode?.next
        }

        beforeMiddle?.next = slowerNode?.next

        return head
    }
}

fun main() {
    // Input
    val head = ListNode.create(1, 3, 4, 7, 1, 2, 6)
    // Output
    val result = LeetCode_2095().deleteMiddle(head)
    println(result)
}
