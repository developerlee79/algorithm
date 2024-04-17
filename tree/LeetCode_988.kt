package tree

import util.TreeNode

class LeetCode_988 {

    private fun TreeNode.isLeaf() = this.left == null && this.right == null

    private fun TreeNode.hasLeft() = this.left != null

    private fun TreeNode.hasRight() = this.right != null

    fun smallestFromLeaf(root: TreeNode?): String {
        if (root == null) {
            return ""
        }

        val letterStringBuilder = StringBuilder()
        val letterList = mutableListOf<String>()

        constructLetterStrings(root, letterStringBuilder, letterList)

        letterList.sortWith { a, b -> a.isLexicographicallySmallerThen(b) }

        return letterList.first()
    }

    private fun String.isLexicographicallySmallerThen(other: String): Int {
        val thisSize = this.length
        val otherSize = other.length

        repeat(minOf(thisSize, otherSize)) {
            if (this[it] != other[it]) {
                return this[it] - other[it]
            }
        }

        return thisSize - otherSize
    }

    private fun constructLetterStrings(
        node: TreeNode,
        letterStringBuilder: StringBuilder,
        letterList: MutableList<String>
    ) {
        letterStringBuilder.append('a' + node.`val`)

        if (node.isLeaf()) {
            letterList.add(letterStringBuilder.reversed().toString())
        }

        if (node.hasLeft()) {
            constructLetterStrings(node.left!!, letterStringBuilder, letterList)
        }

        if (node.hasRight()) {
            println(letterStringBuilder)
            constructLetterStrings(node.right!!, letterStringBuilder, letterList)
        }

        letterStringBuilder.deleteAt(letterStringBuilder.lastIndex)
    }
}

fun main() {
    // Input
    val root = TreeNode.of(0, 1, 2, 3, 4, 3, 4)
    // Output
    LeetCode_988().smallestFromLeaf(root).run {
        println(this)
        require("dba" == this)
    }
}
