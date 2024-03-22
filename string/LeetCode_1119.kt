package string

class LeetCode_1119 {

    fun removeVowels(s: String) = s.replace(Regex("[(aeiou)]"), "")
}

fun main() {
    // Input
    val s = "leetcodeisacommunityforcoders"
    // Output
    LeetCode_1119().removeVowels(s).run {
        println(this)
        require("ltcdscmmntyfrcdrs" == this)
    }
}
