package tree

import util.TreeNode
import java.util.LinkedList
import java.util.Queue

class LeetCode_111 {

    fun minDepth(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }

        val nodeQueue: Queue<TreeNode> = LinkedList()
        nodeQueue.add(root)

        var depth = 1

        while (nodeQueue.isNotEmpty()) {
            val currentSize = nodeQueue.size

            repeat(currentSize) {
                val currentNode = nodeQueue.poll()

                if (currentNode.left == null && currentNode.right == null) {
                    return depth
                }

                if (currentNode.left != null) {
                    nodeQueue.add(currentNode.left)
                }
                if (currentNode.right != null) {
                    nodeQueue.add(currentNode.right)
                }
            }

            depth++
        }

        return depth
    }
}

fun main() {
    // Input
    val root = TreeNode.of(3, 9, 20, null, null, 15, 7)
    // Output
    LeetCode_111().minDepth(root).run {
        println(this)
        require(2 == this)
    }
}
