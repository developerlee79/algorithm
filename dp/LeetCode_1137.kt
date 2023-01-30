package dp

class LeetCode_1137 {

    fun tribonacci(n: Int): Int {
        if (n < 2) {
            return n
        }

        val numQueue = intArrayOf(0, 0, 1)

        var lastN = 1
        var pointer = 0

        repeat(n - 2) {
            val pointedValue = numQueue[pointer]
            numQueue[pointer] = lastN
            lastN = lastN * 2 - pointedValue
            pointer = if (pointer + 1 in numQueue.indices) pointer + 1 else 0
        }

        return lastN
    }
}

fun main() {
    // Input
    val n = 4
    // Output
    LeetCode_1137().tribonacci(n).let {
        println(it)
        require(it == 4)
    }
}
