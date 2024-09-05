package array

class LeetCode_2028 {

    fun missingRolls(rolls: IntArray, mean: Int, n: Int): IntArray {
        val totalValue = mean * (n + rolls.size)
        val rollSum = rolls.sum()

        val missingSum = totalValue - rollSum

        if (missingSum !in n .. n * 6) {
            return IntArray(0)
        }

        val eachRoll = missingSum / n
        var leftRoll = missingSum % n

        val missingRolls = IntArray(n)

        var i = 0

        while (i < n) {
            missingRolls[i] = eachRoll

            if (leftRoll > 0) {
                missingRolls[i]++
                leftRoll--
            }

            i++
        }

        return missingRolls
    }
}

fun main() {
    // Input
    val rolls = intArrayOf(3, 2, 4, 3)
    val mean = 4
    val n = 2
    // Output
    LeetCode_2028().missingRolls(rolls, mean, n).run {
        println(this.joinToString())
        require(
            intArrayOf(6, 6).contentEquals(this)
        )
    }
}
