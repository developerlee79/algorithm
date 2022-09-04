package tree

class LeetCode_987 {

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    /**
     * Solution - Map + DFS
     * Time Complexity : O(NlogN)
     * Space Complexity : O(N)
     *
     * @param root root of a binary tree
     * @return vertical order traversal of the binary tree
    */
    fun verticalTraversal(root: TreeNode?): List<List<Int>> {
        val treeMap = hashMapOf<Int, MutableList<Pair<Int, Int>>>()
        search(root, 0, 0, treeMap)

        val resultList = mutableListOf<List<Int>>()

        for (key in treeMap.keys.sorted()) {
            treeMap[key]!!.sortWith(compareBy({it.first}, {it.second}))

            val result = mutableListOf<Int>()
            for (value in treeMap[key]!!) {
                result.add(value.second)
            }
            resultList.add(result)
        }

        return resultList
    }

    private fun search(root: TreeNode?, location: Int, depth: Int, treeMap: HashMap<Int, MutableList<Pair<Int, Int>>>) {
        if (root == null) {
            return
        }

        treeMap.computeIfAbsent(location) { mutableListOf() } .add(Pair(depth, root.`val`))

        search(root.left, location - 1, depth + 1, treeMap)
        search(root.right, location + 1, depth + 1, treeMap)
    }
}

fun main() {
    val root = LeetCode_987.TreeNode(3)
    root.left = LeetCode_987.TreeNode(9)
    root.right = LeetCode_987.TreeNode(20)
    root.right!!.left = LeetCode_987.TreeNode(15)
    root.right!!.right = LeetCode_987.TreeNode(7)
    println(LeetCode_987().verticalTraversal(root))
}
