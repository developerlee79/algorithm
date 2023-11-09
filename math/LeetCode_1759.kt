package math

class LeetCode_1759 {

    fun countHomogenous(s: String): Int {
        val n = s.length

        var count: Long = 0
        var i = 0

        while (i < n) {
            val currentChar = s[i++]

            var homogenousCount: Long = 1

            while (i < n && currentChar == s[i]) {
                homogenousCount++
                i++
            }

            count += (homogenousCount * (homogenousCount + 1) / 2).mod(1000000007)
        }

        return count.mod(1000000007)
    }

}

fun main() {
    // Input
    val s = "abbcccaa"
    // Output
    LeetCode_1759().countHomogenous(s).run {
        println(this)
        require(13 == this)
    }
}
