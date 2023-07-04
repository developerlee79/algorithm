package bit_manipulation

class LeetCode_137 {

    fun singleNumber(nums: IntArray): Int {
        var total = 0

        repeat (32) { i ->
            if (nums.sumOf { it.shr(i) and 1 } % 3 != 0) {
                total += 1.shl(i)
            }
        }

        return total
    }
}

fun main() {
    // Input
    val nums = intArrayOf(2, 2, 3, 2)
    // Output
    LeetCode_137().singleNumber(nums).run {
        println(this)
        require(3 == this)
    }
}
