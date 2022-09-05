package tree

class LeetCode_429 {

    class Node(var `val`: Int) {
        var children: List<Node?> = listOf()
    }

    /**
     * Solution - BFS
     * Time Complexity : O(V + E)
     * Space Complexity : O(N)
     *
     * @param root n-ary tree
     * @return return the level order traversal of its nodes' values
     */
    fun levelOrder(root: Node?): List<List<Int>> {
        val resultList = mutableListOf<List<Int>>()

        if (root == null) {
            return resultList
        }

        val nodeQueue = ArrayDeque<Node>()
        nodeQueue.add(root)

        while (nodeQueue.isNotEmpty()) {
            val currentSize = nodeQueue.size
            val currentList = mutableListOf<Int>()

            for (i in 0 until currentSize) {
                val currentNode = nodeQueue.removeFirst()
                currentList.add(currentNode.`val`)

                for (node in currentNode.children) {
                    nodeQueue.addLast(node!!)
                }
            }

            resultList.add(currentList)
        }

        return resultList
    }
}

fun main() {
    val root = LeetCode_429.Node(1)

    val leftNode = LeetCode_429.Node(3)
    root.children = listOf(
        leftNode,
        LeetCode_429.Node(2),
        LeetCode_429.Node(4)
    )

    leftNode.children = listOf(
        LeetCode_429.Node(5),
        LeetCode_429.Node(6)
    )

    println(LeetCode_429().levelOrder(root))
}
