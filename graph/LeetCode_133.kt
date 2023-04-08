package graph

class LeetCode_133 {

    data class Node(
        var `val`: Int
    ) {
        var neighbors: ArrayList<Node?> = ArrayList()

        fun addNeighbors(vararg neighborNodes: Node) {
            neighborNodes.forEach {
                neighbors.add(it)
            }
        }
    }

    fun cloneGraph(node: Node?): Node? {
        if (node == null) {
            return null
        }

        if (node.neighbors.isEmpty()) {
            return Node(node.`val`)
        }

        val nodeMap = hashMapOf<Int, Node>()

        search(node, nodeMap)

        return nodeMap[1]
    }

    private fun search(node: Node?, nodeMap: HashMap<Int, Node>) {
        if (node == null) {
            return
        }

        if (!nodeMap.containsKey(node.`val`)) {
            nodeMap[node.`val`] = Node(node.`val`)
        }

        node.neighbors.forEach {
            if (it == null) {
                return@forEach
            }

            if (!nodeMap.containsKey(it.`val`)) {
                nodeMap[it.`val`] = Node(it.`val`)
                search(it, nodeMap)
            }

            nodeMap[node.`val`]!!.neighbors.add(nodeMap[it.`val`])
        }
    }
}

fun main() {
    // Input
    val node1 = LeetCode_133.Node(1)
    val node2 = LeetCode_133.Node(2)
    val node3 = LeetCode_133.Node(3)
    val node4 = LeetCode_133.Node(4)

    node1.addNeighbors(node2, node4)
    node2.addNeighbors(node1, node3)
    node3.addNeighbors(node2, node4)
    node4.addNeighbors(node1, node3)
    // Output
    println(LeetCode_133().cloneGraph(node1))
}
