package math

class LeetCode_367 {

    fun isPerfectSquare(num: Int): Boolean {
        if (num == 1) {
            return true
        }

        var left = 1
        var right = num

        while (left <= right) {
            val middle = (right - left) / 2 + left

            if (middle.times(middle) == num) {
                return true
            } else if (middle < num / middle) {
                left = middle + 1
            } else {
                right = middle - 1
            }
        }

        return false
    }
}

fun main() {
    // Input
    val num = 16
    // Output
    LeetCode_367().isPerfectSquare(num).run {
        println(this)
        require(this)
    }
}
