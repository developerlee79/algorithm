package tree

import util.TreeNode

class LeetCode_1120 {

    private var maxAverage = 0.00

    fun maximumAverageSubtree(root: TreeNode?): Double {
        search(root)
        return maxAverage
    }

    private fun search(root: TreeNode?): Pair<Int, Int> {
        if (root == null) {
            return Pair(0, 0)
        }

        val leftSum = search(root.left)
        val rightSum = search(root.right)

        val currentSum = leftSum.first + rightSum.first + root.`val`
        val currentNodes = leftSum.second + rightSum.second + 1

        maxAverage = maxOf(maxAverage, currentSum / currentNodes.toDouble())

        return Pair(currentSum, currentNodes)
    }
}

fun main() {
    // Input
    val root = TreeNode.of(5, 6, 1)
    // Output
    LeetCode_1120().maximumAverageSubtree(root).run {
        println(this)
        require(6.00 == this)
    }
}
