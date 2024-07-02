package array

class LeetCode_1550 {

    private fun Int.isOdd() = this % 2 != 0

    fun threeConsecutiveOdds(arr: IntArray): Boolean {
        val n = arr.size

        if (n < 3) {
            return false
        }

        var i = 2

        while (i < n) {
            if (arr[i].isOdd() && arr[i - 1].isOdd() && arr[i - 2].isOdd()) {
                return true
            }

            i++
        }

        return false
    }
}

fun main() {
    // Input
    val arr = intArrayOf(2, 6, 4, 1)
    // Output
    LeetCode_1550().threeConsecutiveOdds(arr).run {
        println(this)
        require(!this)
    }
}
