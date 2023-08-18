package graph

class LeetCode_1615 {

    fun maximalNetworkRank(n: Int, roads: Array<IntArray>): Int {
        val networkArray = Array<HashSet<IntArray>>(n) { hashSetOf() }

        roads.forEach { road ->
            networkArray[road[0]].add(road)
            networkArray[road[1]].add(road)
        }

        var maxRank = 0

        for (i in 0 until n - 1) {
            for (j in i until n) {
                maxRank = maxOf(maxRank, (networkArray[i] + networkArray[j]).size)
            }
        }

        return maxRank
    }
}

fun main() {
    // Input
    val n = 4
    val roads = arrayOf(
        intArrayOf(0, 1),
        intArrayOf(0, 3),
        intArrayOf(1, 2),
        intArrayOf(1, 3),
    )
    // Output
    LeetCode_1615().maximalNetworkRank(n, roads).run {
        println(this)
        require(4 == this)
    }
}
