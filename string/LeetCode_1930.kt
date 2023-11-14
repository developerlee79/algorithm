package string

class LeetCode_1930 {

    fun countPalindromicSubsequence(s: String): Int {
        val subsequenceArray = Array(28) { IntArray(2) { -1 } }

        for (i in s.indices) {
            val currentChar = s[i]
            val currentSubsequence = subsequenceArray[currentChar - 'a']

            if (currentSubsequence[0] == -1) {
                currentSubsequence[0] = i
            } else {
                currentSubsequence[1] = i
            }
        }

        var palindromeCount = 0

        for (subsequence in subsequenceArray) {
            val visited = HashSet<Char>()

            for (i in subsequence[0] + 1 until subsequence[1]) {
                visited.add(s[i])
            }

            palindromeCount += visited.size
        }

        return palindromeCount
    }

}

fun main() {
    // Input
    val s = "aabca"
    // Output
    LeetCode_1930().countPalindromicSubsequence(s).run {
        println(this)
        require(3 == this)
    }
}
