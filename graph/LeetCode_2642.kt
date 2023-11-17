package graph

import java.util.*

class LeetCode_2642 {

    class Graph(
        val n: Int,
        edges: Array<IntArray>
    ) {

        private val graphMap: Array<MutableList<Pair<Int, Int>>> = Array(n) { mutableListOf() }

        init {
            edges.forEach {
                graphMap[it[0]].add(Pair(it[1], it[2]))
            }
        }

        fun addEdge(edge: IntArray) {
            graphMap[edge[0]].add(Pair(edge[1], edge[2]))
        }

        fun shortestPath(node1: Int, node2: Int): Int {
            val n = graphMap.size

            val priorityQueue = PriorityQueue<Pair<Int, Int>>(Comparator.comparingInt { pair -> pair.first })
            priorityQueue.offer(Pair(0, node1))

            val distances = IntArray(n) { Int.MAX_VALUE }
            distances[node1] = 0

            while (priorityQueue.isNotEmpty()) {
                val pair = priorityQueue.poll()

                val currentDistance = pair.first
                val currentNode = pair.second

                if (currentNode == node2) {
                    return currentDistance
                }

                for (neighbor in graphMap[currentNode]) {
                    val neighborDistance = currentDistance + neighbor.second

                    if (neighborDistance < distances[neighbor.first]) {
                        distances[neighbor.first] = neighborDistance
                        priorityQueue.add(Pair(neighborDistance, neighbor.first))
                    }
                }
            }

            return -1
        }

    }

}

fun main() {
    // Input
    val graph = LeetCode_2642.Graph(
        n = 4,
        edges = arrayOf(
            intArrayOf(0, 2, 5),
            intArrayOf(0, 1, 2),
            intArrayOf(1, 2, 1),
            intArrayOf(3, 0, 3)
        )
    )
    // Output
    require(6 == graph.shortestPath(3, 2))
    require(-1 == graph.shortestPath(0, 3))
    graph.addEdge(intArrayOf(1, 3, 4))
    require(6 == graph.shortestPath(0, 3))
}
