package tree

import util.TreeNode

class LeetCode_2331 {

    fun evaluateTree(root: TreeNode?): Boolean {
        if (root == null) {
            return true
        }

        if (root.`val` == 0) {
            return false
        } else if (root.`val` == 1) {
            return true
        }

        return if (root.`val` == 2) {
            evaluateTree(root.left) || evaluateTree(root.right)
        } else {
            evaluateTree(root.left) && evaluateTree(root.right)
        }
    }
}

fun main() {
    // Input
    val root = TreeNode.of(2, 1, 3, null, null, 0, 1)
    // Output
    LeetCode_2331().evaluateTree(root).run {
        println(this)
        require(this)
    }
}
