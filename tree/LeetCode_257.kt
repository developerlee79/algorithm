package tree

import util.TreeNode

class LeetCode_257 {

    fun binaryTreePaths(root: TreeNode?): List<String> {
        val resultList = mutableListOf<String>()
        search(root, StringBuilder(), resultList)
        return resultList
    }

    private fun search(root: TreeNode?, stringBuilder: StringBuilder, resultList: MutableList<String>) {
        if (root == null) {
            return
        }

        stringBuilder.append("${root.`val`}")

        if (root.left == null && root.right == null) {
            resultList.add(stringBuilder.toString())
            return
        }

        stringBuilder.append("->")

        search(root.left, StringBuilder(stringBuilder), resultList)
        search(root.right, StringBuilder(stringBuilder), resultList)
    }
}

fun main() {
    // Input
    val root = TreeNode.of(1, 2, 3, null, 5)
    // Output
    LeetCode_257().binaryTreePaths(root).run {
        println(this)
        require(
            listOf("1->2->5", "1->3") == this
        )
    }
}
