package tree

class LeetCode_700 {

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    /**
     * Solution - DFS
     * Time Complexity : O(logN)
     * Space Complexity : O(1)
     *
     * Use dfs to find the target node.
     *
     * @param root root node of binary search tree
     * @param val target integer
     * @return subtree rooted with that node what value equals val
    */
    fun searchBST(root: TreeNode?, `val`: Int): TreeNode? {
        return if (root == null) {
            null
        } else if (root.`val` == `val`) {
            return root
        } else {
            val right: TreeNode? = searchBST(root.right, `val`)
            return searchBST(root.left, `val`) ?: right
        }
    }
}

fun main() {

}
