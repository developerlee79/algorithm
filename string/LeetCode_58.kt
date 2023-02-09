package string

class LeetCode_58 {

    fun lengthOfLastWord(s: String) =
        s.trimEnd().let { it.lastIndex - it.lastIndexOf(' ') }
}

fun main() {
    // Input
    val s = "Hello World"
    // Output
    LeetCode_58().lengthOfLastWord(s).let {
        println(it)
        require(it == 5)
    }
}
