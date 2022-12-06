package util

class ListNode(
    var `val`: Int
) {
    var next: ListNode? = null

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
