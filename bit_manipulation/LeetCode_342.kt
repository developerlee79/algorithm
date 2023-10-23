package bit_manipulation

class LeetCode_342 {

    fun isPowerOfFour(n: Int) = n > 0 && n and n - 1 == 0 && n.countTrailingZeroBits() % 2 == 0

}

fun main() {
    // Input
    val n = 16
    // Output
    LeetCode_342().isPowerOfFour(n).run {
        println(this)
        require(this)
    }
}
