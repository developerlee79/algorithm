package tree

import util.TreeNode

class LeetCode_1469 {

    fun getLonelyNodes(root: TreeNode?): List<Int> {
        val nodeList = mutableListOf<Int>()
        findLonelyNodes(root, true, nodeList)
        return nodeList
    }

    private fun findLonelyNodes(node: TreeNode?, hasSibling: Boolean, nodeList: MutableList<Int>) {
        if (node == null) {
            return
        }

        if (!hasSibling) {
            nodeList.add(node.`val`)
        }

        findLonelyNodes(node.left, node.right != null, nodeList)
        findLonelyNodes(node.right, node.left != null, nodeList)
    }
}

fun main() {
    // Input
    val root = TreeNode.of(1, 2, 3, null, 4)
    // Output
    LeetCode_1469().getLonelyNodes(root).run {
        println(this)
        require(
            listOf(4) == this
        )
    }
}
