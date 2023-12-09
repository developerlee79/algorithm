package tree

import util.TreeNode

class LeetCode_94 {

    fun inorderTraversal(root: TreeNode?): List<Int> {
        val nodeList = mutableListOf<Int>()
        search(root, nodeList)
        return nodeList
    }

    private fun search(root: TreeNode?, nodeList: MutableList<Int>) {
        if (root == null) {
            return
        }

        search(root.left, nodeList)
        nodeList.add(root.`val`)
        search(root.right, nodeList)
    }

}

fun main() {
    // Input
    val root = TreeNode.of(1, null, 2, 3)
    // Output
    LeetCode_94().inorderTraversal(root).run {
        println(this)
        require(
            listOf(1, 3, 2) == this
        )
    }
}
