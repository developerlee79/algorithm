package tree

import util.TreeNode

class LeetCode_129 {

    fun sumNumbers(root: TreeNode?): Int {
        val numbers = concatAllRootValueToString(root, StringBuilder()).split("$")

        var sumOfNumbers = 0

        numbers.forEach {
            if (it.isNotEmpty()) {
                sumOfNumbers += it.toInt()
            }
        }

        return sumOfNumbers
    }

    private fun concatAllRootValueToString(root: TreeNode?, stringBuilder: StringBuilder): String {
        if (root == null) {
            return ""
        }

        stringBuilder.append(root.`val`)

        if (root.left == null && root.right == null) {
            return stringBuilder.toString()
        }

        return concatAllRootValueToString(root.left, StringBuilder(stringBuilder)) + "$" + concatAllRootValueToString(root.right, StringBuilder(stringBuilder))
    }
}

fun main() {
    // Input
    val root = TreeNode.of(1, 2, 3)
    // Output
    LeetCode_129().sumNumbers(root).let {
        println(it)
        require(it == 25)
    }
}
