package graph

class LeetCode_947 {

    /**
     * Solution : Union Find
     * Time Complexity : O(NlogN)
     * Space Complexity : O(N)
     *
     * @param stones array stones of length n where stones[i] = [xi, yi] represents the location of the ith stone (coordinate point)
     * @return return the largest possible number of stones that can be removed
    */
    fun removeStones(stones: Array<IntArray>): Int {
        val unionFind = UnionFind(stones.size)
        var count = stones.size

        for (i in stones.indices) {
            for (j in i + 1 until stones.size) {
                val stone1 = stones[i]
                val stone2 = stones[j]

                if (stone1.first() == stone2.first() || stone1.last() == stone2.last()) {
                    if (unionFind.union(i, j)) {
                        count--
                    }
                }
            }
        }

        return stones.size - count
    }

    private class UnionFind(
        size: Int
    ) {
        private val parent = IntArray(size)
        private val rank = IntArray(size)

        init {
            repeat(size) {
                parent[it] = it
            }
        }

        fun union(node1: Int, node2: Int): Boolean {
            val parent1 = find(node1)
            val parent2 = find(node2)

            if (parent1 == parent2) {
                return false
            }

            if (rank[parent1] > rank[parent2]) {
                parent[parent2] = parent1
            } else if (rank[parent1] < rank[parent2]) {
                parent[parent1] = parent2
            } else {
                parent[parent2] = parent1
                rank[parent1]++
            }

            return true
        }

        private fun find(node: Int): Int {
            if (parent[node] != node) {
                parent[node] = find(parent[node])
            }
            return parent[node]
        }
    }
}

fun main() {
    // Input
    val stones = arrayOf(
        intArrayOf(0, 0),
        intArrayOf(0, 1),
        intArrayOf(1, 0),
        intArrayOf(1, 2),
        intArrayOf(2, 1),
        intArrayOf(2, 2),
    )
    // Output
    val output = LeetCode_947().removeStones(stones)
    println(output)
    require(output == 5)
}
