package tree

import util.TreeNode

class LeetCode_606 {

    fun tree2str(root: TreeNode?): String {
        if (root == null) return ""
        val treeStringBuilder = StringBuilder()
        search(root, treeStringBuilder)
        return treeStringBuilder.toString()
    }

    private fun search(root: TreeNode, treeStringBuilder: StringBuilder) {
        treeStringBuilder.append(root.`val`)

        if (root.left != null) {
            treeStringBuilder.append("(")
            search(root.left!!, treeStringBuilder)
            treeStringBuilder.append(")")
        }

        if (root.right != null) {
            if (root.left == null) {
                treeStringBuilder.append("()")
            }
            treeStringBuilder.append("(")
            search(root.right!!, treeStringBuilder)
            treeStringBuilder.append(")")
        }
    }
}

fun main() {
    val root = TreeNode.of(1, 2, 3, 4)
    LeetCode_606().tree2str(root).run {
        println(this)
        require("1(2(4))(3)" == this)
    }
}
