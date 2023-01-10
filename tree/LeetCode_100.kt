package tree

import util.TreeNode

class LeetCode_100 {

    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean =
        if (p == null && q == null)
            true
        else if (p == null || q == null)
            false
        else if (p.`val` == q.`val`)
            isSameTree(p.left, q.left) and isSameTree(p.right, q.right)
        else
            false
}

fun main() {
    // Input
    val p = TreeNode.of(1, 2, 3)
    val q = TreeNode.of(1, 2, 3)
    // Output
    LeetCode_100().isSameTree(p, q).let {
        println(it)
        require(it)
    }
}
