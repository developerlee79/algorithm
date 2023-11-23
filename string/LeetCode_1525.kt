package string

class LeetCode_1525 {

    fun numSplits(s: String): Int {
        val frequencyMap = IntArray(28)
        var distinctCount = 0

        for (char in s) {
            if (frequencyMap[char - 'a'] == 0) {
                distinctCount++
            }

            frequencyMap[char - 'a']++
        }

        var goodSplits = 0
        val leftSet = HashSet<Char>()

        for (i in 0 until s.lastIndex) {
            leftSet.add(s[i])

            frequencyMap[s[i] - 'a']--

            if (frequencyMap[s[i] - 'a'] == 0) {
                distinctCount--
            }

            if (leftSet.size == distinctCount) {
                goodSplits++
            }
        }

        return goodSplits
    }
}

fun main() {
    // Input
    val s = "aacaba"
    // Output
    LeetCode_1525().numSplits(s).run {
        println(this)
        require(2 == this)
    }
}
