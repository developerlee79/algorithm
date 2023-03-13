package tree

import java.util.Queue
import util.TreeNode
import java.util.LinkedList

class LeetCode_101 {

    private fun TreeNode.valueEquals(targetNode: TreeNode) = this.`val` == targetNode.`val`

    fun isSymmetric(root: TreeNode?): Boolean {
        val nodeQueue: Queue<TreeNode?> = LinkedList()
        nodeQueue.add(root?.left)
        nodeQueue.add(root?.right)

        while (nodeQueue.isNotEmpty()) {
            val currentSize = nodeQueue.size

            repeat(currentSize / 2) {
                val first = nodeQueue.poll()
                val last = nodeQueue.poll()

                if (first != null && last != null) {
                    if (!first.valueEquals(last)) {
                        return false
                    }
                    nodeQueue.add(first.left)
                    nodeQueue.add(last.right)
                    nodeQueue.add(first.right)
                    nodeQueue.add(last.left)
                } else if (first != last) {
                    return false
                }
            }
        }

        return true
    }
}

fun main() {
    // Input
    val root = TreeNode.of(1, 2, 2, 3, 4, 4, 3)
    // Output
    LeetCode_101().isSymmetric(root).let {
        println(it)
        require(it)
    }
}
