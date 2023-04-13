package bit_manipulation

class LeetCode_461 {

    fun hammingDistance(x: Int, y: Int) =
        Integer.bitCount(x xor y)
}

fun main() {
    // Input
    val x = 1
    val y = 4
    // Output
    LeetCode_461().hammingDistance(x, y).let {
        println(it)
        require(2 == it)
    }
}
