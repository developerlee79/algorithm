package tree

class LeetCode_872 {

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun leafSimilar(root1: TreeNode?, root2: TreeNode?): Boolean {
        val leafList1 = mutableListOf<Int>()
        val leafList2 = mutableListOf<Int>()

        search(root1!!, leafList1)
        search(root2!!, leafList2)

        return leafList1 == leafList2
    }

    private fun search(root: TreeNode, leafList: MutableList<Int>) {
        if (root.left == null && root.right == null) {
            leafList.add(root.`val`)
        }

        root.left?.let {
            search(it, leafList)
        }
        root.right?.let {
            search(it, leafList)
        }
    }
}

fun main() {
    // Input
    val root1 = LeetCode_872.TreeNode(3)
    root1.left = LeetCode_872.TreeNode(5)
    root1.right = LeetCode_872.TreeNode(1)
    root1.left!!.left = LeetCode_872.TreeNode(6)
    root1.left!!.right = LeetCode_872.TreeNode(2)
    root1.left!!.right!!.left = LeetCode_872.TreeNode(7)
    root1.left!!.right!!.right = LeetCode_872.TreeNode(4)
    root1.right!!.left = LeetCode_872.TreeNode(9)
    root1.right!!.right = LeetCode_872.TreeNode(8)

    val root2 = LeetCode_872.TreeNode(3)
    root2.left = LeetCode_872.TreeNode(5)
    root2.right = LeetCode_872.TreeNode(1)
    root2.left!!.left = LeetCode_872.TreeNode(6)
    root2.left!!.right = LeetCode_872.TreeNode(7)
    root2.right!!.left = LeetCode_872.TreeNode(4)
    root2.right!!.right = LeetCode_872.TreeNode(2)
    root2.right!!.right!!.left = LeetCode_872.TreeNode(9)
    root2.right!!.right!!.right = LeetCode_872.TreeNode(8)
    // Output
    val result = LeetCode_872().leafSimilar(root1, root2)
    println(result)
    require(result)
}
