package linked_list

import util.ListNode
import java.util.Stack

class LeetCode_143 {

    fun reorderList(head: ListNode?) {
        var nodeStack = Stack<ListNode>()
        var currentNode = head

        while (currentNode != null) {
            nodeStack.add(currentNode)
            currentNode = currentNode.next
        }

        var headNode = head

        while (headNode?.next != null) {
            val endNode = nodeStack.pop()
            val lastNode = nodeStack.peek()

            lastNode.next = null
            endNode.next = headNode.next
            headNode.next = endNode

            headNode = headNode.next?.next
        }
    }
}

fun main() {
    // Input
    val head = ListNode.create(1, 2, 3, 4)
    // Output
    LeetCode_143().reorderList(head)
    run {
        println(head)
        require(
            ListNode.create(1, 4, 2, 3)!!.equals(head)
        )
    }
}
