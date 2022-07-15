package math

class LeetCode_2240 {

    /**
     * Solution - Iteration
     * Time Complexity : O(N)
     * Space Complexity : O(1)
     *
     * It's an easy problem.
     * We just have to buy N pens and get how many pencils we can buy for the remaining price.
     *
     * @param total indicating the amount of money you have
     * @param cost1 price of a pen
     * @param cost2 price of a pencil
     * @return number of distinct ways you can buy some number of pens and pencils
    */
    fun waysToBuyPensPencils(total: Int, cost1: Int, cost2: Int): Long {
        var count = 0L
        for (i in 0 .. total / cost1) {
            count += (total - cost1 * i) / cost2 + 1
        }
        return count
    }
}

fun main() {
    val total = 20
    val cost1 = 10
    val cost2 = 5
    println(LeetCode_2240().waysToBuyPensPencils(total, cost1, cost2))
}
