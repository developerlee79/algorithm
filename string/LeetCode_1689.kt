package string

class LeetCode_1689 {

    /**
     * Solution - Math
     * Time Complexity : O(N)
     * Space Complexity : O(1)
     *
     * The biggest number we can use is 1.
     * Therefore, the largest number in the string is the answer to the problem.
     * Because for example, if you were to say 125, you would have to use at least five 1s to make 5.
     *
     * @param n target integer
     * @return minimum number of positive *deci-binary numbers needed so that they sum up to n
     *     *deci-binary : decimal number which digits it either 0 or 1 without any leading zeros
    */
    fun minPartitions(n: String): Int {
        return n.toCharArray().maxOfOrNull { it.digitToInt() } ?: 0
    }
}

fun main() {
    val n = "32"
    println(LeetCode_1689().minPartitions(n))
}
