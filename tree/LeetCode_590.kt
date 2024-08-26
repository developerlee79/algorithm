package tree

class LeetCode_590 {

    class Node(var `val`: Int) {
        var children: List<Node?> = listOf()
    }

    fun postorder(root: Node?): List<Int> {
        val traversalList = mutableListOf<Int>()
        traversal(root, traversalList)
        return traversalList
    }

    private fun traversal(node: Node?, traversalList: MutableList<Int>) {
        if (node == null) {
            return
        }

        node.children.forEach {
            traversal(it, traversalList)
        }

        traversalList.add(node.`val`)
    }
}

fun main() {
    // Input
    val root = LeetCode_590.Node(1)

    val childNode = LeetCode_590.Node(3)
    childNode.children = listOf(LeetCode_590.Node(5), LeetCode_590.Node(6))

    root.children = listOf(childNode, LeetCode_590.Node(2), LeetCode_590.Node(4))
    // Output
    LeetCode_590().postorder(root).run {
        println(this)
        require(
            listOf(5, 6, 3, 2, 4, 1) == this
        )
    }
}
