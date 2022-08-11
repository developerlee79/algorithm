package tree

class LeetCode_98 {

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    /**
     * Solution - Recursion
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     *
     * @param root root of a binary tree
     * @return determine if it is a valid binary search tree
    */
    fun isValidBST(root: TreeNode?): Boolean {
        return dfs(root, null, null)
    }

    private fun dfs(root: TreeNode?, min: TreeNode?, max: TreeNode?): Boolean {
        if (root == null) {
            return true
        }

        val isValid = dfs(root.left, min, root) && dfs(root.right, root, max)
        val isLeft = min == null || root.`val` > min.`val`
        val isRight = max == null || root.`val` < max.`val`

        return isValid && isLeft && isRight
    }
}

fun main() {
    val root = LeetCode_98.TreeNode(2)
    root.left = LeetCode_98.TreeNode(1)
    root.right = LeetCode_98.TreeNode(3)
    println(LeetCode_98().isValidBST(root))
}
