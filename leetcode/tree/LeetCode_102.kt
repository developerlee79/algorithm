package tree

import java.util.LinkedList
import java.util.Queue

class LeetCode_102 {

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    /**
     * Solution - BFS
     * Time Complexity : O(V + E)
     * Space Complexity : O(N)
     *
     * Classic BFS problem.
     *
     * @param root binary tree
     * @return level order traversal of its nodes' values
     */
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        val resultList = mutableListOf<List<Int>>()

        if (root == null) {
            return resultList
        }

        val queue: Queue<TreeNode> = LinkedList()
        queue.add(root)

        while (queue.isNotEmpty()) {
            val subArray = mutableListOf<Int>()
            val size = queue.size

            for (i in 0 until size) {
                val currentNode = queue.poll()
                subArray.add(currentNode.`val`)
                if (currentNode.left != null)
                    queue.add(currentNode.left)
                if (currentNode.right != null)
                    queue.add(currentNode.right)
            }

            resultList.add(subArray)
        }

        return resultList
    }
}

fun main() {
    val root = LeetCode_102.TreeNode(3)
    root.left = LeetCode_102.TreeNode(9)
    root.right = LeetCode_102.TreeNode(20)
    root.right!!.left = LeetCode_102.TreeNode(15)
    root.right!!.right = LeetCode_102.TreeNode(7)
    println(LeetCode_102().levelOrder(root))
}
