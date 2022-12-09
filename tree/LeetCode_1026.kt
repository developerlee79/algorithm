package tree

import util.TreeNode

class LeetCode_1026 {

    private var maxCount = 0

    fun maxAncestorDiff(root: TreeNode?) =
        root?.let {
            search(root, root.`val`, root.`val`)
            maxCount
        } ?: 0

    private fun search(node: TreeNode?, min: Int, max: Int) {
        node?.let {
            val min = minOf(it.`val`, min)
            val max = maxOf(it.`val`, max)

            maxCount = maxOf(maxCount, max - min)

            search(it.left, min, max)
            search(it.right, min, max)
        }
    }
}

fun main() {
    // Input
    val root = TreeNode.of(
        8, 3, 10, 1, 6, null, 14, null, null, 4, 7, 13
    )
    // Output
    val result = LeetCode_1026().maxAncestorDiff(root)
    println(result)
    require(result == 7)
}
