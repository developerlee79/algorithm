package graph

class LeetCode_797 {

    /**
     * Solution - Backtracking
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     *
     * Classic backtracking problem.
     * Navigate all connected nodes of the current node with depth-first search, and if you have reached your destination, add the current path list to the result list.
     * At the end of the recursive navigation, remove the nodes added in the path list to allow you to explore other possibilities in a backtracking method.
     *
     * @param graph directed acyclic graph of n nodes
     * @return all possible paths from node 0 to node n - 1 and return them in any order
    */
    fun allPathsSourceTarget(graph: Array<IntArray>): List<List<Int>> {
        val resultList = mutableListOf<List<Int>>()
        dfs(graph, resultList, mutableListOf(), 0)
        return resultList
    }

    private fun dfs(graph: Array<IntArray>, resultList: MutableList<List<Int>>, pathList: MutableList<Int>, currentNode: Int) {
        if (currentNode == graph.size - 1) {
            pathList.add(currentNode)
            resultList.add(pathList.toList())
            return
        }

        pathList.add(currentNode)

        for (path in graph[currentNode]) {
            dfs(graph, resultList, pathList, path)
            pathList.remove(path)
        }
    }
}

fun main() {
    val graph = arrayOf(
        intArrayOf(4, 3, 1),
        intArrayOf(3, 2, 4),
        intArrayOf(3),
        intArrayOf(4),
        intArrayOf()
    )
    println(LeetCode_797().allPathsSourceTarget(graph))
}
