package graph

class LeetCode_834 {

    fun sumOfDistancesInTree(n: Int, edges: Array<IntArray>): IntArray {
        if (n == 1) {
            return intArrayOf(0)
        }

        val nodeMapArray = Array<HashMap<Int, Pair<Int, Int>?>>(n) { hashMapOf() }

        edges.forEach { edge ->
            nodeMapArray[edge.first()][edge.last()] = null
            nodeMapArray[edge.last()][edge.first()] = null
        }

        val sumOfDistances = IntArray(n)

        nodeMapArray.forEachIndexed { index, _ ->
            sumOfDistances[index] = recursive(index, nodeMapArray, BooleanArray(n)).let { it.second - it.first }
        }

        return sumOfDistances
    }

    private fun recursive(index: Int, nodeMapArray: Array<HashMap<Int, Pair<Int, Int>?>>, visited: BooleanArray): Pair<Int, Int> {
        if (nodeMapArray[index].size == 1 && visited[nodeMapArray[index].keys.first()]) {
            return Pair(1, 1)
        }

        visited[index] = true

        var numberOfNodes = 0
        var sumOfNodes = 0

        nodeMapArray[index].let { nodeMap ->
            nodeMap.keys.forEach { key ->
                if (visited[key]) {
                    return@forEach
                }

                if (nodeMap[key] != null) {
                    numberOfNodes += nodeMap[key]!!.first
                    sumOfNodes += nodeMap[key]!!.second
                    return@forEach
                }

                recursive(key, nodeMapArray, visited).let {
                    numberOfNodes += it.first
                    sumOfNodes += it.second
                    nodeMap[key] = it
                }
            }
        }

        numberOfNodes++

        return Pair(numberOfNodes, sumOfNodes + numberOfNodes)
    }
}

fun main() {
    // Input
    val n = 6
    val edges = arrayOf(
        intArrayOf(0, 1),
        intArrayOf(0, 2),
        intArrayOf(2, 3),
        intArrayOf(2, 4),
        intArrayOf(2, 5),
    )
    // Output
    LeetCode_834().sumOfDistancesInTree(n, edges).let {
        println(it.joinToString())
        require(
            intArrayOf(8, 12, 6, 10, 10, 10).contentEquals(it)
        )
    }
}
