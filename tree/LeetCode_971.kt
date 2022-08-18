package tree

class LeetCode_971 {

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    /**
     * Solution - Depth-First Search (pre-order traversal)
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     *
     * Pre-order traversal the tree and verifies that it is the same value as the voyage array.
     * If the values are different, compare the values of the right child node to the values of the left child node with the values of the right child node.
     * If the same, it means that you can create a pre-order traversal when you flip the current node, so add the value of the current node to the result array.
     *
     * @param root binary tree with n nodes
     * @param voyage sequence of n values which is the desired pre-order traversal of the binary tree
     * @return list of the values of all flipped nodes
    */
    fun flipMatchVoyage(root: TreeNode?, voyage: IntArray): List<Int> {
        val nodeList = mutableListOf<Int>()
        return if (dfs(root, voyage, nodeList))
            nodeList
        else
            listOf(-1)
    }

    private var index = 0

    private fun dfs(root: TreeNode?, voyage: IntArray, nodeList: MutableList<Int>): Boolean {
        return if (root == null) {
            true
        } else if (root.`val` != voyage[index++]) {
            false
        } else if (root.left != null && root.left!!.`val` != voyage[index]) {
            nodeList.add(root.`val`)
            return dfs(root.right, voyage, nodeList) && dfs(root.left, voyage, nodeList)
        } else {
            dfs(root.left, voyage, nodeList) && dfs(root.right, voyage, nodeList)
        }
    }
}

fun main() {
    val root = LeetCode_971.TreeNode(1)
    root.left = LeetCode_971.TreeNode(2)
    root.right = LeetCode_971.TreeNode(3)
    val voyage = intArrayOf(1, 3, 2)
    println(LeetCode_971().flipMatchVoyage(root, voyage))
}
