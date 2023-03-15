package tree

import util.TreeNode
import java.util.LinkedList
import java.util.Queue

class LeetCode_958 {

    fun isCompleteTree(root: TreeNode?): Boolean {
        val nodeQueue: Queue<TreeNode> = LinkedList()
        nodeQueue.add(root)

        var isCompleted = true

        while (nodeQueue.isNotEmpty()) {
            val currentNode = nodeQueue.poll()

            if (currentNode.left != null) {
                if (!isCompleted) {
                    return false
                }

                nodeQueue.add(currentNode.left)

                if (currentNode.right != null) {
                    nodeQueue.add(currentNode.right)
                } else {
                    isCompleted = false
                }
            } else if (currentNode.right != null) {
                return false
            } else {
                isCompleted = false
            }
        }

        return true
    }
}

fun main() {
    // Input
    val root = TreeNode.of(1, 2, 3, 4, 5, 6)
    // Output
    LeetCode_958().isCompleteTree(root).let {
        println(it)
        require(it)
    }
}
