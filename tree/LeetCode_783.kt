package tree

class LeetCode_783 {

    fun minDiffInBST(root: TreeNode?): Int {
        val nodeList = mutableListOf<Int>()
        constructNodeList(root, nodeList)
        nodeList.sort()

        var minDifference = 100000
        val n = nodeList.size

        for (i in 0 until n - 1) {
            minDifference = minOf(minDifference, nodeList[i + 1] - nodeList[i])
        }

        return minDifference
    }

    private fun constructNodeList(root: TreeNode?, nodeList: MutableList<Int>) {
        if (root == null) {
            return
        }

        nodeList.add(root.`val`)

        constructNodeList(root.left, nodeList)
        constructNodeList(root.right, nodeList)
    }
}
