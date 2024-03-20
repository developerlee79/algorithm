package linked_list

import util.ListNode

class LeetCode_1669 {

    fun mergeInBetween(list1: ListNode?, a: Int, b: Int, list2: ListNode?): ListNode? {
        var index = 0

        var headNode = list1

        while (index < a - 1) {
            headNode = headNode?.next
            index++
        }

        var nextNode = headNode

        while (index <= b) {
            nextNode = nextNode?.next
            index++
        }

        var secondListNode = list2

        while (secondListNode?.next != null) {
            secondListNode = secondListNode.next
        }

        headNode?.next = list2
        secondListNode?.next = nextNode

        return list1
    }
}

fun main() {
    // Input
    val list1 = ListNode.create(10, 1, 13, 6, 9, 5)
    val a = 3
    val b = 4
    val list2 = ListNode.create(1000000, 1000001, 1000002)
    // Output
    LeetCode_1669().mergeInBetween(list1, a, b, list2).run {
        println(this)
        require(
            ListNode.create(10,1,13,1000000,1000001,1000002,5)!!.equals(this)
        )
    }
}
