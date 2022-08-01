package graph

class LeetCode_1971 {

    /**
     * Solution - DFS
     * Time Complexity : O(V + E)
     * Space Complexity : O(V)
     *
     * Search graph with DFS.
     * Initialize the graph on the map for depth-first search.
     * Explore all non-visited vertices and return true when you arrive at your destination.
     *
     * @param n vertices of graph
     * @param edges 2D integer array which represented edges in the graph
     * @param source the starting vertex
     * @param destination the destination vertex
     * @return Is a valid path that exists from vertex source to vertex destination
     */
    fun validPath(n: Int, edges: Array<IntArray>, source: Int, destination: Int): Boolean {
        if (source == destination) {
            return true
        }

        val graphMap: MutableMap<Int, MutableList<Int>> = mutableMapOf()
        val visited = BooleanArray(n)

        for (i in 0 until n) {
            graphMap[i] = mutableListOf()
        }

        for (edge in edges) {
            graphMap[edge[0]]?.add(edge[1])
            graphMap[edge[1]]?.add(edge[0])
        }

        dfs(graphMap, visited, source, destination)
        return result
    }

    var result = false

    private fun dfs(graphMap: Map<Int, List<Int>>, visited: BooleanArray, source: Int, destination: Int) {
        if (visited[source] || result) {
            return
        }

        visited[source] = true

        for (i in graphMap[source]!!) {
            if (i == destination) {
                result = true
                break
            }
            if (!visited[i]) {
                dfs(graphMap, visited, i, destination)
            }
        }
    }
}

fun main() {
    val n = 3
    val edges = arrayOf(intArrayOf(0, 1), intArrayOf(1, 2), intArrayOf(2, 0))
    val source = 0
    val destination = 2
    println(LeetCode_1971().validPath(n, edges, source, destination))
}
