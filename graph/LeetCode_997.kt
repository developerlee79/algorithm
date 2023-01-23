package graph

class LeetCode_997 {

    fun findJudge(n: Int, trust: Array<IntArray>): Int {
        val count = IntArray(n + 1)

        for (trus in trust) {
            count[trus[0]]--
            count[trus[1]]++
        }

        for (i in 1 .. n) {
            if (count[i] == n - 1) {
                return i
            }
        }

        return -1
    }
}

fun main() {
    // Input
    val n = 2
    val trust = arrayOf(
        intArrayOf(1, 2)
    )
    // Output
    LeetCode_997().findJudge(n, trust).let {
        println(it)
        require(it == 2)
    }
}
