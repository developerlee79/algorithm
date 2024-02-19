package bit_manipulation

class LeetCode_231 {

    fun isPowerOfTwo(n: Int) = n > 0 && (n and n - 1) == 0
}

fun main() {
    // Input
    val n = 1
    // Output
    LeetCode_231().isPowerOfTwo(n).run {
        println(this)
        require(this)
    }
}
