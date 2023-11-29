package bit_manipulation

class LeetCode_191 {

    fun hammingWeight(n: Int) = n.toUInt().countOneBits()

}

fun main() {
    // Input
    val n = 11
    // Output
    LeetCode_191().hammingWeight(n).run {
        println(this)
        require(3 == this)
    }
}
