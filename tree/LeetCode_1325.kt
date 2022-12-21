package tree

import util.TreeNode

class LeetCode_1325 {

    private fun TreeNode.isLeaf() =
        left == null && right == null

    fun removeLeafNodes(root: TreeNode?, target: Int): TreeNode? {
        dfs(root, target)

        return root?.let {
            if (root.isLeaf() && root.`val` == target) {
                return null
            }
            root
        }
    }

    private fun dfs(currentNode: TreeNode?, target: Int) {
        currentNode?.run {
            this.left?.let {
                dfs(it, target)

                if (it.isLeaf() && it.`val` == target) {
                    currentNode.left = null
                }
            }
            this.right?.let {
                dfs(it, target)

                if (it.isLeaf() && it.`val` == target) {
                    currentNode.right = null
                }
            }
        }
    }
}

fun main() {
    // Input
    val root = TreeNode.of(1, 2, 3, 2, null, 2, 4)
    val target = 2
    // Output
    LeetCode_1325().removeLeafNodes(root, target).let {
        println(it.toString())
        require(
            TreeNode.of(1, null, 3, null, 4).toString() == it.toString()
        )
    }
}
