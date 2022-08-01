package backtracking

class LeetCode_473 {

    /**
     * Solution - DFS
     * Time Complexity : O(V)
     * Space Complexity : O(N)
     *
     * Solve the problem with backtracking.
     * Explore all cases using the top-down recursive backtracking method.
     * Explore all cases using the top-down recursive backtracking method.
     * If the height of the current side plus a match is less than or equal to the length, the side is likely valid.
     * Recursively, find all sides, and check that all values are valid.
     * At the end of the recursive process, remove it because it is already used or incorrect and you no longer need to use it.
     *
     * @param matchsticks integer array presents length of each matchstick
     * @return is possible to make this square with matches
    */
    fun makesquare(matchsticks: IntArray): Boolean {
        if (matchsticks.size < 4)
            return false

        val sum = matchsticks.sum()

        if (sum % 4 != 0)
            return false

        return recursive(matchsticks, IntArray(4), matchsticks.size - 1, sum / 4)
    }

    private fun recursive(matchsticks: IntArray, square: IntArray, index: Int, length: Int): Boolean {
        if (index < 0)
            return (square[0] == length && square[1] == length && square[2] == length)

        for (i in square.indices) {
            if (square[i] + matchsticks[index] > length)
                continue

            square[i] += matchsticks[index]

            if (recursive(matchsticks, square, index - 1, length))
                return true

            square[i] -= matchsticks[index]
        }

        return false
    }
}

fun main() {
    val matchsticks = intArrayOf(1, 1, 2, 2, 2)
    println(LeetCode_473().makesquare(matchsticks))
}
