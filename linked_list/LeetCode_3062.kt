package linked_list

import util.ListNode

class LeetCode_3062 {

    fun gameResult(head: ListNode?): String {
        var oddPoint = 0
        var evenPoint = 0

        var head = head
        var nextNode = head!!.next

        while (head != null && nextNode != null) {
            if (head.`val` > nextNode.`val`) {
                evenPoint++
            } else {
                oddPoint++
            }

            head = head.next?.next
            nextNode = nextNode.next?.next
        }

        return if (oddPoint > evenPoint) "Odd" else if (oddPoint < evenPoint) "Even" else "Tie"
    }
}

fun main() {
    // Input
    val head = ListNode.create(2, 1)
    // Output
    LeetCode_3062().gameResult(head).run {
        println(this)
        require("Even" == this)
    }
}
