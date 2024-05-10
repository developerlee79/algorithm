package array

class LeetCode_786 {

    fun kthSmallestPrimeFraction(arr: IntArray, k: Int): IntArray {
        val n = arr.size

        val fractions = mutableListOf<Pair<Int, Int>>()

        for (i in arr.indices) {
            for (j in i + 1 until n) {
                fractions.add(Pair(arr[i], arr[j]))
            }
        }

        fractions.sortBy { it.first.toDouble() / it.second }

        return intArrayOf(fractions[k - 1].first, fractions[k - 1].second)
    }
}

fun main() {
    // Input
    val arr = intArrayOf(1, 2, 3, 5)
    val k = 3
    // Output
    LeetCode_786().kthSmallestPrimeFraction(arr, k).run {
        println(this.joinToString())
        require(
            intArrayOf(2, 5).contentEquals(this)
        )
    }
}
