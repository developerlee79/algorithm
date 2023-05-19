package graph

import java.util.LinkedList
import java.util.Queue

class LeetCode_785 {

    fun isBipartite(graph: Array<IntArray>): Boolean {
        val nodeQueue: Queue<Int> = LinkedList()

        val visited = IntArray(graph.size)

        for (i in graph.indices) {
            if (visited[i] != 0) {
                continue
            }

            nodeQueue.add(i)
            visited[i] = 1

            while (nodeQueue.isNotEmpty()) {
                val currentNode = nodeQueue.poll()

                graph[currentNode].forEach {
                    if (visited[it] == 0) {
                        visited[it] = -visited[currentNode]
                        nodeQueue.add(it)
                    } else if (visited[it] != -visited[currentNode]) {
                        return false
                    }
                }
            }
        }

        return true
    }
}

fun main() {
    // Input
    val graph = arrayOf(
        intArrayOf(1, 2, 3),
        intArrayOf(0, 2),
        intArrayOf(0, 1, 3),
        intArrayOf(0, 2),
    )
    // Output
    LeetCode_785().isBipartite(graph).run {
        println(this)
        require(!this)
    }
}
