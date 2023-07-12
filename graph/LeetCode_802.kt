package graph

class LeetCode_802 {

    fun eventualSafeNodes(graph: Array<IntArray>): List<Int> {
        val n = graph.size

        val dp = IntArray(n)

        val safeNodes = mutableListOf<Int>()

        for (i in 0 until n) {
            if (search(graph, dp, i)) {
                safeNodes.add(i)
            }
        }

        return safeNodes
    }

    private fun search(graph: Array<IntArray>, dp: IntArray, index: Int): Boolean {
        if (dp[index] != 0) {
            return dp[index] == 1
        }

        dp[index] = 2

        for (i in graph[index]) {
            if (!search(graph, dp, i)) {
                return false
            }
        }

        dp[index] = 1

        return true
    }
}

fun main() {
    // Input
    val graph = arrayOf(
        intArrayOf(1, 2),
        intArrayOf(2, 3),
        intArrayOf(5),
        intArrayOf(0),
        intArrayOf(5),
        intArrayOf(),
        intArrayOf(),
    )
    // Output
    LeetCode_802().eventualSafeNodes(graph).run {
        println(this)
        require(this == listOf(2, 4, 5, 6))
    }
}
