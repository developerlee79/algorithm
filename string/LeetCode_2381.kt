package string

class LeetCode_2381 {

    fun shiftingLetters(s: String, shifts: Array<IntArray>): String {
        val letterArray = s.toCharArray()
        val rangeSum = IntArray(s.length + 1)

        shifts.forEach { shift ->
            val added = if (shift[2] == 1) 1 else -1
            rangeSum[shift[0]] += added
            rangeSum[shift[1] + 1] -= added
        }

        var prefix = 0

        for (i in letterArray.indices) {
            prefix += rangeSum[i]
            letterArray[i] = 'a' + findLetterIndex(letterArray[i], prefix)
        }

        return letterArray.concatToString()
    }

    private fun findLetterIndex(letter: Char, prefix: Int): Int {
        var shiftCount = (letter - 'a' + prefix) % 26
        if (shiftCount < 0) shiftCount += 26
        return shiftCount
    }
}

fun main() {
    // Input
    val s = "abc"
    val shifts = arrayOf(
        intArrayOf(0, 1, 0),
        intArrayOf(1, 2, 1),
        intArrayOf(0, 2, 1),
    )
    // Output
    LeetCode_2381().shiftingLetters(s, shifts).run {
        println(this)
        require("ace" == this)
    }
}
