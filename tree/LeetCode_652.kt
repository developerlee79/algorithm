package tree

import util.TreeNode

class LeetCode_652 {

    fun findDuplicateSubtrees(root: TreeNode?): List<TreeNode?> {
        val resultList = mutableListOf<TreeNode>()
        search(root, hashMapOf(), resultList)
        return resultList
    }

    private fun search(node: TreeNode?, nodeMap: HashMap<String, Int>, resultList: MutableList<TreeNode>): String {
        if (node == null) {
            return ""
        }

        val searchString = "${node.`val`}.${search(node.left, nodeMap, resultList)}.${search(node.right, nodeMap, resultList)}"

        nodeMap.merge(searchString, 1) { a, b -> a + b }

        if (nodeMap[searchString] == 2) {
            resultList.add(node)
        }

        return searchString
    }
}

fun main() {
    // Input
    val root = TreeNode.of(1, 2, 3, 4, null, 2, 4, null, null, 4)
    // Output
    println(
        LeetCode_652().findDuplicateSubtrees(root)
    )
}
