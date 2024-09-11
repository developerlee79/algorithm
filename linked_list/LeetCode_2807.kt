package linked_list

import util.ListNode

class LeetCode_2807 {

    fun insertGreatestCommonDivisors(head: ListNode?): ListNode? {
        var pointer = head

        while (pointer?.next != null) {
            val nextPointer = pointer.next

            val greatestCommonDivisor = greatestCommonDivisor(pointer.`val`, nextPointer!!.`val`)

            val newNode = ListNode(greatestCommonDivisor)
            newNode.next = nextPointer

            pointer.next = newNode

            pointer = pointer.next!!.next
        }

        return head
    }

    private fun greatestCommonDivisor(x: Int, y: Int): Int {
        var x = x
        var y = y
        var temp: Int

        while (y > 0) {
            temp = y
            y = x % y
            x = temp
        }

        return x
    }
}

fun main() {
    // Input
    val head = ListNode.create(18, 6, 10, 3)
    // Output
    LeetCode_2807().insertGreatestCommonDivisors(head).run {
        println(this)
        require(
            ListNode.create(18, 6, 6, 2, 10, 1, 3)!!.equals(this)
        )
    }
}
