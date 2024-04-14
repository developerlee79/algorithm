package graph

import util.TreeNode

class LeetCode_404 {

    fun sumOfLeftLeaves(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }

        if (root.left != null && root.left!!.left == null && root.left!!.right == null) {
            return root.left!!.`val` + sumOfLeftLeaves(root.right)
        }

        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right)
    }
}

fun main() {
    // Input
    val root = TreeNode.of(3, 9, 20, null, null, 15, 7)
    // Output
    LeetCode_404().sumOfLeftLeaves(root).run {
        println(this)
        require(24 == this)
    }
}
