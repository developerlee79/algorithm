package string

class LeetCode_2278 {

    /**
     * Solution - Divide
     * Time Complexity : O(N)
     * Space Complexity : O(1)
     *
     * Just.. calculate it.
     *
     * @param s string
     * @param letter character
     * @return percentage of characters in s that equal letter rounded down to the nearest whole percent
    */
    fun percentageLetter(s: String, letter: Char): Int {
        var count = 0

        for (c in s)
            if (c == letter)
                count++

        return if (count == 0)
            0
        else
            count * 100 / s.length
    }
}

fun main() {
    val s = "uhrzdkchossxszoi"
    println(s.length)
    val letter = 's'
    println(LeetCode_2278().percentageLetter(s, letter))
}
