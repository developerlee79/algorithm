package tree

import util.TreeNode

class LeetCode_2265 {

    private var averageCount = 0

    fun averageOfSubtree(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }

        findAverage(root)

        return averageCount
    }

    private fun findAverage(node: TreeNode): Pair<Int, Int> {
        var currentTotal = node.`val`
        var currentCount = 1

        if (node.left != null) {
            val left = findAverage(node.left!!)
            currentTotal += left.first
            currentCount += left.second
        }

        if (node.right != null) {
            val right = findAverage(node.right!!)
            currentTotal += right.first
            currentCount += right.second
        }

        if (currentTotal / currentCount == node.`val`) {
            averageCount++
        }

        return Pair(currentTotal, currentCount)
    }
}

fun main() {
    // Input
    val root = TreeNode.of(4, 8, 5, 0, 1, null, 6)
    // Output
    LeetCode_2265().averageOfSubtree(root).run {
        println(this)
        require(5 == this)
    }
}
