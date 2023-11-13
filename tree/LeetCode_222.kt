package tree

import util.TreeNode

class LeetCode_222 {

    private fun TreeNode?.findDepth(): Int {
        return if (this == null) -1 else 1 + left.findDepth()
    }

    fun countNodes(root: TreeNode?): Int {
        var root = root

        var depth = root.findDepth()
        var nodes = 0

        while (root != null) {
            if (root.right.findDepth() == depth - 1) {
                nodes += 1.shl(depth)
                root = root.right
            } else {
                nodes += 1.shl(depth - 1)
                root = root.left
            }

            depth--
        }

        return nodes
    }

}

fun main() {
    // Input
    val root = TreeNode.of(1, 2, 3, 4, 5, 6)
    // Output
    LeetCode_222().countNodes(root).run {
        println(this)
        require(6 == this)
    }
}
