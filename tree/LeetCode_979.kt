package tree

import util.TreeNode
import kotlin.math.abs

class LeetCode_979 {

    private var moves = 0

    fun distributeCoins(root: TreeNode?): Int {
        findCoins(root)
        return moves
    }

    private fun findCoins(node: TreeNode?): Int {
        if (node == null) {
            return 0
        }

        val leftMove = findCoins(node.left)
        val rightMove = findCoins(node.right)

        moves += abs(leftMove) + abs(rightMove)

        return node.`val` + leftMove + rightMove - 1
    }
}

fun main() {
    // Input
    val root = TreeNode.of(3, 0, 0)
    // Output
    LeetCode_979().distributeCoins(root).run {
        println(this)
        require(2 == this)
    }
}
