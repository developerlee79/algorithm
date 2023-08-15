package linked_list

import util.ListNode

class LeetCode_86 {

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
    val head = ListNode.create(1, 4, 3, 2, 5, 2)
    val x = 3
    LeetCode_86().partition(head, x).run {
        println(this)
        require(
            ListNode.create(1,2,2,4,3,5)!!.equals(this)
        )
    }
}
