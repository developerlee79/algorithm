package bit_manipulation

class LeetCode_1318 {

    private fun Int.toBinaryStringOfMaxLength(b: Int, c: Int): Triple<String, String, String> {
        val aBinaryString = this.toString(2)
        val aBinaryStringLength = aBinaryString.length

        val bBinaryString = b.toString(2)
        val bBinaryStringLength = bBinaryString.length

        val cBinaryString = c.toString(2)
        val cBinaryStringLength = cBinaryString.length

        val maxLength = maxOf(
            aBinaryStringLength,
            bBinaryStringLength,
            cBinaryStringLength
        )

        return Triple(
            "0".repeat(maxLength - aBinaryStringLength) + aBinaryString,
            "0".repeat(maxLength - bBinaryStringLength) + bBinaryString,
            "0".repeat(maxLength - cBinaryStringLength) + cBinaryString
        )
    }

    fun minFlips(a: Int, b: Int, c: Int): Int {
        val strings = a.toBinaryStringOfMaxLength(b, c)
        val maxLength = strings.first.length

        var flipCount = 0

        repeat(maxLength) {
            if (strings.third[it] == '0') {
                if (strings.first[it] == '1') {
                    flipCount++
                }
                if (strings.second[it] == '1') {
                    flipCount++
                }
            } else {
                if (strings.first[it] != '1' && strings.second[it] != '1') {
                    flipCount++
                }
            }
        }

        return flipCount
    }
}

fun main() {
    // Input
    val a = 2
    val b = 6
    val c = 5
    // Output
    LeetCode_1318().minFlips(a, b, c).run {
        println(this)
        require(3 == this)
    }
}
