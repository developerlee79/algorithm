package array

class LeetCode_1502 {

    fun canMakeArithmeticProgression(arr: IntArray): Boolean {
        arr.sort()

        val difference = arr[0] - arr[1]

        for (i in 2 until arr.size) {
            if (arr[i - 1] - arr[i] != difference) {
                return false
            }
        }

        return true
    }
}

fun main() {
    // Input
    val arr = intArrayOf(3, 5, 1)
    // Output
    LeetCode_1502().canMakeArithmeticProgression(arr).run {
        println(this)
        require(this)
    }
}
