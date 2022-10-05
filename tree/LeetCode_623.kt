package tree

class LeetCode_623 {

    data class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    /**
     * Problem : Add One Row to Tree (623)
     * Solution : Depth-First Search
     * Time Complexity : O(N)
     * Space Complexity : O(1)
     *
     * Adds nodes to the binary tree each time the depth reached by the depth-first search is reached.
     *
     * @param root root of a binary tree
     * @param val integer which represent value of node to be added at depth
     * @param depth integer which represent depth of node to be added
     * @return binary tree which added node(val) at given depth
    */
    fun addOneRow(root: TreeNode?, `val`: Int, depth: Int): TreeNode? {
        val tempRoot = TreeNode(-1)
        tempRoot.left = root
        search(root, tempRoot, `val`, depth, true)
        return tempRoot.left
    }

    private fun search(currentNode: TreeNode?, lastNode: TreeNode, `val`: Int, depth: Int, isLeft: Boolean) {
        if (currentNode == null) {
            if (depth == 1) {
                val newRoot = TreeNode(`val`)
                if (isLeft) {
                    lastNode.left = newRoot
                } else {
                    lastNode.right = newRoot
                }
            }
            return
        }

        if (depth == 1) {
            val newRoot = TreeNode(`val`)
            if (isLeft) {
                newRoot.left = currentNode
                lastNode.left = newRoot
            } else {
                newRoot.right = currentNode
                lastNode.right = newRoot
            }
            return
        }

        search(currentNode.left, currentNode, `val`, depth - 1, true)
        search(currentNode.right, currentNode, `val`, depth - 1, false)
    }
}

fun main() {
    // Input
    val root = LeetCode_623.TreeNode(4)
    root.left = LeetCode_623.TreeNode(2)
    root.right = LeetCode_623.TreeNode(6)
    root.left!!.left = LeetCode_623.TreeNode(3)
    root.left!!.right = LeetCode_623.TreeNode(1)
    root.right!!.left = LeetCode_623.TreeNode(5)
    val `val` = 1
    val depth = 2
    // Output
    val result = LeetCode_623().addOneRow(root, `val`, depth)
    println(result)
}
