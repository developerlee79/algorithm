package string

class LeetCode_2351 {

    /**
     * Solution - Set
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     *
     * If set contains char, return it.
     *
     * @param s string consisting of lowercase English letters
     * @return first letter to appear twice
    */
    fun repeatedCharacter(s: String): Char {
        val charSet = mutableSetOf<Char>()

        for (c in s) {
            if (charSet.contains(c)) {
                return c
            }
            charSet.add(c)
        }

        return 'a'
    }
}

fun main() {
    val s = "abccbaacz"
    println(LeetCode_2351().repeatedCharacter(s))
}
