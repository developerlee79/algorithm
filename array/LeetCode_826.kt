package array

class LeetCode_826 {

    fun maxProfitAssignment(difficulty: IntArray, profit: IntArray, worker: IntArray): Int {
        val n = difficulty.size

        val jobList = mutableListOf<Pair<Int, Int>>()

        for (i in difficulty.indices) {
            jobList.add(Pair(difficulty[i], profit[i]))
        }

        jobList.sortBy { it.first }

        var totalProfit = 0

        worker.forEach { ability ->
            var i = 0
            var maxProfit = 0

            while (i < n && ability >= jobList[i].first) {
                maxProfit = maxOf(maxProfit, jobList[i].second)
                i++
            }

            totalProfit += maxProfit
        }

        return totalProfit
    }
}

fun main() {
    // Input
    val difficulty = intArrayOf(2, 4, 6, 8, 10)
    val profit = intArrayOf(10, 20, 30, 40, 50)
    val worker = intArrayOf(4, 5, 6, 7)
    // Output
    LeetCode_826().maxProfitAssignment(difficulty, profit, worker).run {
        println(this)
        require(100 == this)
    }
}
