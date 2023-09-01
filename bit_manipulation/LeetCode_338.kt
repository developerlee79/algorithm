package bit_manipulation

class LeetCode_338 {

    fun countBits(n: Int): IntArray {
        val arr = IntArray(n + 1)

        for (i in 0..n) {
            arr[i] = countBitsRecursive(i)
        }

        return arr
    }

    private fun countBitsRecursive(n: Int): Int {
        if (n <= 1) {
            return n
        }

        return countBitsRecursive(n / 2) + if (n % 2 != 0) 1 else 0
    }
}

fun main() {
    // Input
    val n = 2
    // Output
    LeetCode_338().countBits(n).run {
        println(this.joinToString())
        require(
            intArrayOf(0, 1, 1).contentEquals(this)
        )
    }
}
