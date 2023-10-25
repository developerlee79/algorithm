package bit_manipulation

import kotlin.math.ceil

class LeetCode_779 {

    /**
     * Solution - Recursion
     * Time Complexity : O(N)
     * Space Complexity : O(1)
     *
     * 1. Return value is either 0 or 1.
     * 2. Up to the nth row, the numbers in each row are broken down to 0:0/1, 1:1/0, depending on the rule
     * The parent value of the kth index of the nth row of the index tree decomposed according to 3.1 is the k/2 index of the parent row if k is even, and the (k + 1) / 2nd index of the parent row if k is odd.
     * We can find the value in the Bottom-Up method with this rule.
     * Start at the kth index in the nth row, and we reduce the value depending on whether k is even or odd, and we recurs to the ceiling of the tree.
     *
     * @param n number of rows
     * @param k index
     * @return kth (1-indexed) symbol in the nth row of a table of n rows
    */
    fun kthGrammar(n: Int, k: Int): Int {
        if (n == 1) {
            return 0
        }

        val parent = kthGrammar(n - 1, ceil(k / 2.0).toInt())
        val isOdd = k % 2 == 1

        return if (parent == 0)
            if (isOdd) 0 else 1
        else
            if (isOdd) 1 else 0
    }
}

fun main() {
    // Input
    val n = 1
    val k = 1
    // Output
    LeetCode_779().kthGrammar(n, k).run {
        println(this)
        require(0 == this)
    }
}
