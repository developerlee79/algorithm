package string

class LeetCode_387 {

    /**
     * Solution - Map
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     *
     * Use counting map to solve the problem.
     *
     * @param s string
     * @return index of first non-repeating character in s
    */
    fun firstUniqChar(s: String): Int {
        val charMap: MutableMap<Char, Int> = mutableMapOf()

        for (i in s.indices) {
            charMap.merge(s[i], 1, Int::plus)
        }

        for (i in s.indices) {
            if (charMap[s[i]] == 1) {
                return i
            }
        }

        return -1
    }
}

fun main() {
    val s = "leetcode"
    println(LeetCode_387().firstUniqChar(s))
}