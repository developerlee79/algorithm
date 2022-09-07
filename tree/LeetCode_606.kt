package tree

class LeetCode_606 {

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    /**
     * Solution - StringBuilder
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     *
     * Simple recursion.
     * Put left parentheses, proceed with the recursion, and put right parenthesis.
     * If the right node exists, also add the left node to resolve the Edge case.
     *
     * @param root root of a binary tree
     * @return string consisting of parenthesis and integers from a binary tree with the preorder traversal way
    */
    fun tree2str(root: TreeNode?): String {
        return search(root, StringBuilder()).toString()
    }

    private fun search(root: TreeNode?, builder: StringBuilder): StringBuilder {
        if (root == null) {
            return builder
        }

        builder.append(root.`val`)

        if (root.left != null) {
            search(root.left, builder.append("(")).append(")")
        } else if (root.right != null) {
            search(root.left, builder.append("(")).append(")")
        }

        if (root.right != null) {
            search(root.right, builder.append("(")).append(")")
        }

        return builder
    }
}

fun main() {
    val root = LeetCode_606.TreeNode(1)
    root.left = LeetCode_606.TreeNode(2)
    root.right = LeetCode_606.TreeNode(3)
    root.left!!.left = LeetCode_606.TreeNode(4)
    println(LeetCode_606().tree2str(root))
}
