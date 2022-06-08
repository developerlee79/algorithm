package tree

import java.util.LinkedList
import java.util.Queue

class LeetCode_103 {

    /**
     * Solution - BFS
     * Time Complexity : O(V + E)
     * Space Complexity : O(N)
     *
     * Searching binary tree with Breadth-First Search.
     * Because it's zigzag order, use bool flag to distinguish zig (left) zag (right).
     *
     * @param root binary tree
     * @return zigzag level order traversal of node's values
     */
    fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
        val resultList: MutableList<List<Int>> = LinkedList()

        if (root == null) {
            return resultList
        }

        val nodeQueue: Queue<TreeNode> = LinkedList()
        nodeQueue.add(root)

        var left = false
        while (nodeQueue.isNotEmpty()) {
            val subsetList: MutableList<Int> = LinkedList()
            val queueSize = nodeQueue.size

            for (i in 0 until queueSize) {
                val node = nodeQueue.poll()

                if (left)
                    subsetList.add(0, node.`val`)
                else
                    subsetList.add(node.`val`)
                if (node.left != null)
                    nodeQueue.add(node.left)
                if (node.right != null)
                    nodeQueue.add(node.right)

            }

            resultList.add(subsetList)
            left = !left
        }

        return resultList
    }
}

fun main() {

}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}
