package graph

class LeetCode_851 {

    /**
     * Solution - Depth-First Search
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     *
     * Search richer and quietest node with Depth-First Search.
     * First, initialize the unidirectional graph on map for search.
     * And start depth-first search from every start node in graph.
     * Because this is a one-way graph problem, there's no node is more rich or quieter than a terminal node.
     * Therefore, the value of the end node becomes itself.
     * Because the value of the parent recursive node is equal the value of the quietest of the child nodes, the parent node can find the quietest node (the result value) with the value of the child nodes.
     * That is, every child nodes is richer & quieter than parent nodes.
     * Therefore, we can reduce time complexity by using the Memorization.
     * If you have visited that node and found the values, the next time you visit that node you can find the smallest value of that node graph immediately.
     * Therefore, even in the worst-case scenario (searching for all nodes), you will always have a time complexity of O(N).
     * Searching all starting nodes to complete the resulting array.
     *
     * @param richer the array [a, b]  which indicates that a has more than money than b
     * @param quiet integer array which presents the quietness of the persons
     * @return integer array which richer and quietest person when start from i (index)
     */
    fun loudAndRich(richer: Array<IntArray>, quiet: IntArray): IntArray {
        val graphMap: Map<Int, List<Int>> = setGraph(richer, quiet.size)
        val resultArray = IntArray(quiet.size)
        val visited = BooleanArray(quiet.size)

        for (i in graphMap.keys) {
            dfs(i, graphMap, quiet, resultArray, visited)
        }

        return resultArray
    }

    private fun dfs(index: Int, graphMap: Map<Int, List<Int>>, quiet: IntArray, resultArray: IntArray, visited: BooleanArray): Int {
        if (visited[index]) {
            return resultArray[index]
        }

        visited[index] = true

        if (graphMap[index] == null) {
            resultArray[index] = index
            resultArray[index]
        }

        var minIndex = index
        for (i in graphMap[index]!!) {
            val depthIndex = dfs(i, graphMap, quiet, resultArray, visited)
            if (quiet[minIndex] > quiet[depthIndex]) {
                minIndex = depthIndex
            }
        }

        resultArray[index] = minIndex
        return resultArray[index]
    }

    private fun setGraph(graphArray: Array<IntArray>, n: Int): Map<Int, List<Int>> {
        val graphMap: MutableMap<Int, MutableList<Int>> = mutableMapOf()

        for (i in 0 until n) {
            graphMap[i] = mutableListOf()
        }

        for (edge in graphArray) {
            graphMap[edge[1]]?.add(edge[0])
        }

        return graphMap
    }
}

fun main() {
    val richer = arrayOf(
        intArrayOf(1, 0),
        intArrayOf(2, 1),
        intArrayOf(3, 1),
        intArrayOf(3, 7),
        intArrayOf(4, 3),
        intArrayOf(5, 3),
        intArrayOf(6, 3)
    )
    val quiet = intArrayOf(3, 2, 5, 4, 6, 1, 7, 0)
    println(LeetCode_851().loudAndRich(richer, quiet).joinToString())
}
