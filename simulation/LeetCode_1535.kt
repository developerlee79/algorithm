package simulation

class LeetCode_1535 {

    fun getWinner(arr: IntArray, k: Int): Int {
        var currentNumber = arr[0]

        var largerOne = 0

        for (i in 1 until arr.size) {
            if (arr[i] > currentNumber) {
                currentNumber = arr[i]
                largerOne = 0
            }

            largerOne++

            if (largerOne == k) {
                break
            }
        }

        return currentNumber
    }
}

fun main() {
    // Input
    val arr = intArrayOf(2, 1, 3, 5, 4, 6, 7)
    val k = 2
    // Output
    LeetCode_1535().getWinner(arr, k).run {
        println(this)
        require(5 == this)
    }
}
