package linked_list

import util.ListNode

class LeetCode_725 {

    fun splitListToParts(head: ListNode?, k: Int): Array<ListNode?> {
        val result = arrayOfNulls<ListNode>(k)
        var size = 0
        var node = head

        while (node != null) {
            node = node.next
            size++
        }

        val n = size / k
        var r = size % k

        var prev: ListNode? = null
        node = head

        var i = 0
        while (node != null) {
            result[i] = node
            for (j in 0 until n + if (r > 0) 1 else 0) {
                prev = node
                node = node?.next
            }
            prev?.next = null
            i++
            r--
        }

        return result
    }
}

fun main() {
    // Input
    val head = ListNode.create(1, 2, 3)
    val k = 5
    // Output
    LeetCode_725().splitListToParts(head, k).run {
        println(this.joinToString())
        require(
            arrayOf(
                ListNode.create(1),
                ListNode.create(2),
                ListNode.create(3),
                null,
                null
            ).contentEquals(this)
        )
    }
}
