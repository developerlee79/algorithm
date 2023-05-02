package array

class LeetCode_1822 {

    fun arraySign(nums: IntArray): Int {
        var sign = 1

        nums.forEach {
            if (it == 0)
                return 0
            else if (it < 0)
                sign = -sign
        }

        return sign
    }
}

fun main() {
    // Input
    val nums = intArrayOf(-1, -2, -3, -4, 3, 2, 1)
    // Output
    LeetCode_1822().arraySign(nums).run {
        println(this)
        require(1 == this)
    }
}
