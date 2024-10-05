package two_pointers

class LeetCode_567 {

    fun checkInclusion(s1: String, s2: String): Boolean {
        val firstStrLength = s1.length
        val secondStrLength = s2.length

        if (firstStrLength > secondStrLength) {
            return false
        }

        val firstArray = IntArray('a'.code + 26)
        val secondArray = IntArray('a'.code + 26)

        for (c in s1.toCharArray()) {
            firstArray[c.code]++
        }

        for (i in s2.indices) {
            secondArray[s2[i].code]++

            if (i + 1 > firstStrLength) {
                secondArray[s2[i - firstStrLength].code]--
            }

            if (equalArray(firstArray, secondArray)) {
                return true
            }
        }

        return false
    }

    private fun equalArray(firstArray: IntArray, secondArray: IntArray): Boolean {
        repeat (26) {
            val currentChar = 'a'.code + it

            if (firstArray[currentChar] != secondArray[currentChar]) {
                return false
            }
        }

        return true
    }
}

fun main() {
    // Input
    val s1 = "ab"
    val s2 = "eidbaooo"
    // Output
    LeetCode_567().checkInclusion(s1, s2).run {
        println(this)
        require(this)
    }
}
