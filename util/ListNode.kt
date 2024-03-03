package util

class ListNode(
    var `val`: Int,
    var next: ListNode? = null
) {

    override fun toString(): String {
        val printFormat = "val=%s, "

        val stringBuilder = StringBuilder("ListNode(${printFormat.format(`val`)}")

        var printNode = next

        while (printNode != null) {
            stringBuilder.append(printFormat.format(printNode.`val`))
            printNode = printNode.next
        }

        stringBuilder.delete(stringBuilder.length - 2, stringBuilder.length).append(")")

        return stringBuilder.toString()
    }

    fun equals(other: ListNode?): Boolean {
        var idx1: ListNode? = this
        var idx2: ListNode? = other

        while (idx1 != null && idx2 != null) {
            if (idx1.`val` != idx2.`val`) {
                return false
            }
            idx1 = idx1.next
            idx2 = idx2.next
        }

        return idx1 == idx2
    }

    companion object {

        fun create(vararg values: Int): ListNode? {
            if (values.isEmpty()) {
                return null
            }

            val head = ListNode(-1)
            var currentNode = head

            for (value in values) {
                currentNode.next = ListNode(value)
                currentNode = currentNode.next!!
            }

            return head.next
        }
    }
}
