package tree

class LeetCode_814 {

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    /**
     * Solution : Depth-First Search
     * Time Complexity : O(N)
     * Space Complexity : O(1)
     *
     * Postorder traverse to find prune node.
     *
     * @param root root of a binary tree
     * @return return the same tree where every subtree (of the given tree) not containing a 1 has been removed
    */
    fun pruneTree(root: TreeNode?): TreeNode? {
        return search(root)
    }

    private fun search(node: TreeNode?): TreeNode? {
        if (node == null) {
            return null
        }

        node.left = search(node.left)
        node.right = search(node.right)

        if (isPruneNode(node)) {
            return null
        }

        return node
    }

    private fun isPruneNode(node: TreeNode): Boolean {
        return node.`val` == 0 && node.left == null && node.right == null
    }
}

fun main() {
    val root = LeetCode_814.TreeNode(1)
    root.left = LeetCode_814.TreeNode(1)
    root.right = LeetCode_814.TreeNode(0)
    root.left!!.left = LeetCode_814.TreeNode(1)
    root.left!!.right = LeetCode_814.TreeNode(1)
    root.left!!.left!!.left = LeetCode_814.TreeNode(0)
    root.right!!.left = LeetCode_814.TreeNode(0)
    root.right!!.right = LeetCode_814.TreeNode(1)

    val result = LeetCode_814().pruneTree(root)
    search(result)
}

fun search(root: LeetCode_814.TreeNode?) {
    if (root == null) {
        return
    }
    search(root.left)
    println(root.`val`)
    search(root.right)
}
