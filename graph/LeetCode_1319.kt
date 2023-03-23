package graph

class LeetCode_1319 {

    fun makeConnected(n: Int, connections: Array<IntArray>): Int {
        if (connections.size < n - 1) {
            return -1
        }

        val parents = IntArray(n)

        repeat(n) {
            parents[it] = it
        }

        var unConnectedNodes = n

        for (connection in connections) {
            val firstParent = find(parents, connection[0])
            val secondParent = find(parents, connection[1])

            if (firstParent != secondParent) {
                parents[firstParent] = secondParent
                unConnectedNodes--
            }
        }

        return unConnectedNodes - 1
    }

    private fun find(parent: IntArray, index: Int): Int {
        return if (parent[index] == index) {
            index
        } else {
            parent[index] = find(parent, parent[index])
            parent[index]
        }
    }

}

fun main() {
    // Input
    val n = 4
    val connections = arrayOf(
        intArrayOf(0, 1),
        intArrayOf(0, 2),
        intArrayOf(1, 2),
    )
    // Output
    LeetCode_1319().makeConnected(n, connections).let {
        println(it)
        require(it == 1)
    }
}
