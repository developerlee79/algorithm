package tree

import java.util.LinkedList
import java.util.Queue
import util.TreeNode

class LeetCode_662 {

    fun widthOfBinaryTree(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }

        val nodeQueue: Queue<Pair<Int, TreeNode>> = LinkedList()
        nodeQueue.add(Pair(0, root))

        var maxWidth = 1

        while (nodeQueue.isNotEmpty()) {
            val currentSize = nodeQueue.size
            var firstIndex = -1
            var lastIndex = 0

            repeat(currentSize) {
                val currentElement = nodeQueue.poll()

                val currentIndex = currentElement.first
                val currentNode = currentElement.second

                if (firstIndex == -1) {
                    firstIndex = currentIndex
                }

                lastIndex = currentIndex

                if (currentNode.left != null) {
                    nodeQueue.add(Pair(currentIndex * 2, currentNode.left!!))
                }

                if (currentNode.right != null) {
                    nodeQueue.add(Pair(currentIndex * 2 + 1, currentNode.right!!))
                }
            }

            maxWidth = maxOf(maxWidth, lastIndex - firstIndex + 1)
        }

        return maxWidth
    }

}

fun main() {
    // Input
    val root = TreeNode.of(1, 3, 2, 5, 3, null, 9)
    // Output
    LeetCode_662().widthOfBinaryTree(root).run {
        println(this)
        require(4 == this)
    }
}
