package bit_manipulation

class LeetCode_2220 {

    fun minBitFlips(start: Int, goal: Int): Int {
        var start = start
        var goal = goal

        var flipCount = 0

        while (start > 0 || goal > 0) {
            if (hasDifferentLastBit(start, goal)) {
                flipCount++
            }

            start = start.shr(1)
            goal = goal.shr(1)
        }

        return flipCount
    }

    private fun hasDifferentLastBit(a: Int, b: Int) = a.and(1) != b.and(1)
}

fun main() {
    // Input
    val start = 10
    val goal = 7
    // Output
    LeetCode_2220().minBitFlips(start, goal).run {
        println(this)
        require(3 == this)
    }
}
