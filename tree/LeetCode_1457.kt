package tree

class LeetCode_1457 {

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    /**
     * Solution - DFS
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     *
     * @param root binary tree
     * @return the number of pseudo-palindromic paths going from the root node to leaf nodes
    */
    fun pseudoPalindromicPaths (root: TreeNode?): Int {
        return search(root, mutableSetOf())
    }

    private fun search(root: TreeNode?, nodeSet: MutableSet<Int>): Int {
        if (root == null) {
            return 0
        }

        if (nodeSet.contains(root.`val`)) {
            nodeSet.remove(root.`val`)
        } else {
            nodeSet.add(root.`val`)
        }

        return if (root.left == null && root.right == null) {
             if (nodeSet.size < 2) 1 else 0
        } else {
            search(root.left, HashSet(nodeSet)) + search(root.right, HashSet(nodeSet))
        }
    }
}

fun main() {
    val root = LeetCode_1457.TreeNode(2)
    root.left = LeetCode_1457.TreeNode(3)
    root.right = LeetCode_1457.TreeNode(1)
    root.left!!.left = LeetCode_1457.TreeNode(3)
    root.left!!.right = LeetCode_1457.TreeNode(1)
    root.right!!.right = LeetCode_1457.TreeNode(1)
    println(LeetCode_1457().pseudoPalindromicPaths(root))
}
