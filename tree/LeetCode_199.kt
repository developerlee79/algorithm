package tree

import java.util.LinkedList
import java.util.Queue

class LeetCode_199 {

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    /**
     * Solution - BFS
     * Time Complexity : O(V + E)
     * Space Complexity : O(N)
     *
     * Use breadth-first search to solve the problem.
     * Because the Right-Side view is always the last node in that layer of the binary tree, so BFS and select only the last node.
     *
     * @param root binary tree
     * @return values of the nodes you can see ordered from top to bottom
     */
    fun rightSideView(root: TreeNode?): List<Int> {
        val resultList = ArrayList<Int>()
        if (root == null)
            return resultList

        val queue: Queue<TreeNode> = LinkedList()
        queue.add(root)

        while (queue.isNotEmpty()) {
            val size = queue.size

            for (i in 0 until size - 1) {
                val node = queue.poll()
                if (node.left != null)
                    queue.add(node.left)
                if (node.right != null)
                    queue.add(node.right)
            }

            val node = queue.poll()
            if (node.left != null)
                queue.add(node.left)
            if (node.right != null)
                queue.add(node.right)
            resultList.add(node.`val`)
        }

        return resultList
    }
}

fun main() {
    val root = LeetCode_199.TreeNode(1)
    root.left = LeetCode_199.TreeNode(2)
    root.right = LeetCode_199.TreeNode(3)
    root.left!!.right = LeetCode_199.TreeNode(5)
    root.right!!.right = LeetCode_199.TreeNode(4)
    println(LeetCode_199().rightSideView(root).joinToString())
}
