package linked_list


class LeetCode_92 {

    data class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    /**
     * Solution - Linked List
     * Time Complexity : O(N)
     * Space Complexity : O(1)
     *
     * Use three pointer prevNode, currentNode, nextNode to reverse order of list-node.
     *
     * @param head singly linked list
     * @param left position
     * @param right position
     * @return reversed list from position left to right
    */
    fun reverseBetween(head: ListNode?, left: Int, right: Int): ListNode? {
        val resultNode = ListNode(0)
        resultNode.next = head

        var prevNode = resultNode

        for (i in 0 until left - 1) {
            prevNode = prevNode.next!!
        }

        val currentNode = prevNode.next

        for (i in 0 until right - left) {
            val nextNode = currentNode!!.next
            currentNode.next = nextNode!!.next
            nextNode.next = prevNode.next
            prevNode.next = nextNode
        }

        return resultNode.next
    }
}

fun main() {
    val head = LeetCode_92.ListNode(1)
    head.next = LeetCode_92.ListNode(2)
    head.next!!.next = LeetCode_92.ListNode(3)
    head.next!!.next!!.next = LeetCode_92.ListNode(4)
    head.next!!.next!!.next!!.next = LeetCode_92.ListNode(5)
    val left = 2
    val right = 4
    println(LeetCode_92().reverseBetween(head, left, right))
}
