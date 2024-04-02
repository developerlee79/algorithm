package string

class LeetCode_205 {

    fun isIsomorphic(s: String, t: String): Boolean {
        val charMap = hashMapOf<Char, Char>()
        val checked = hashSetOf<Char>()

        for (i in s.indices) {
            val sc = s[i]
            val tc = t[i]

            if (charMap.containsKey(sc)) {
                if (charMap[sc]!! != tc) {
                    return false
                }
            } else if (checked.contains(tc)) {
                return false
            }

            charMap[sc] = tc
            checked.add(tc)
        }

        return true
    }
}

fun main() {
    // Input
    val s = "egg"
    val t = "add"
    // Output
    LeetCode_205().isIsomorphic(s, t).run {
        println(this)
        require(this)
    }
}
