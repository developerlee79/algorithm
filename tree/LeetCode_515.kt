package tree

import util.TreeNode
import java.util.LinkedList
import java.util.Queue

class LeetCode_515 {

    fun largestValues(root: TreeNode?): List<Int> {
        if (root == null) {
            return emptyList()
        }

        val nodeQueue: Queue<TreeNode> = LinkedList()
        nodeQueue.add(root)

        val largestValueList = mutableListOf<Int>()

        while (nodeQueue.isNotEmpty()) {
            val currentSize = nodeQueue.size
            var rowMax = Integer.MIN_VALUE

            repeat(currentSize) {
                val currentNode = nodeQueue.poll()
                rowMax = maxOf(rowMax, currentNode.`val`)

                if (currentNode.left != null) {
                    nodeQueue.add(currentNode.left)
                }
                if (currentNode.right != null) {
                    nodeQueue.add(currentNode.right)
                }
            }

            largestValueList.add(rowMax)
        }

        return largestValueList
    }

}

fun main() {
    // Input
    val root = TreeNode.of(1, 3, 2, 5, 3, null, 9)
    // Output
    LeetCode_515().largestValues(root).run {
        println(this)
        require(
            listOf(1, 3, 9) == this
        )
    }
}
