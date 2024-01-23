package tree

import util.TreeNode

class LeetCode_156 {

    fun upsideDownBinaryTree(root: TreeNode?): TreeNode? {
        if (root == null) {
            return null
        }

        return reverseTree(root, null)
    }

    private fun reverseTree(root: TreeNode, sibling: TreeNode?): TreeNode {
        if (root.left == null) {
            root.left = sibling
            return root
        }

        val reversedRoot = reverseTree(root.left!!, root.right)
        setRightMostNode(reversedRoot, sibling, TreeNode(root.`val`))

        return reversedRoot
    }

    private fun setRightMostNode(root: TreeNode, leftNode: TreeNode?, rightNode: TreeNode?) {
        if (root.right == null) {
            root.right = rightNode
            root.right!!.left = leftNode
            return
        }

        setRightMostNode(root.right!!, leftNode, rightNode)
    }
}

fun main() {
    // Input
    val root = TreeNode.of(1, 2, 3, 4, 5)
    // Output
    LeetCode_156().upsideDownBinaryTree(root).run {
        println(this)
        require(
            TreeNode.of(4, 5, 2, null, null, 3, 1) == this
        )
    }
}
