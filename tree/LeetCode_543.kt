package tree

import util.TreeNode

class LeetCode_543 {

    fun diameterOfBinaryTree(root: TreeNode?): Int {
        return findDiameter(root).first
    }

    private fun findDiameter(node: TreeNode?): Pair<Int, Int> {
        if (node == null) {
            return Pair(0, 0)
        }

        val left = findDiameter(node.left)
        val right = findDiameter(node.right)

        val longestDiameter = maxOf(
            maxOf(left.first, right.first),
            (left.second + right.second)
        )
        val height = maxOf(left.second, right.second) + 1

        return Pair(longestDiameter, height)
    }
}

fun main() {
    // Input
    val root = TreeNode.of(1, 2, 3, 4, 5)
    // Output
    LeetCode_543().diameterOfBinaryTree(root).run {
        println(this)
        require(3 == this)
    }
}
