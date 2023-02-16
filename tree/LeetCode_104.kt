package tree

import util.TreeNode

class LeetCode_104 {

    fun maxDepth(root: TreeNode?): Int {
        return root?.let {
            maxOf(
                maxDepth(root.left) + 1,
                maxDepth(root.right) + 1
            )
        } ?: 0
    }
}

fun main() {
    // Input
    val root = TreeNode.of(3, 9, 20, null, null, 15, 7)
    // Output
    LeetCode_104().maxDepth(root).let {
        println(it)
        require(it == 3)
    }
}
