package tree

import util.TreeNode
import java.util.LinkedList
import java.util.Queue

class LeetCode_1161 {

    fun maxLevelSum(root: TreeNode?): Int {
        if (root == null) {
            return -1
        }

        val nodeQueue: Queue<TreeNode> = LinkedList()
        nodeQueue.add(root)

        var maxSum = root.`val`
        var maxLevel = 1
        var currentLevel = 1

        while (nodeQueue.isNotEmpty()) {
            val currentSize = nodeQueue.size

            var currentSum = 0

            repeat(currentSize) {
                val currentNode = nodeQueue.poll()
                currentSum += currentNode.`val`

                if (currentNode.left != null) {
                    nodeQueue.add(currentNode.left)
                }
                if (currentNode.right != null) {
                    nodeQueue.add(currentNode.right)
                }
            }

            if (currentSum > maxSum) {
                maxSum = currentSum
                maxLevel = currentLevel
            }

            currentLevel++
        }

        return maxLevel
    }
}

fun main() {
    // Input
    val root = TreeNode.of(1, 7, 0, 7, -8, null, null)
    // Output
    LeetCode_1161().maxLevelSum(root).run {
        println(this)
        require(2 == this)
    }
}
