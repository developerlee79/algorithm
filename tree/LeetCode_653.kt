package tree


class LeetCode_653 {

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    /**
     * Solution : DFS
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     *
     * @param root root of a Binary Search Tree
     * @param k target number
     * @return return true if there exist two elements in the BST such that their sum is equal to the given target
    */
    fun findTarget(root: TreeNode?, k: Int): Boolean {
        val values = mutableListOf<Int>()
        search(root, values)

        var i = 0
        var j = values.size - 1
        while (i < j) {
            val sum = values[i] + values[j]
            if (sum == k) {
                return true
            }
            if (sum < k) {
                i++
            } else {
                j--
            }
        }

        return false
    }

    private fun search(node: TreeNode?, values: MutableList<Int>) {
        if (node == null) {
            return
        }
        if (node.left != null) {
            search(node.left, values)
        }
        values.add(node.`val`)
        if (node.right != null) {
            search(node.right, values)
        }
    }
}

fun main() {
    // Input
    val root = LeetCode_653.TreeNode(5)
    root.left = LeetCode_653.TreeNode(3)
    root.right = LeetCode_653.TreeNode(6)
    root.left!!.left = LeetCode_653.TreeNode(2)
    root.left!!.right = LeetCode_653.TreeNode(4)
    root.right!!.right = LeetCode_653.TreeNode(7)
    val k = 7
    // Output
    val result = LeetCode_653().findTarget(root, k)
    println(result)
    assert(result)
}
