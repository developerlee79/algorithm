package dp

import kotlin.math.min

class LeetCode_746 {

    /**
     * Solution - Dynamic Programming
     * Time Complexity : O(N)
     * Space Complexity : O(1)
     *
     * Use greedily dynamic programming to solve the problem.
     * Say f[i] is the final cost to climb to the top from step i. Then f[i] = cost[i] + min(f[i+1], f[i+2]).
     *
     * @param cost cost of ith step on a staircase
     * @return minimum cost to reach the top of the floor.
     */
    fun minCostClimbingStairs(cost: IntArray): Int {
        for (i in 2 until cost.size) {
            cost[i] += min(cost[i - 1], cost[i - 2])
        }
        return min(cost[cost.size - 1], cost[cost.size - 2])
    }
}

fun main() {
    val cost = intArrayOf(10, 15, 20)
    println(LeetCode_746().minCostClimbingStairs(cost))
}
