package math

class LeetCode_1903 {

    fun largestOddNumber(num: String): String {
        for (i in num.indices.reversed()) {
            if (num[i].digitToInt() % 2 != 0) {
                return num.substring(0..i)
            }
        }

        return ""
    }
}

fun main() {
    // Input
    val num = "52"
    // Output
    LeetCode_1903().largestOddNumber(num).run {
        println(this)
        require("5" == this)
    }
}
