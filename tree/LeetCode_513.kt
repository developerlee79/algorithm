package tree

import util.TreeNode
import java.util.LinkedList
import java.util.Queue

class LeetCode_513 {

    fun findBottomLeftValue(root: TreeNode?): Int {
        val nodeQueue: Queue<TreeNode> = LinkedList()
        nodeQueue.add(root)

        while (nodeQueue.isNotEmpty()) {
            val leftMostNodeValue = nodeQueue.peek().`val`

            val currentSize = nodeQueue.size

            repeat(currentSize) {
                val node = nodeQueue.poll()

                if (node.left != null) {
                    nodeQueue.add(node.left)
                }

                if (node.right != null) {
                    nodeQueue.add(node.right)
                }
            }

            if (nodeQueue.isEmpty()) {
                return leftMostNodeValue
            }
        }

        return -1
    }
}

fun main() {
    // Input
    val root = TreeNode.of(2, 1, 3)
    // Output
    LeetCode_513().findBottomLeftValue(root).run {
        println(this)
        require(1 == this)
    }
}
