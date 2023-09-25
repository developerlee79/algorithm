package string

class LeetCode_389 {

    fun findTheDifference(s: String, t: String) = (t.sumOf { it.code } - s.sumOf { it.code }).toChar()

}

fun main() {
    // Input
    val s = "abcd"
    val t = "abcde"
    // Output
    LeetCode_389().findTheDifference(s, t).run {
        println(this)
        require('e' == this)
    }
}
