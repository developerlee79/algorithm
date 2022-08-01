package linked_list

class LeetCode_86 {

    data class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    /**
     * Solution - Two Pointers
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     *
     * This problem is simply sorting the Linked List by X.
     * Therefore, we can combine a linked list less than X and a linked list greater than or equal to X to obtain a partition list.
     *
     * @param head head of a linked list
     * @param x integer
     * @return parted array such that all node less than x come before nodes greater than or equal to x
    */
    fun partition(head: ListNode?, x: Int): ListNode? {
        val smallerList = ListNode(-1)
        val greaterList = ListNode(-1)

        var smallerPointer = smallerList
        var greaterPointer = greaterList

        var currentNode = head
        while (currentNode != null) {
            if (currentNode.`val` < x) {
                smallerPointer.next = ListNode(currentNode.`val`)
                smallerPointer = smallerPointer.next!!
            } else {
                greaterPointer.next = ListNode(currentNode.`val`)
                greaterPointer = greaterPointer.next!!
            }
            currentNode = currentNode.next
        }

        smallerPointer.next = greaterList.next

        return smallerList.next
    }
}

fun main() {
    val head = LeetCode_86.ListNode(1)
    head.next = LeetCode_86.ListNode(4)
    head.next!!.next = LeetCode_86.ListNode(3)
    head.next!!.next!!.next = LeetCode_86.ListNode(2)
    head.next!!.next!!.next!!.next = LeetCode_86.ListNode(5)
    head.next!!.next!!.next!!.next!!.next = LeetCode_86.ListNode(2)
    val x = 3
    println(LeetCode_86().partition(head, x).toString())
}
