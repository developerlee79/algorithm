package linked_list

import util.ListNode

class LeetCode_1171 {

    fun removeZeroSumSublists(head: ListNode?): ListNode? {
        val resultHead = ListNode(-1)
        resultHead.next = head

        val prefixSumMap = hashMapOf<Int, ListNode>()
        prefixSumMap[0] = resultHead

        var currentNode: ListNode? = head
        var prefixSum = 0

        while (currentNode != null) {
            prefixSum += currentNode.`val`

            if (prefixSumMap.containsKey(prefixSum)) {
                val prevNode = prefixSumMap[prefixSum]!!
                var tempNode: ListNode? = prevNode

                var prefix = prefixSum

                while (tempNode != currentNode) {
                    tempNode = tempNode?.next
                    prefix += tempNode?.`val` ?: 0

                    if (tempNode != currentNode) {
                        prefixSumMap.remove(prefix)
                    }
                }

                prevNode.next = currentNode.next
            } else {
                prefixSumMap[prefixSum] = currentNode
            }

            currentNode = currentNode.next
        }

        return resultHead.next
    }
}

fun main() {
    // Input
    val head = ListNode.create(1, 2, -3, 3, 1)
    // Output
    LeetCode_1171().removeZeroSumSublists(head).run {
        println(this)
        require(
            ListNode.create(3, 1)!!.equals(this)
        )
    }
}
