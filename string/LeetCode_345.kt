package string

class LeetCode_345 {

    /**
     * Solution : Two Pointers
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     *
     * @param s string
     * @return return string which reverse only all the vowels in it
    */
    fun reverseVowels(s: String): String {
        val vowelSet = setOf('a', 'e', 'o', 'u', 'i', 'A', 'E', 'O', 'U', 'I')

        var i = 0
        var j = s.lastIndex

        val charArray = s.toCharArray()

        while (i < j) {
            val firstChar = s[i]
            val secondChar = s[j]

            if (vowelSet.contains(firstChar) && vowelSet.contains(secondChar)) {
                swap(charArray, i, j)
                i++
                j--
            } else if (vowelSet.contains(firstChar)) {
                j--
            } else if (vowelSet.contains(secondChar)) {
                i++
            } else {
                i++
                j--
            }
        }

        return charArray.concatToString()
    }

    private fun swap(charArray: CharArray, x: Int, y: Int) {
        val tmp = charArray[x]
        charArray[x] = charArray[y]
        charArray[y] = tmp
    }
}

fun main() {
    // Input
    val s = "hello"
    // Output
    val result = LeetCode_345().reverseVowels(s)
    println(result)
    require(result == "holle")
}
