package linked_list

import util.ListNode
import java.util.Stack

class LeetCode_2816 {

    fun doubleIt(head: ListNode?): ListNode? {
        val numberStack = Stack<Int>()

        var head = head

        while (head != null) {
            numberStack.add(head.`val` * 2)
            head = head.next
        }

        val doubleHead = ListNode(-1)

        while (numberStack.isNotEmpty()) {
            val currentNumber = numberStack.pop()

            if (currentNumber > 9) {
                if (numberStack.isEmpty()) {
                    numberStack.add(1)
                } else {
                    numberStack.add(1 + numberStack.pop())
                }
            }

            val newNode = ListNode(currentNumber % 10)
            newNode.next = doubleHead.next
            doubleHead.next = newNode
        }

        return doubleHead.next
    }
}

fun main() {
    // Input
    val head = ListNode.create(1, 8, 9)
    // Output
    LeetCode_2816().doubleIt(head).run {
        println(this)
        require(
            ListNode.create(3, 7, 8)!!.equals(this)
        )
    }
}
