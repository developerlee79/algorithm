package tree

import util.TreeNode
import java.util.Stack

class LeetCode_144 {

    fun preorderTraversal(root: TreeNode?): List<Int> {
        val nodeStack = Stack<TreeNode>()
        val nodeValues = mutableListOf<Int>()

        nodeStack.push(root)

        while (nodeStack.isNotEmpty()) {
            nodeStack.pop()?.let { currentNode ->
                nodeValues.add(currentNode.`val`)
                nodeStack.push(currentNode.right)
                nodeStack.push(currentNode.left)
            }
        }

        return nodeValues
    }

    fun preorderTraversalRecursive(root: TreeNode?) = mutableListOf<Int>().also { dfs(root, it) }

    private fun dfs(root: TreeNode?, nodeValues: MutableList<Int>) {
        root?.let {
            nodeValues.add(it.`val`)
            dfs(it.left, nodeValues)
            dfs(it.right, nodeValues)
        }
    }
}

fun main() {
    // Input
    val root = TreeNode.of(1, null, 2, 3)
    // Output
    LeetCode_144().preorderTraversal(root).let {
        println(it)
        require(it == listOf(1, 2, 3))
    }
}
