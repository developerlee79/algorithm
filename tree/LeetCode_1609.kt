package tree

import util.TreeNode
import java.util.LinkedList
import java.util.Queue

class LeetCode_1609 {

    private fun Int.isEven() = this xor 1 == this + 1

    fun isEvenOddTree(root: TreeNode?): Boolean {
        val nodeQueue: Queue<TreeNode> = LinkedList()
        nodeQueue.add(root)

        var isEvenLevel = true

        while (nodeQueue.isNotEmpty()) {
            val queueSize = nodeQueue.size

            var lastValue = if (isEvenLevel) 0 else Integer.MAX_VALUE

            repeat(queueSize) {
                val node = nodeQueue.poll()

                if (isEvenLevel) {
                    if (node.`val`.isEven() || node.`val` <= lastValue) {
                        return false
                    }
                } else {
                    if (!node.`val`.isEven() || node.`val` >= lastValue) {
                        return false
                    }
                }

                lastValue = node.`val`

                if (node.left != null) {
                    nodeQueue.add(node.left)
                }

                if (node.right != null) {
                    nodeQueue.add(node.right)
                }
            }

            isEvenLevel = !isEvenLevel
        }

        return true
    }
}

fun main() {
    // Input
    val root = TreeNode.of(1, 10, 4, 3, null, 7, 9, 12, 8, 6, null, null, 2)
    // Output
    LeetCode_1609().isEvenOddTree(root).run {
        println(this)
        require(this)
    }
}
