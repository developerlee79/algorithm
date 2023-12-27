package dp

class LeetCode_1578 {

    fun minCost(colors: String, neededTime: IntArray): Int {
        var cost = 0
        var remainCost = neededTime[0]

        for (i in 1 until colors.length) {
            if (colors[i - 1] != colors[i]) {
                remainCost = neededTime[i]
                continue
            }

            cost += minOf(remainCost, neededTime[i])
            remainCost = maxOf(remainCost, neededTime[i])
        }

        return cost
    }
}

fun main() {
    // Input
    val colors = "abaac"
    val neededTime = intArrayOf(1, 2, 3, 4, 5)
    // Output
    LeetCode_1578().minCost(colors, neededTime).run {
        println(this)
        require(3 == this)
    }
}
