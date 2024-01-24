package tree

class LeetCode_889 {

    private var preIndex = 0
    private var postIndex = 0

    fun constructFromPrePost(preorder: IntArray, postorder: IntArray): TreeNode {
        val root = TreeNode(preorder[preIndex++])

        if (postorder[postIndex] != root.`val`) {
            root.left = constructFromPrePost(preorder, postorder)
        }

        if (postorder[postIndex] != root.`val`) {
            root.right = constructFromPrePost(preorder, postorder)
        }

        postIndex++

        return root
    }
}
