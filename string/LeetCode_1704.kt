package string

class LeetCode_1704 {

    private val vowelSet = hashSetOf(
        'a', 'e', 'i', 'o', 'u',
        'A', 'E', 'I', 'O', 'U'
    )

    fun halvesAreAlike(s: String): Boolean =
        s.substring(0 until s.length / 2).count { vowelSet.contains(it) } == s.substring(s.length / 2 until s.length).count { vowelSet.contains(it) }
}

fun main() {
    // Input
    val s = "textbook"
    // Output
    val result = LeetCode_1704().halvesAreAlike(s)
    println(result)
    require(!result)
}
