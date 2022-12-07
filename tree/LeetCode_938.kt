package tree

import java.util.LinkedList
import java.util.Queue

class LeetCode_938 {

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun rangeSumBST(root: TreeNode?, low: Int, high: Int): Int {
        val queue: Queue<TreeNode> = LinkedList()
        queue.add(root)

        var sumOfBst = 0

        while (queue.isNotEmpty()) {
            val currentNode = queue.poll()

            if (currentNode.`val` in low .. high) {
                sumOfBst += currentNode.`val`
            }

            currentNode.left?.let { queue.add(it) }
            currentNode.right?.let { queue.add(it) }
        }

        return sumOfBst
    }
}

fun main() {
    // Input
    val root = LeetCode_938.TreeNode(10)
    root.left = LeetCode_938.TreeNode(5)
    root.right = LeetCode_938.TreeNode(15)
    root.left!!.left = LeetCode_938.TreeNode(3)
    root.left!!.right = LeetCode_938.TreeNode(7)
    root.right!!.right = LeetCode_938.TreeNode(18)
    val low = 7
    val high = 15
    // Output
    val result = LeetCode_938().rangeSumBST(root, low, high)
    println(result)
    require(result == 32)
}
