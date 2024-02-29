package tree

import util.TreeNode

class LeetCode_1973 {

    private var count = 0

    fun equalToDescendants(root: TreeNode?): Int {
        findTotalSum(root)
        return count
    }

    private fun findTotalSum(node: TreeNode?): Int {
        if (node == null) {
            return 0
        }

        val leftSum = findTotalSum(node.left)
        val rightSum = findTotalSum(node.right)

        if (leftSum + rightSum == node.`val`) {
            count++
        }

        return node.`val` + leftSum + rightSum
    }
}

fun main() {
    // Input
    val root = TreeNode.of(10, 3, 4, 2, 1)
    // Output
    LeetCode_1973().equalToDescendants(root).run {
        println(this)
        require(2 == this)
    }
}
