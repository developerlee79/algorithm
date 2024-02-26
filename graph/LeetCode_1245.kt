package graph

class LeetCode_1245 {

    private var diameter = 0

    fun treeDiameter(edges: Array<IntArray>): Int {
        val edgeMap = HashMap<Int, MutableList<Int>>()

        edges.forEach { edge ->
            edgeMap.computeIfAbsent(edge[0]) { mutableListOf() }.add(edge[1])
            edgeMap.computeIfAbsent(edge[1]) { mutableListOf() }.add(edge[0])
        }

        findDiameter(0, -1, edgeMap)

        return diameter
    }

    private fun findDiameter(rootNode: Int, lastNode: Int, edgeMap: HashMap<Int, MutableList<Int>>): Int {
        var longestPath = 0
        var secondLongestPath = 0

        edgeMap[rootNode]?.forEach { nextNode ->
            if (nextNode == lastNode) {
                return@forEach
            }

            val currentPath = findDiameter(nextNode, rootNode, edgeMap)

            if (currentPath > longestPath) {
                secondLongestPath = longestPath
                longestPath = currentPath
            } else if (currentPath > secondLongestPath) {
                secondLongestPath = currentPath
            }
        }

        diameter = maxOf(diameter, longestPath + secondLongestPath)

        return longestPath + 1
    }
}

fun main() {
    // Input
    val edges = arrayOf(
        intArrayOf(0, 1),
        intArrayOf(0, 2)
    )
    // Output
    LeetCode_1245().treeDiameter(edges).run {
        println(this)
        require(2 == this)
    }
}
