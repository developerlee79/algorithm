package graph

class LeetCode_1557 {

    fun findSmallestSetOfVertices(n: Int, edges: List<List<Int>>): List<Int> {
        val referenceVertexSet = HashSet<Int>(n)
        val connectedVertexSet = HashSet<Int>(n)

        edges.forEach {
            referenceVertexSet.add(it[0])
            connectedVertexSet.add(it[1])
        }

        val resultList = mutableListOf<Int>()

        repeat(n) {
            if (referenceVertexSet.contains(it) && !connectedVertexSet.contains(it)) {
                resultList.add(it)
            }
        }

        return resultList
    }
}

fun main() {
    // Input
    val n = 6
    val edges = listOf(
        listOf(0, 1),
        listOf(0, 2),
        listOf(2, 5),
        listOf(3, 4),
        listOf(4, 2),
    )
    // Output
    LeetCode_1557().findSmallestSetOfVertices(n, edges).run {
        println(this)
        require(this == listOf(0, 3))
    }
}
