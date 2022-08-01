package string

class LeetCode_2309 {

    /**
     * Solution - Set
     * Time Complexity : O(N)
     * Space Complexity : O(1)
     *
     * Use set to find duplicate letter.
     *
     * @param s string
     * @return greatest English letter which occurs as both a lowercase and uppercase letter in s
    */
    fun greatestLetter(s: String): String {
        val letterSet = mutableSetOf<Char>()
        var maxChar = '0'
        for (c in s) {
            if ((c.isUpperCase() && letterSet.contains(c.lowercaseChar())) || (c.isLowerCase() && letterSet.contains(c.uppercaseChar()))) {
                maxChar = if (maxChar < c.uppercaseChar()) c.uppercaseChar() else maxChar
            }
            letterSet.add(c)
        }
        return if (maxChar == '0') "" else maxChar.toString()
    }
}

fun main() {
    val s = "lEeTcOdE"
    println(LeetCode_2309().greatestLetter(s))
}
