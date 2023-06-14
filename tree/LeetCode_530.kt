package tree

import util.TreeNode
import java.util.Stack

class LeetCode_530 {

    fun getMinimumDifference(root: TreeNode?): Int {
        var minDifference = Integer.MAX_VALUE
        val nodeStack = Stack<TreeNode>()

        var currentNode: TreeNode? = root
        var prevNode: TreeNode? = null

        while (currentNode != null || nodeStack.isNotEmpty()) {
            if (currentNode != null) {
                nodeStack.push(currentNode)
                currentNode = currentNode.left
            } else {
                currentNode = nodeStack.pop()

                if (prevNode != null) {
                    minDifference = minOf(minDifference, currentNode.`val` - prevNode.`val`)
                }

                prevNode = currentNode
                currentNode = currentNode.right
            }
        }

        return minDifference
    }
}

fun main() {
    // Input
    val root = TreeNode.of(4, 2, 6, 1, 3)
    // Output
    LeetCode_530().getMinimumDifference(root).run {
        println(this)
        require(1 == this)
    }
}
