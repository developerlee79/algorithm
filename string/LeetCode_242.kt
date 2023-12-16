package string

class LeetCode_242 {

    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) {
            return false
        }

        val frequencyMap = IntArray(26)

        s.forEach {
            frequencyMap[it - 'a']++
        }

        t.forEach {
            if (frequencyMap[it - 'a'] == 0) {
                return false
            }

            frequencyMap[it - 'a']--
        }

        return true
    }
}

fun main() {
    // Input
    val s = "anagram"
    val t = "nagaram"
    // Output
    LeetCode_242().isAnagram(s, t).run {
        println(this)
        require(this)
    }
}
