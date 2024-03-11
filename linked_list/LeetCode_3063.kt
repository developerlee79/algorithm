package linked_list

import util.ListNode

class LeetCode_3063 {

    fun frequenciesOfElements(head: ListNode?): ListNode? {
        val frequencyMap = hashMapOf<Int, Int>()

        var headPointer = head

        while (headPointer != null) {
            frequencyMap.merge(headPointer.`val`, 1) { a, b -> a + b }
            headPointer = headPointer.next
        }

        val frequencyNode = ListNode(-1)
        var pointer = frequencyNode

        frequencyMap.values.forEach { frequency ->
            pointer.next = ListNode(frequency)
            pointer = pointer.next!!
        }

        return frequencyNode.next
    }
}

fun main() {
    // Input
    val head = ListNode.create(1, 1, 2, 1, 2, 3)
    // Output
    LeetCode_3063().frequenciesOfElements(head).run {
        println(this)
        println(ListNode.create(3, 2, 1)!!.equals(this))
    }
}
