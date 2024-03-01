package string

class LeetCode_2864 {

    fun maximumOddBinaryNumber(s: String): String {
        val n = s.length

        var bitCount = -1

        s.forEach {
            if (it == '1') {
                bitCount++
            }
        }

        return "1".repeat(bitCount) + "0".repeat(n - (bitCount + 1)) + "1"
    }
}

fun main() {
    // Input
    val s = "010"
    // Output
    LeetCode_2864().maximumOddBinaryNumber(s).run {
        println(this)
        require("001" == this)
    }
}
