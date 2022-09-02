package tree

import java.util.LinkedList
import java.util.Queue

class LeetCode_637 {

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    /**
     * Solution - BFS
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     *
     * Classic BFS.
     *
     * @param root root of a binary tree
     * @return average value of the nodes on each level in the form of an array
     */
    fun averageOfLevels(root: TreeNode?): DoubleArray {
        if (root == null) {
            return doubleArrayOf()
        }

        val result = mutableListOf<Double>()

        val queue: Queue<TreeNode> = LinkedList()
        queue.add(root)

        while (queue.isNotEmpty()) {
            val size = queue.size
            var count = 0.0

            for (i in 0 until size) {
                val currentNode = queue.poll()
                count += currentNode.`val`

                if (currentNode.left != null) {
                    queue.add(currentNode.left)
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right)
                }
            }

            result.add(count.div(size))
        }

        return result.toDoubleArray()
    }
}

fun main() {
    val root = LeetCode_637.TreeNode(3)
    root.left = LeetCode_637.TreeNode(9)
    root.right = LeetCode_637.TreeNode(20)
    root.right!!.left = LeetCode_637.TreeNode(15)
    root.right!!.right = LeetCode_637.TreeNode(7)
    println(LeetCode_637().averageOfLevels(root).joinToString())
}
