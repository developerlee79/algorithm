package linked_list

import util.ListNode
import kotlin.math.pow

class LeetCode_234 {

    fun isPalindrome(head: ListNode?): Boolean {
        if (head?.next == null) {
            return true
        }

        var midNode = head
        var endNode = head

        var valueHash = 0
        var weight = 0

        val m = 11

        while (endNode?.next != null) {
            valueHash += rollingHash(midNode!!.`val`, m, weight++)
            midNode = midNode.next
            endNode = endNode.next?.next
        }

        if (endNode != null) {
            midNode = midNode?.next
        }

        while (midNode != null) {
            valueHash -= rollingHash(midNode.`val`, m,-- weight)
            midNode = midNode.next
        }

        return valueHash == 0
    }

    private fun rollingHash(target: Int, m: Int, weight: Int): Int =
        target * (m.toDouble().pow(weight).toInt())
}

fun main() {
// Input
    val head = ListNode.create(1, 2, 2, 1)
    // Output
    LeetCode_234().isPalindrome(head).run {
        println(this)
        require(this)
    }
}
